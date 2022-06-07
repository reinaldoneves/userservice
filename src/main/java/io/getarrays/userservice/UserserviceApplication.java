package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Pixinguinha","pixinguinha", "123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Moacir Santos","moacir_santos", "123456", new ArrayList<>()));			userService.saveUser(new User(null, "User full name","username", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Garoto","garoto", "123456", new ArrayList<>()));			userService.saveUser(new User(null, "User full name","username", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Baden Powell","baden_powell", "123456", new ArrayList<>()));

			userService.addRoleToUser("pixinguinha", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("moacir_santos", "ROLE_USER");
			userService.addRoleToUser("moacir_santos", "ROLE_MANAGER");
			userService.addRoleToUser("garoto", "ROLE_MANAGER");
			userService.addRoleToUser("baden_powell", "ROLE_USER");
			userService.addRoleToUser("baden_powell", "ROLE_ADMIN");

		};
	}

	//TODO: Continua daqui parça: https://youtu.be/VVn9OG9nfH0?t=2855

}
