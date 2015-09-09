package com.snapdeal.messaging.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

	@Resource
	private Environment environment;

	@Bean
	public DataSource datasource(){
		BoneCPDataSource dataSource= new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("driverName"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("jdbcURL"));
		dataSource.setUsername(environment.getRequiredProperty("login"));
		dataSource.setPassword(environment.getRequiredProperty("password"));
		return dataSource;

	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		return new JdbcTemplate(datasource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(datasource());
	}
}