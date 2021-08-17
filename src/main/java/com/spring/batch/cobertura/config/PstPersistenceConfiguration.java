package com.spring.batch.cobertura.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.spring.batch.cobertura.repository" }, entityManagerFactoryRef = "pstEntityManager", transactionManagerRef = "pstTransactionManager")
@ComponentScan(basePackages = "com.spring.batch.cobertura.repository")
public class PstPersistenceConfiguration {
	

	@Bean("pstDataSource")
	public DataSource pstDataSource(Environment env) {
		Decryptor decryptor = new Decryptor(); 
		return DataSourceBuilder.create() //
				.url(env.getProperty("spring.datasource.url"))
				.username(env.getProperty("spring.datasource.username"))
				.password(decryptor.stringDecrypt(env.getProperty("spring.datasource.password"), "c0mfen4lc0"))
				.driverClassName(env.getProperty("spring.datasource.driverClassName"))
				.type(HikariDataSource.class).build();
	}

	@Bean("pstEntityManager")
	public LocalContainerEntityManagerFactoryBean pstEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("pstDataSource") DataSource dataSource) {
		final HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
		properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

		final LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource)
				.packages("com.spring.batch.cobertura.entity").persistenceUnit("pstPU").build();
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean("pstTransactionManager")
	public PlatformTransactionManager pstTransactionManager(
			@Qualifier("pstEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean("pstJdbcTemplate")
	public JdbcTemplate pstJdbcTemplate(@Qualifier("pstDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("pstNamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate pstNamedParameterJdbcTemplate(
			@Qualifier("pstDataSource") DataSource configDataSource) {
		return new NamedParameterJdbcTemplate(configDataSource);
	}
}
