package org.open.library.app;

import org.open.library.data.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackageClasses = {org.open.library.data.Book.class})
@EnableJpaRepositories(basePackageClasses = {org.open.library.data.BookRepository.class})
@SpringBootApplication( scanBasePackages = {"org.open.library"})
public class AppApplication {



	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
