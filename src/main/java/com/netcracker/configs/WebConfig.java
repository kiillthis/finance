package com.netcracker.configs;

import com.netcracker.dao.AutoOperationDao;
import com.netcracker.dao.CreditOperationDao;
import com.netcracker.dao.UserDao;
import com.netcracker.dao.impl.AutoOperationDaoImpl;
import com.netcracker.dao.impl.CreditOperationDaoImpl;
import com.netcracker.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("com.netcracker")
@PropertySource("classpath:application.properties")
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(env.getProperty("jsp.prefix"));
        resolver.setSuffix(env.getProperty("jsp.suffix"));
        return resolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver-class-name"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        Locale.setDefault(Locale.ENGLISH);
        return new DataSourceTransactionManager(getDataSource());
    }

    @Bean(name = "userDao")
    public UserDao getUserDao() {
        return new UserDaoImpl(getDataSource());
    }


}