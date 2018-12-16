package com.library.library.service;

import com.library.library.model.Genre;
import com.library.library.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    public LinkedHashMap<String, String> getGenresMap() {

        LinkedHashMap<String, String> genresMap = new LinkedHashMap<>();
        for (Genre genre : findAll()) {
            genresMap.put(String.valueOf(genre.getGenreID()), genre.getGenreName());
        }

        return genresMap;
    }

    @Override
    public Genre getById(Integer id){
        return genreRepository.findByGenreID(id);
    }
}
