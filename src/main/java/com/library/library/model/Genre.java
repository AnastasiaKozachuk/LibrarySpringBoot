package com.library.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    @NotNull
    private Integer genreID;

    @Column(name = "name_of_genre")
    @NotNull
    private String genreName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "content_genre",
            joinColumns = @JoinColumn(name = "genre_fk"),
            inverseJoinColumns = @JoinColumn(name = "content_fk")
    )
    private List<Content> contentList;

    public Integer getGenreID() {
        return genreID;
    }

    public void setGenreID(Integer genreID) {
        this.genreID = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public void add(Content content) {

        if (contentList == null) {
            contentList = new ArrayList<>();
        }

        contentList.add(content);
    }

}
