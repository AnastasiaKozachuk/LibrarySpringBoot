package com.library.library.service;

import com.library.library.model.Genre;

import java.util.LinkedHashMap;
import java.util.List;

public interface GenreService {

    List<Genre> findAll();
    LinkedHashMap<String, String> getGenresMap();
    Genre getById(Integer id);

}
