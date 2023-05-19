package com.ironhack.demo;

import com.ironhack.demo.enums.ActivityStatus;
import com.ironhack.demo.enums.InstructorStatus;
import com.ironhack.demo.models.*;
import com.ironhack.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
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

	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RollRepository rollRepository;
	@Override
	public void run(String... args) throws Exception {

		// List <User> userList = new ArrayList<>();

		User user1;
		User user2;
		User user3;
		User user4;

		List <User> userList = userRepository.saveAll(List.of(
				user1 = new User ("Claudia Alvarez","emailusuario1@gmail.com",4922180L, null),
		user2 = new User("Ana Sanchez","emaildeana@gmail.com",6784291L,null),
		user3 = new User ("Oriana Estevez","emaildeoriana1@gmail.com",4922383L, null),
		user4 = new User ("Laura Caceres","emaildelaura@gmail.com",5622180L, null)

		));

		//userRepository.saveAll(userList);

		Instructor instructor1;
		Instructor instructor2;
		Instructor instructor3;
		Instructor instructor4;
		Instructor instructor5;

		List <Instructor> instructors = instructorRepository.saveAll(List.of(

		instructor1 = new Instructor("Arlett","emaildearlett@gmail.com",338192L,null,644156303L,InstructorStatus.ON),
		instructor2 = new Instructor("Karem","emaildekarem@gmail.com",448325L,null,644156303L,InstructorStatus.ON),
		instructor3 = new Instructor("Daniel","emaildedaniel@gmail.com",60153277L,null,644156303L,InstructorStatus.BUSY),
		instructor4 = new Instructor("Kaitlyn","emaildekaitlyn@gmail.com",40151902L,null,644156303L,InstructorStatus.BUSY),
		instructor5 = new Instructor("Eva","emaildeeva@gmail.com",60153277L,null,644156303L,InstructorStatus.OFF)

		));

		Activity activity1;
		Activity activity2;
		Activity activity3;
		Activity activity4;
		Activity activity5;

		List <Activity> activityList = activityRepository.saveAll(List.of(
				activity1 = new Activity("Pole Fitness",new BigDecimal(19.99), ActivityStatus.AVAILABLE),
				activity2 = new Activity("Aerial Silks",new BigDecimal(19.99),ActivityStatus.AVAILABLE),
				activity3 = new Activity("Pole Exotic",new BigDecimal(24.99),ActivityStatus.WAITING_LIST),
				activity4 = new Activity("Aro",new BigDecimal(16.99),ActivityStatus.NOT_AVAILABLE),
				activity5= new Activity("Stretching",new BigDecimal(15.99),ActivityStatus.WAITING_LIST)

		));

		BookedActivity bookedActivity1;
		BookedActivity bookedActivity2;

		List <BookedActivity> bookedActivityList = bookedActivityRepository.saveAll(List.of(
				bookedActivity1 = new BookedActivity(user1,instructor4,activity3)
		));

		Admin admin1;
		Admin admin2;

		List <Admin> adminList = adminRepository.saveAll(List.of(
				admin1 = new Admin("Nathalia Aristigueta"),
				admin2 = new Admin("Pedro Alvarado")
		));

		Roll roll1 = new Roll("Jose Solera");

		rollRepository.save(roll1);


	}
}
