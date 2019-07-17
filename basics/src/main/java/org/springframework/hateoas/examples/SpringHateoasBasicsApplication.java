

package org.springframework.hateoas.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.server.core.EvoInflectorLinkRelationProvider;


@SpringBootApplication
public class SpringHateoasBasicsApplication {

	public static void main(String... args) {
		SpringApplication.run(SpringHateoasBasicsApplication.class);
	}

	
	
	@Bean
	EvoInflectorLinkRelationProvider relProvider() {
		return new EvoInflectorLinkRelationProvider();
	}
}
