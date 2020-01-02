package com.springbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springbatch.*")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class })
public class SpringbatchCsvtocsvApplication {
	public static void main(String[] argv) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbatchCsvtocsvApplication.class, argv);
		ctx.registerShutdownHook();
		SpringApplication.exit(ctx);
		}
}
