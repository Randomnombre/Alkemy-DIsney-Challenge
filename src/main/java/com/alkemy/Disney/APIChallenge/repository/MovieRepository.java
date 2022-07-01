package com.alkemy.Disney.APIChallenge.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.Disney.APIChallenge.models.MovieEntity;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

    List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
