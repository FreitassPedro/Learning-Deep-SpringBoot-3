package com.pedro.cruddemo;

import com.pedro.cruddemo.dao.AppDAO;
import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDao) {
		return runner -> {
			createInstructor(appDao);

			// findInstructor(appDao);

			// deleteInstructor(appDao);


			// findInstructorDetail(appDao);
			// deleteInstructorDetail(appDao);
		};
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
		int id = 4;
		System.out.println("Deleting id: " + id);
		appDao.deleteById(id);
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
