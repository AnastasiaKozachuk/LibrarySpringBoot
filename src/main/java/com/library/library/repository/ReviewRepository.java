package com.library.library.repository;

import com.library.library.model.Content;
import com.library.library.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByContent(Content content);

}
