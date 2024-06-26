package com.pedro.cruddemo;

import com.pedro.cruddemo.dao.AppDAO;
import com.pedro.cruddemo.entity.Course;
import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;
import com.pedro.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
		//	createCourseAndReviews(appDao);

			retrieveCourseAndReviews(appDao);

			deleteCourseAndReviews(appDao);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDao) {
		int id = 10;

		System.out.println("Deletando Course ID: " + id);

		appDao.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(AppDAO appDao) {
		int id = 12;
		Course courseById = appDao.findCourseAndReviewByCourseId(id);

		System.out.println("Course: " + courseById);
		System.out.println("Comments in course: " + courseById.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDao) {
		Course c1 = new Course("Java para leigos completo!");
		Review rv1 = new Review("Adorei a aula");
		Review rv2 = new Review("melhor que Python");

		c1.addReview(rv1);
		c1.addReview(rv2);

		appDao.save(c1);

		// Mostrando o objeto na tela
		System.out.println("Curso e suas avaliações: " + c1.getReviews());
		System.out.println("Curso: " + c1.toString());
	}

	private void removeCourseById(AppDAO appDao) {
		int id = 10;
		System.out.println("Deleting Course By Id: " + id);
		appDao.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDao) {
		int id = 11;

		System.out.println("Updating course id:  " + id);
		Course courseById = appDao.findCourseById(id);
		courseById.setTitle("Testing new Title!");
		appDao.updateCourse(courseById);

		System.out.println("Updated course: " + appDao.findCourseById(id));
	}

	private void updateInstructor(AppDAO appDao) {
		int id = 1;

		System.out.println("Procurando instrcutor por id: " + id);
		Instructor tempInstructor = appDao.findInstructorById(id);

		System.out.println("Updating instructor...");
		tempInstructor.setLastName("TestLastName");
		tempInstructor.setFirstName("Test");
		appDao.updateInstructor(tempInstructor);


		System.out.println("Updated: " + appDao.findInstructorById(id));
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDao) {
		int id = 1;
		System.out.println("Procurando instrutor id: " + id);
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstrcutor: " + tempInstructor);
		System.out.println("Cursos associados: " + tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDao) {
		int id = 1;
		System.out.println("Procurando instrutor id: " + id);
		Instructor tempInstructor = appDao.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);

		// encontrar cursos pelo instrutor
		List<Course> courses = appDao.findCoursesByInstructorId(tempInstructor.getId());

		// associar objetos
		tempInstructor.setCourses(courses);
		System.out.printf("Cursos encontrados" + tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDao) {
		int id = 1;
		System.out.println("Procurando instrutor id: " + id);
		Instructor tempInstructor = appDao.findInstructorById(id);

		System.out.println("tempInstrcutor: " + tempInstructor);
		System.out.println("Cursos associados: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDao) {

		Instructor tempInstructor = new Instructor(
				"Pedro", "F", "pedro@email.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com/perdroCursos",
				"Programar!"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course c1 = new Course("Java Completo!");
		Course c2 = new Course("Futebol com Neymar!");
		tempInstructor.addCourse(c1);
		tempInstructor.addCourse(c2);

		appDao.save(tempInstructor);

		System.out.println("Cursos: " + tempInstructor.getCourses());
	}

	private void deleteInstructorDetail(AppDAO appDao) {
		int id = 4;
		System.out.println("Deleting InstructorDetail id: " + id);
		appDao.deleteInstructorDetailById(id);

	}

	private void findInstructorDetail(AppDAO appDao) {
		int id = 4;
		InstructorDetail instructorDetail = appDao.findInstructorDetailByiD(id);

		System.out.println("InstructorDetails by Id: " + instructorDetail);
		System.out.println("Instrutor associado: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDao) {
		int id = 1;
		System.out.println("Deleting id: " + id);
		appDao.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDao) {
		int id = 1;
		System.out.println("Procurando Instructor por id:" + id);

		Instructor tempInstructor = appDao.findInstructorById(id);

		System.out.println("TempInstructor: " +tempInstructor);
		System.out.println("InstructorDetail associado: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDao) {
		Instructor tempInstructor = new Instructor(
				"Chad", "Darby", "darby@email.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com/derbyChanel",
				"Java course!"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		/*
		NOTE: Irá salvar também TempInstructorDetail
		pois o Cascade.ALL está habilitado
		 */
		System.out.println("Saving instructor: " + tempInstructor);
		appDao.save(tempInstructor);
	}





}
