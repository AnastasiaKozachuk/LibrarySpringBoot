package com.library.library.controller;

import com.library.library.model.Account;
import com.library.library.model.Content;
import com.library.library.model.Review;
import com.library.library.service.AccountService;
import com.library.library.service.ContentService;
import com.library.library.service.GenreService;
import com.library.library.service.ReviewService;
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
import java.util.Collections;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ReviewService reviewService;

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

        return "redirect:saved";
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

        if (!allContent.isEmpty()) {
            model.addAttribute("elements", allContent);
        } else {
            model.addAttribute("notFound", "Nothing was found!");
        }
        model.addAttribute("options", genreService.findAll());

        return "commonContent";
    }

    @RequestMapping(value = "/saved", method = RequestMethod.GET)
    public String login(Model model) {
        return "savedSuccessfully";
    }

    @RequestMapping(value = "/showOne", method = RequestMethod.GET)
    public String showOneContent(@RequestParam("contentID") String contentId, Model model) {

        Content content = contentService.findById(Integer.valueOf(contentId));

        List<Review> allContentReview = reviewService.getAllReviewForContent(content);
        Collections.reverse(allContentReview);
        model.addAttribute("content", content);
        model.addAttribute("reviews", allContentReview);

        return "oneContentView";
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    public String addReview(@RequestParam(value = "mark", required = false) String mark, @RequestParam(value = "reviewText", required = false) String reviewText, @RequestParam(value = "contentID", required = false) String contentID, @RequestParam(value = "login", required = false) String login, Model model) {

        Content content = contentService.findById(Integer.valueOf(contentID));
        model.addAttribute("content", content);

        if (StringUtils.isEmpty(mark) || StringUtils.isEmpty(reviewText) || StringUtils.isEmpty(login)) {
            model.addAttribute("error", "Fields can't be empty");
            return "oneContentView";
        }

        Account account = accountService.findByLogin(login);

        if (account == null) {
            model.addAttribute("error", "Account with such login doesn't exist");
            return "oneContentView";
        }

        Review review = new Review();
        review.setMark(Integer.valueOf(mark));
        review.setReviewText(reviewText);
        review.setAccount(account);
        review.setContent(content);

        reviewService.save(review);

        List<Review> allContentReview = reviewService.getAllReviewForContent(content);
        Collections.reverse(allContentReview);
        model.addAttribute("reviews", allContentReview);

        return "oneContentView";
    }

}
