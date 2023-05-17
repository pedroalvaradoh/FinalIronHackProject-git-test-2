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

import java.util.ArrayList;
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

		List <User> userList = new ArrayList<>();

		User user1;
		User user2;
		User user3;
		User user4;

		userList = userRepository.saveAll(List.of(
				user1 = new User ("Nathalia Aristigueta","emailusuario1@gmail.com",4922180L, null),
		user2 = new User("Ana Sanchez","emaildeana@gmail.com",6784291L,null),
		user3 = new User ("Oriana Estevez","emaildeoriana1@gmail.com",4922383L, null),
		user4 = new User ("Laura Caceres","emaildelaura@gmail.com",5622180L, null)

		));

		//userRepository.saveAll(userList);

		Instructor instructor1;
		Instructor instructor2;
		Instructor instructor3;

		List <Instructor> instructors = instructorRepository.saveAll(List.of(

		instructor1 = new Instructor("Arlett","emaildearlett@gmail.com",338192L,null,644156303L,InstructorStatus.ON),
		instructor2 = new Instructor("Karem","emaildekarem@gmail.com",448325L,null,644156303L,InstructorStatus.ON),
		instructor3 = new Instructor("Daniel","emaildedaniel@gmail.com",60153277L,null,644156303L,InstructorStatus.BUSY)));

	}
}
