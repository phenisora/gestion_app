package sn.epf.gestion_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class GestionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAppApplication.class, args);
	}

}
