package com.library.library.service;

import com.library.library.model.Content;
import com.library.library.model.Review;
import com.library.library.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviewForContent(Content content) {
        return reviewRepository.findByContent(content);
    }
}
