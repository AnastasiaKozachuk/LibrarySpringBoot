package com.library.library.service;

import com.library.library.SearchCriteria;
import com.library.library.UserSpecification;
import com.library.library.model.Content;
import com.library.library.model.Genre;
import com.library.library.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private GenreService genreService;

    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public Content findById(Integer id) {
        return contentRepository.findByContentID(id);
    }

    @Override
    public List<Content> filterContent(String author, LocalDate date, String genre, String headline) {


        Genre genreOb = genreService.getById(Integer.valueOf(genre));

        UserSpecification spec1 = new UserSpecification(new SearchCriteria("author", author));
        UserSpecification spec2 = new UserSpecification(new SearchCriteria("date", date));
        UserSpecification spec3 = new UserSpecification(new SearchCriteria("genre", genreOb));
        UserSpecification spec4 = new UserSpecification(new SearchCriteria("headline", headline));

        return contentRepository.findAll(spec2.and(spec1).and(spec3).and(spec4));
    }


}
