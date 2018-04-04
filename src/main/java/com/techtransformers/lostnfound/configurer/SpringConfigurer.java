package com.techtransformers.lostnfound.configurer;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.techtransformers.lostnfound")
@EnableTransactionManagement
@PropertySource("classpath:database-details.properties")
public class SpringConfigurer extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment environment;

	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("ds.database-driver"));
		dataSource.setUrl(environment.getProperty("ds.url"));
		dataSource.setUsername(environment.getProperty("ds.username"));
		dataSource.setPassword(environment.getProperty("ds.password"));
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("current_session_context_class", environment.getProperty("current_session_context_class"));
		
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setPackagesToScan(new String[] {"com.techtransformers.lostnfound.entity"});
		lsfb.setDataSource(dataSource);
		lsfb.setHibernateProperties(properties);
		lsfb.afterPropertiesSet();
		SessionFactory sessionFactory = lsfb.getObject();
		
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	
}
