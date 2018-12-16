package com.library.library.service;

import com.library.library.model.Content;
import com.library.library.model.Review;

import java.util.List;

public interface ReviewService {

    void save(Review review);
    List<Review> getAllReviewForContent(Content content);

}
