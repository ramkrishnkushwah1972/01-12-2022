package com.spring.data.jpa.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title", nullable = false, length = 255)
	private String title;
	
	@Column(name = "year_of_release")
	private int yearOfRelease;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToMany(mappedBy = "movies")
	private List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id, String title, int yearOfRelease, Genre genre, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
		this.actors = actors;
	}

	public Movie(String title, int yearOfRelease, Genre genre, List<Actor> actors) {
		super();
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
		this.actors = actors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", yearOfRelease=" + yearOfRelease + ", genre=" + genre
				+ ", actors=" + actors + "]";
	}
	
}