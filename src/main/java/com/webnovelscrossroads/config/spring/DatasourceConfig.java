package com.webnovelscrossroads.config.spring;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.webnovelscrossroads.rss.TRss;

@Configuration
@EnableJpaRepositories(basePackages="com.webnovelscrossroads.dao")
@EnableTransactionManagement
@PropertySources({
	@PropertySource("classpath:/spring/environment.properties")
})
public class DatasourceConfig {
	@Autowired
	Environment env;
	
	 @Bean
	  public BasicDataSource dataSource() {
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));
		 dataSource.setUrl(env.getProperty("dataSource.url"));
		 dataSource.setUsername(env.getProperty("dataSource.username"));
		 dataSource.setPassword(env.getProperty("dataSource.password"));		 
	    return dataSource;
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory() {

		HibernatePersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setPersistenceProvider(persistenceProvider);
	    factory.setPackagesToScan("com.webnovelscrossroads.model");
	    factory.setJpaProperties(jpaProperties);
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
	  
	  @Bean
	  public Jaxb2Marshaller jaxb2Marshaller(){
		  Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		  marshaller.setClassesToBeBound(TRss.class);
		  return marshaller;
	  }
	

}
