package com.pedro.cruddemo;

import com.pedro.cruddemo.dao.StudentDAO;
import com.pedro.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// readStudent(studentDAO);


			// readAllStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);
			
			// deleteStudent(studentDAO);

			// readAllStudents(studentDAO);

			//deleteAllStudents(studentDAO);


			readAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numsRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numsRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Updating Student id: " + studentId);
		Student myStudent = studentDAO.findById(1);

		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	private void readAllStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> studentsList = studentDAO.findByLastName("Duck");

		// display list of students
		for(Student std : studentsList) {
			System.out.println(std);
		}

	}

	private void readAllStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findAll();

		// display list of student
		for (Student std : students) {
			System.out.println(std);
		}
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
