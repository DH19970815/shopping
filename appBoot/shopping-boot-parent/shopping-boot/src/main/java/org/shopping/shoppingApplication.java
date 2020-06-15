package org.shopping;

import org.shopping.boot.common.cors.GlobalCorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({GlobalCorsConfig.class})
@ComponentScan("org.shopping.boot.common.cors")
public class shoppingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(shoppingApplication.class, args);
	}

}
