package com.example.crudapp.specification;

import com.example.crudapp.model.Task;
import com.example.crudapp.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

/**
 * Specification class for building criteria queries for {@link Task}.
 * Used for filtering purpose based on different attributes and creates the dynamic queries.
 */
public class TaskSpecification {
    private TaskSpecification() {}
    public static Specification<Task> hasStatus(String status) {
        return (root, query, cb) -> StringUtils.isNullOrEmpty(status) ? null : cb.equal(root.get("status"), status);
    }

    public static Specification<Task> hasPriority(String priority) {
        return (root, query, criteriaBuilder) -> StringUtils.isNullOrEmpty(priority) ? null : criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> generalSearch(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isNullOrEmpty(keyword)) {
                return null;
            }
            String searchPattern = "%" + keyword.toLowerCase() + "%";
            Predicate titlePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), searchPattern);
            Predicate descriptionPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), searchPattern);
            return criteriaBuilder.or(titlePredicate, descriptionPredicate);
        };
    }
}
