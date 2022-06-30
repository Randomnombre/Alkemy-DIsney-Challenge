package com.alkemy.Disney.APIChallenge.repository.specifications;

import com.alkemy.Disney.APIChallenge.dto.CharacterFiltersDTO;
import com.alkemy.Disney.APIChallenge.models.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDto) {


        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDto.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDto.getName().toLowerCase() + "%"
                        )
                );
            }

            if (filtersDto.getAge() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("age"), filtersDto.getAge())
                );
            }

            if (filtersDto.getWeight() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("weight"), filtersDto.getWeight())
                );
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
