package com.library.library.repository;

import com.library.library.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContentRepository extends JpaRepository<Content, Integer>, JpaSpecificationExecutor<Content> {

    Content findByContentID(Integer contentID);
}
