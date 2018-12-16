package com.library.library.repository;

import com.library.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByGenreID(Integer genreID);
}
