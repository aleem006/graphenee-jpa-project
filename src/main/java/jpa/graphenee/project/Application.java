package jpa.graphenee.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.graphenee.core.GrapheneeCoreConfiguration;

@SpringBootApplication
@EnableJpaRepositories({ GrapheneeCoreConfiguration.JPA_REPOSITORIES_BASE_PACKAGE ,"jpa.graphenee.project"})
@EntityScan({"jpa.graphenee.project", GrapheneeCoreConfiguration.ENTITY_SCAN_BASE_PACKAGE })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
 