package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SeriesServiceImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);

		System.out.println("\n\t\t\t\t\tTHIS IS FOR REGISTER\n");

		UserService service = applicationContext.getBean(UserService.class);
		Register register;
		register = new Register("as00001","ashu","ba","ashu@gmail.com","sdsad");
		register.setContactnumber(new BigDecimal("4563999188"));
		System.out.println(service.addUser(register));
		
		register = new Register("ab00002", "rajat", "singh", "rajas@gmail.com", "sdwww", null);
		register.setContactnumber(new BigDecimal("5678904235"));
		System.out.println(service.addUser(register));
		
		register = new Register("ab00003", "anuj", "singh", "asingh@gmail.com", "sdwGs", null);
		register.setContactnumber(new BigDecimal("788312390"));
		System.out.println(service.addUser(register));

		Optional<Register> register1 = null;

		try {
			register1 = service.getUserById("as00001");
			if (register1 != null) {
				System.out.println("Record found");
				System.out.println(register1.get());
			} else {
				System.out.println("record is not found");
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
				| InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Register>> optional1;
		try {
			optional1 = service.getAllUserDetails();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional1.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service.deleteUserById("as00001");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for (Register register2 : service.getAllUsers()) {
				if (register2 != null)
					System.out.println(register2);
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}


		System.out.println("\n\t\t\t\t\tTHIS IS FOR SUBSCRIPTION\n");

		SubscriptionService service2 = applicationContext.getBean(SubscriptionService.class);
		Subscription subscription;

		
		try {
			subscription = new Subscription("sub001", "2021-04-13", 2599.0f, "credit", "2022-04-013", "active", "annual",
					"false", "ab0001");
			String result= service2.addSubscription(subscription);
			System.out.println(result);
			
			subscription = new Subscription("sub002", "2020-04-13", 3000.0f, "credit", "2021-04-013", "inactive", "annual",
					"true", "ab0002");
			String result3 = service2.addSubscription(subscription);
			System.out.println(result3);

			subscription = new Subscription("sub003", "2019-04-13", 4580.0f, "netbanking", "2020-05-13", "inactive",
					"monthly", "false", "ab0003");
			String result4 = service2.addSubscription(subscription);
			System.out.println(result4);
		} catch (InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Optional<Subscription> subscription1 = null;

		try {
			subscription1 = service2.getSubscriptionById("sub009");
			System.out.println(subscription1.get());
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Subscription>> optional;
		try {
			optional = service2.getAllSubscription();
			if (optional.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service2.deleteSubscription("sub009");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Optional<List<Subscription>> optional8;
		try {
			optional8 = service2.getAllSubscription();
			if (optional8.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional8.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		System.out.println("\n\t\t\t\t\tTHIS IS FOR MOVIES\n");

		MovieService service3 = applicationContext.getBean(MovieService.class);
		Movie movie;

		movie = new Movie("mov009", "M1", "r1,r2,r3", 150, "2021-11-20", null, "english", "18", "action");
		String result13 = service3.addMovie(movie);
		System.out.println(result13);

		movie = new Movie("mov0010", "M2", "r2,r3,r4", 134, "2021-09-20", null, "hindi", "18",
				"comedy");
		String result5 = service3.addMovie(movie);
		System.out.println(result5);

		movie = new Movie("mov0011", "M3", "r1,r2,r3", 121, "2016-08-18", null, "english", "18", "sci-fi");
		String result6 = service3.addMovie(movie);
		System.out.println(result6);

		Optional<Movie> movie1 = null;

		try {
			movie1 = service3.getMovieById("mov009");
			System.out.println(movie1.get());
		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Movie>> optional2;
		try {
			optional2 = service3.getAllMovie();
			if (optional2.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional2.get().forEach(e -> System.out.println(e));
			}
		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service3.deleteMovie("mov009");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Optional<List<Movie>> optional3;
		try {
			optional3 = service3.getAllMovie();
			if (optional3.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional3.get().forEach(e -> System.out.println(e));
			}
		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		System.out.println("\n\t\t\t\tTHIS IS FOR SERIES\n");

		SeriesService service4 = applicationContext.getBean(SeriesService.class);
		Series series;

		series = new Series("ser009", "SR1", "r1, r2", "2014-02-25", null, "english", "18", "thriller", 59);
		String result1 = service4.addSeries(series);
		System.out.println(result1);

		series = new Series("ser010", "SR2", "r1, r2, r3", "2013-02-25", null, "hindi", "18", "thriller",
				12);
		String result7 = service4.addSeries(series);
		System.out.println(result7);

		series = new Series("ser011", "SR3", "r4, r3", "2015-02-25", null, "hindi", "18", "suspense, action",
				32);
		String result8 = service4.addSeries(series);
		System.out.println(result8);

		Optional<Series> series1 = null;

		try {
			series1 = service4.getSeriesById("ser009");
			System.out.println(series1.get());
		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Series>> optional4;
		try {
			optional4 = service4.getAllSeries();
			if (optional4.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional4.get().forEach(e -> System.out.println(e));
			}
		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service4.deleteSeries("ser009");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Optional<List<Series>> optional5;
		try {
			optional5 = service4.getAllSeries();
			if (optional5.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional5.get().forEach(e -> System.out.println(e));
			}

		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		System.out.println("\n\t\t\t\t\tTHIS IS FOR EPISODES\n");

		EpisodeService service5 = applicationContext.getBean(EpisodeService.class);
		Episodes episodes;

		episodes = new Episodes("epi001", "EN1", 35, "ser010");
		String result9 = service5.addEpisode(episodes);
		System.out.println(result9);

		episodes = new Episodes("epi002", "EN2", 27, "ser010");
		String result10 = service5.addEpisode(episodes);
		System.out.println(result10);

		episodes = new Episodes("epi003", "EN3", 31, "ser010");
		String result11 = service5.addEpisode(episodes);
		System.out.println(result11);

		episodes = new Episodes("epi004", "EN4", 38, "ser010");
		String result12 = service5.addEpisode(episodes);
		System.out.println(result12);

		episodes = new Episodes("epi005", "EN5", 45, "ser010");
		String result15 = service5.addEpisode(episodes);
		System.out.println(result15);

		episodes = new Episodes("epi006", "EN6", 23, "ser010");
		String result14 = service5.addEpisode(episodes);
		System.out.println(result14);

		Optional<Episodes> episodes1 = null;

		try {
			episodes1 = service5.getEpisodeById("epi003");
			System.out.println(episodes1.get());
		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		Optional<List<Episodes>> optional6;
		try {
			optional6 = service5.getAllEpisode();
			if (optional6.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional6.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		try {
			service5.deleteEpisode("epi003");
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Optional<List<Episodes>> optional7;
		try {
			optional7 = service5.getAllEpisode();
			if (optional7.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional7.get().forEach(e -> System.out.println(e));
			}

		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		applicationContext.close();

	}

}
