package com.alkemy.Disney.APIChallenge.repository.specifications;

import com.alkemy.Disney.APIChallenge.dto.MovieFiltersDTO;
import com.alkemy.Disney.APIChallenge.models.GenreEntity;
import com.alkemy.Disney.APIChallenge.models.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {

    public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDto) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDto.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + filtersDto.getTitle() + "%"
                        )
                );
            }

            if (filtersDto.getGenre_id() != null) {
                Join<GenreEntity, MovieEntity> join = root.join("movie", JoinType.INNER);
                Expression<String> genre_id = join.get("genre_id");
                predicates.add(
                        genre_id.in(filtersDto.getGenre_id())
                );
            }

            query.distinct(true);

            String orderByField = "dateOfCreation";
            query.orderBy(
                    filtersDto.isDESC() ?
                            criteriaBuilder.desc(root.get(orderByField)) :
                            criteriaBuilder.asc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
