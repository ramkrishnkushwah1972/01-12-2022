package com.spring.data.jpa.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.demo.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
	
	public Genre findByName(String name);
	
	Optional<Genre> findById(Long id);
	
	List<Genre> findAll();
	
	//void deleteAllByIdInBatch(Iterable<Genre> ids);
	void deleteById(Long id);
}