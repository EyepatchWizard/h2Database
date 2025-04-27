package com.sazzad.h2Database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class H2DatabaseApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public H2DatabaseApplication(DataSource dataSource){
		this.dataSource = dataSource;
	}


	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Datasource =" + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
