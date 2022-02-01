package com.bigbell.noticeboard.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.bigbell.noticeboard")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	@Autowired 
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource
								= new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {

			throw new RuntimeException(exc);
		}
		
		logger.info(">>> jdbc.url=" +env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" +env.getProperty("jdbc.user"));
		
		securityDataSource.setJdbcUrl("jdbc.url");
		securityDataSource.setUser("jdbc.user");
		securityDataSource.setPassword("jdbc.password");
		
		securityDataSource.setInitialPoolSize(
				getInitProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setMinPoolSize(
				getInitProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setMaxPoolSize(
				getInitProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setMaxIdleTime(
				getInitProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}

	private int getInitProperty(String propName) {
		String propVal = env.getProperty(propName.trim());
		
		// now convert to int
		int intPropval = Integer.parseInt(propVal);
		
		return intPropval;
	}
}






















