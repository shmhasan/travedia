package com.mehedi.travedia.config.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.mehedi")
public class HibernateConfig {


    @Autowired
    private Environment environment;


    //hibernate properties


    public Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty(
                "hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty(
                "hibernate.dialect", environment.getProperty("hibernate.dialect"));

        properties.setProperty(
                "hibernate.show_sql", environment.getProperty("hibernate.show_sql"));


        return properties;
    }

    //session factory
    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());

        System.out.println("Property Files" + hibernateProperties());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.setPackagesToScan("com.mehedi.travedia");

        return  localSessionFactoryBean;
    }


    //datasource
    @Bean
    public DataSource dataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser(environment.getProperty("database.username"));
        mysqlDataSource.setPassword(environment.getProperty("database.password"));
        mysqlDataSource.setUrl(environment.getProperty("database.url"));

        return mysqlDataSource;
    }


    //transaction manager

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }




}
