package com.library.library.controller;

import com.library.library.model.Content;
import com.library.library.model.Review;
import com.library.library.service.ContentService;
import com.library.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String createNewStory(Model model) {
        model.addAttribute("contentForm", new Content());
        model.addAttribute("options", genreService.getGenresMap());
        return "createContent";
    }


    @RequestMapping(value = "/createNew", method = RequestMethod.POST)
    public String saveNewStory(@Valid @ModelAttribute("contentForm") Content contentForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "createContent";
        }

        contentForm.setDate(LocalDate.now());

        contentService.save(contentForm);

        model.addAttribute("options", genreService.getGenresMap());
        model.addAttribute("success", "Story is saved successfully!");

        return "createContent";
    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String viewAllContent(Model model) {

        List<Content> allContent = contentService.getAllContent();

        model.addAttribute("elements", allContent);
        model.addAttribute("options", genreService.findAll());

        return "commonContent";
    }

    @RequestMapping(value = "/filterContent", method = RequestMethod.GET)
    public String filterContent(@RequestParam(value = "author", required = false) String author, @RequestParam(value = "genre", required = false) String genre, @RequestParam(value = "headline", required = false) String headline, @RequestParam(value = "date", required = false) String date, Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = null;

        if (!StringUtils.isEmpty(date)) {
            localDate = LocalDate.parse(date, formatter);
        }

        List<Content> allContent = contentService.filterContent(author, localDate, genre, headline);

        model.addAttribute("elements", allContent);
        model.addAttribute("options", genreService.findAll());

        return "commonContent";
    }

    @RequestMapping(value = "/showOne", method = RequestMethod.GET)
    public String showOneContent(@RequestParam("contentID") String contentId, Model model) {

        Content content = contentService.findById(Integer.valueOf(contentId));

        model.addAttribute("content", content);
        model.addAttribute("reviewForm", new Review());

        return "oneContentView";
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addReview(@Valid @ModelAttribute("reviewForm") Review reviewForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "oneContentView";
        }

        model.addAttribute("content", reviewForm.getContent());
        model.addAttribute("reviewForm", new Review());


        return "oneContentView";
    }

}
