package com.javaLearning.Training.RESTapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResTapisApplication implements CommandLineRunner {
	@Autowired(required = true)
	DB DBobj;
	public static void main(String[] args) {
		SpringApplication.run(ResTapisApplication.class, args);
		// to use prodDB we will have to make an object of that which could only be static 
		// so that it can be used in main function
		// but static variables can not be injected so we will prefer to make everything in run class of commandLineRunner interface
	}

	@Override
	public void run(String... args) throws Exception{
		// DBobj=new PrdDB(); without dependency injection

		System.out.println(DBobj.getData());
		// by creating an interface we can use prodDB and devDB on our choice
		// now to use devDB and prodDB at different times we have to use a devDB object which we dont want to do
		// for that we can create a interface
		// even with using interface and implementation we are still tightly coupled and depending on the
		// type of db we are using like prod/dev that's where dependency injection comes to rescue
	}
}
