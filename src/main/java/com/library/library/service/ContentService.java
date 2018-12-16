package com.library.library.service;

import com.library.library.model.Content;

import java.time.LocalDate;
import java.util.List;

public interface ContentService {

    void save(Content content);
    List<Content> getAllContent();
    Content findById(Integer id);
    List<Content> filterContent(String author, LocalDate date, String genre, String headline);

}
