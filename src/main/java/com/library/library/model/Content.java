package com.library.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @Column(name = "content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contentID;

    @Column(name = "author")
    @NotBlank(message = "Author can't be empty")
    private String author;

    @Column(name = "text")
    @NotBlank(message = "Story can't be empty")
    private String text;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "headline")
    @NotBlank(message = "Headline can't be empty")
    private String headline;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "content_fk")
    private List<Review> reviewList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="content_genre",
            joinColumns = @JoinColumn(name="content_fk"),
            inverseJoinColumns = @JoinColumn(name = "genre_fk")
    )
    private List<Genre> genres;


    public Integer getContentID() {
        return contentID;
    }

    public void setContentID(Integer contentID) {
        this.contentID = contentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void add(Review review) {

        if (reviewList == null) {
            reviewList = new ArrayList<>();
        }

        reviewList.add(review);
    }

    public void add(Genre genre) {

        if (genres == null) {
            genres = new ArrayList<>();
        }

        genres.add(genre);
    }

}
