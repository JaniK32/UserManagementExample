package jk.test.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({"jk.test.users"})
@ComponentScan({"jk.test.users.dao"})
@ComponentScan({"jk.test.users.controllers"})
@EntityScan("jk.test.users.dao")
@EnableJpaRepositories
@SpringBootApplication
public class UserManagement {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagement.class);
	
	public static void main(String[] args) {
		SpringApplication.run(UserManagement.class, args);
		LOG.info("User management is started.");
	}

}
