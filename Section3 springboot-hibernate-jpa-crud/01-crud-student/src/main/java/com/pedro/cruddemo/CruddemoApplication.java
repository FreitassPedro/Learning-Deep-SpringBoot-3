package com.pedro.cruddemo;

import com.pedro.cruddemo.dao.StudentDAO;
import com.pedro.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object;
		System.out.println("Creating a new object student");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

		// save the student
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		Student showStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + showStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple student
		System.out.println("Creating 3 objects");
		Student tempStudent1 = new Student("John", "Melt", "john@email.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@email.com");
		Student tempStudent3 = new Student("Bonit", "Apple", "bonit@email.com");

		// save the students objects
		System.out.println("Saving the studentrs");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Criando novo estudante");
		Student tempStudent = new Student("pedro", "f", "pedro@email.com");

		// salva o objeto estudante
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// mostra id do estudante salvo
		System.out.println("Saved student: " + tempStudent.getId());
	}

}
