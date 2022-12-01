package com.spring.data.jpa.demo.test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.data.jpa.demo.model.Actor;
import com.spring.data.jpa.demo.model.Genre;
import com.spring.data.jpa.demo.model.Movie;
import com.spring.data.jpa.demo.repository.ActorRepository;
import com.spring.data.jpa.demo.repository.GenreRepository;
import com.spring.data.jpa.demo.repository.MovieRepository;

@Controller
public class ActorGenreMovieController {
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public void run() {
		//Inserting
		
		// GenreRepository....
		Genre g1 = new Genre("Romantic", null);
		Genre g2 = new Genre("Action", null);
		Genre g3 = new Genre("Horror", null);
		
		//6.	Saving objects of type Genre to the database
		genreRepository.save(g1);
		genreRepository.save(g2);
		genreRepository.save(g3);
		
		// ActorRepository.....
		Actor a1 = new Actor("Sunil", "Shetti", 1960, null);
		Actor a2 = new Actor("Nana", "Patekar", 1955, null);
		Actor a3 = new Actor("Salman", "Khan", 1970, null);
		Actor a4 = new Actor("Karishma", "Kapoor", 1980, null);
		
		//7.	Saving objects of type Actor to the database
		actorRepository.save(a1);
		actorRepository.save(a2);
		actorRepository.save(a3);
		actorRepository.save(a4);	

		// MovieRepository....
		Movie m1 = new Movie("Chand ke Paar Chalo ", 1990, g1, null);
		Movie m2 = new Movie("Players", 2011, g2, null);
		Movie m3 = new Movie("Intelligent", 2022, g3, null);
		
		//16.	 adding Movie records to the database
		movieRepository.save(m1);
		movieRepository.save(m2);
		movieRepository.save(m3);
		
		//Displaying
		//9. searching Actor records by name
		System.out.println("\n\n Searching Actor records by name : \n ");
		Actor actor1 = actorRepository.findByName("Kiara");
				
		System.out.println(actor1.getId());
		System.out.println(actor1.getName());
		System.out.println(actor1.getLastName());
		System.out.println(actor1.getYearOfBirth());
		
		//10.	 searching for Actor records by id
		System.out.println("\n\n Searching for Actor records by id : \n ");
		Actor actor= actorRepository.findById(1L).get();
		
		System.out.println(actor.getId());
		System.out.println(actor.getName());
		System.out.println(actor.getLastName());
		System.out.println(actor.getYearOfBirth());
		
		//11.	 returning all Actor records
		System.out.println("\n\n Returning all Actor records : \n ");
		List<Actor> actor2 = actorRepository.findAll();
		
		actor2.forEach((a) -> {
	            System.out.println(a.getId());
	            System.out.println(a.getName());
	            System.out.println(a.getLastName());
	            System.out.println(a.getYearOfBirth());
	      });
		
		//8.	removing Actor record by id from the database
		System.out.println("\n\n Removing Actor record by id from the database : \n ");
		
		actorRepository.deleteById(1L);
		
		System.out.println("\n\n Returning all Actor records after removing : \n ");
		List<Actor> actor3 = actorRepository.findAll();
		
		actor3.forEach((a) -> {
            System.out.println(a.getId());
            System.out.println(a.getName());
            System.out.println(a.getLastName());
            System.out.println(a.getYearOfBirth());
		});
		
		//13. searching for Genre records by name
		System.out.println("\n\n Searching for Genre records by name : \n ");
		Genre genre1 = genreRepository.findByName("Action");
				
		System.out.println(genre1.getId());
		System.out.println(genre1.getName());
		
		//14. searching for Genre records by id
		System.out.println("\n\n Searching for Genre records by id : \n ");
		Genre genre = genreRepository.findById(1L).get();
		
		System.out.println(genre.getId());
		System.out.println(genre.getName());
		
		//15. returning all Genre records
		System.out.println("\n\n Returning all Genre records : \n ");
		List<Genre> genre2 = genreRepository.findAll();
		
		genre2.forEach((g) -> {
	            System.out.println(g.getId());
	            System.out.println(g.getName());
	      });
		
		//12.	 removing Genre records from the database
		System.out.println("\n\n Removing Genre records from the database : \n ");
		
		genreRepository.deleteById(1L);
		
		System.out.println("\n\n Returning all Genre records after removing : \n ");
		List<Genre> genre3 = genreRepository.findAll();
		
		genre3.forEach((g) -> {
            System.out.println(g.getId());
            System.out.println(g.getName());
			});
		
		//18.	 searching Movie records by title
		System.out.println("\n\n Searching Movie records by title : \n ");
		Movie movie1 = movieRepository.findByTitle("Shershah");
				
		System.out.println(movie1.getId());
		System.out.println(movie1.getTitle());
		System.out.println(movie1.getYearOfRelease());
		
		//19.  searching for Movie records by id
		System.out.println("\n\n Searching for Movie records by id : \n ");
		Movie movie = movieRepository.findById(1L).get();
		
		System.out.println(movie.getId());
		System.out.println(movie.getTitle());
		System.out.println(movie.getYearOfRelease());
		
		//20.	 returning all Movie records
		System.out.println("\n\n Returning all Movie records : \n ");
		List<Movie> movie2 = movieRepository.findAll();
		
		movie2.forEach((m) -> {
	            System.out.println(m.getId());
	            System.out.println(m.getTitle());
	            System.out.println(m.getYearOfRelease());         
	      });
		
		//17.	 removing Movie records from the database
		System.out.println("\n\n Removing Movie records from the database : \n ");
		
		movieRepository.deleteById(1L);
		
		System.out.println("\n\n Returning all Genre records after removing : \n ");
		List<Movie> movie3 = movieRepository.findAll();
		
		movie3.forEach((m) -> {
            System.out.println(m.getId());
            System.out.println(m.getTitle());
            System.out.println(m.getYearOfRelease());     
			});
		
	}
}