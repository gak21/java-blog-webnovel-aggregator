package com.webnovelscrossroads.config.spring;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.webnovelscrossroads.rss.TRss;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySources({ @PropertySource("classpath:/spring/environment.properties") })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.webnovelscrossroads.dao")
@EnableCaching
public class DatasourceConfig {
	@Autowired
	Environment env;

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		factory.setPackagesToScan("com.webnovelscrossroads.model");
		factory.setDataSource(dataSource());
		factory.setJpaProperties(hibernateProperties());

		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProps = new Properties();
		hibernateProps.put("hibernate.dialect",
				env.getRequiredProperty("hibernate.dialect"));
		hibernateProps.put("hibernate.show_sql",
				env.getRequiredProperty("hibernate.show_sql"));
		hibernateProps.put("hibernate.hbm2ddl.auto",
				env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return hibernateProps;
	}

	@Bean
	public DataSource dataSource() {
		final HikariDataSource ds = new HikariDataSource();
		ds.setMaximumPoolSize(100);
		ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		ds.addDataSourceProperty("url", env.getProperty("dataSource.url"));
		ds.addDataSourceProperty("user", env.getProperty("dataSource.username"));
		ds.addDataSourceProperty("password",
				env.getProperty("dataSource.password"));
		ds.addDataSourceProperty("cachePrepStmts", true);
		ds.addDataSourceProperty("prepStmtCacheSize", 250);
		ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		//ds.addDataSourceProperty("useServerPrepStmts", true);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(TRss.class);
		return marshaller;
	}

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}

}
