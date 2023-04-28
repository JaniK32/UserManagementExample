package jk.test.users.storage;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
	    basePackages = "jk.test.users.dao", 
	    entityManagerFactoryRef = "entityManagerFactory", 
	    transactionManagerRef = "userTransactionManager"
)

@Configuration
public class UserDBConfiguration {
	
	@Autowired
    private Environment env;
	
	@Primary
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManager() {
	    LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(userDataSource());
	    em.setPackagesToScan(new String[] { "jk.test.users.dao" });
	
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    em.setJpaVendorAdapter(vendorAdapter);
	    HashMap<String, Object> properties = new HashMap<>();
	    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    em.setJpaPropertyMap(properties);
	
	    return em;
	}
	 
	@Primary
    @Bean
    public DataSource userDataSource() {
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

	@Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager userTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userEntityManager().getObject());
        return transactionManager;
    }
	 
}
