package org.dentist.dentistapp;

import org.dentist.dentistapp.entities.Katalog_usluga;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication


public class DentistAppApplication {

	public static void main(String[] args){

		SpringApplication.run(DentistAppApplication.class, args);

	}

}
