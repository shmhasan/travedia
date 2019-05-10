package com.mehedi.travedia.config.web;

import com.mehedi.travedia.config.database.HibernateConfig;
import com.mehedi.travedia.config.security.AppSecurity;
import com.mehedi.travedia.dao.auth.UserDao;
import com.mehedi.travedia.model.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


@Configuration
@PropertySource("classpath:application.properties")
@Import(AppSecurity.class)
public class TravediaApplication implements WebApplicationInitializer {


	public void onStartup(final ServletContext servletContext) throws ServletException {


		AnnotationConfigWebApplicationContext  rootContext = new AnnotationConfigWebApplicationContext();

		rootContext.register(App.class, HibernateConfig.class, AppSecurity.class);
//		rootContext.scan("com.mehedi");
		servletContext.addListener(new ContextLoaderListener(rootContext));

		ServletRegistration.Dynamic appServlet =
				servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));

		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");

	}
}
