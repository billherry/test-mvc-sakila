package com.billherry.mvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.billherry.mvc.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

	// List<Actor> findAll(Pageable page, Direction asc);
}
