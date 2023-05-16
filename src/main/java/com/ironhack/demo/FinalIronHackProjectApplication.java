package com.ironhack.demo;

import com.ironhack.demo.enums.InstructorStatus;
import com.ironhack.demo.models.BookedActivity;
import com.ironhack.demo.models.Instructor;
import com.ironhack.demo.models.User;
import com.ironhack.demo.repositories.BookedActivityRepository;
import com.ironhack.demo.repositories.InstructorRepository;
import com.ironhack.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FinalIronHackProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FinalIronHackProjectApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookedActivityRepository bookedActivityRepository;
	@Autowired
	InstructorRepository instructorRepository;
	@Override
	public void run(String... args) throws Exception {

		User user1;
		User user2;
		User user3;
		User user4;

		List <User> users = userRepository.saveAll(List.of(
				user1 = new User ("Nathalia Aristigueta","emailusuario1@gmail.com",4922180L, List.of(new BookedActivity()))));

		bookedActivityRepository.save(new BookedActivity(null,null,null));
		instructorRepository.save(new Instructor("Arlett","emaildearlett@gmail.com",4555555L,null,644156303L,InstructorStatus.ON,null));

	}
}
