package htf.medmanager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("htf.*")
public class MedManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedManagerApplication.class, args);
	}

}
