package com.library.library;

import com.library.library.model.Content;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<Content> {

    private SearchCriteria criteria;

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getKey().equals("author") && !StringUtils.isEmpty(criteria.getValue())) {
            String author = ((String) criteria.getValue()).toLowerCase();
            return builder.equal(builder.lower(root.get(criteria.getKey())), author);
        }

        if (criteria.getKey().equals("date") && criteria.getValue() != null) {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }

        if (criteria.getKey().equals("headline") && !StringUtils.isEmpty(criteria.getValue())) {
            String headline = ((String) criteria.getValue()).toLowerCase();
            return builder.equal(builder.lower(root.get(criteria.getKey())), headline);
        }

        if (criteria.getKey().equals("genre") && criteria.getValue() != null) {
            if (root.get("genres") != null) {
                return builder.isMember(criteria.getValue(), root.get("genres"));
            }
        }
        return null;
    }
}
