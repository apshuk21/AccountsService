package com.apoorva.accounts;

import com.apoorva.accounts.dtos.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(info = @Info(
		title = "Accounts microservices REST API Documentation",
		description = "Documentation of Global Gateway Bank Accounts microservices REST APIs",
		version = "v1",
		contact = @Contact(
				name = "Apoorva Shukla",
				email = "apshuk21@gmail.com"
		),
		license = @License(
				name = "Apache 2.0"
		)
))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
