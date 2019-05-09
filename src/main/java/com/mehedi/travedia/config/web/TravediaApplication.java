package com.mehedi.travedia.config.web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


@Configuration
public class TravediaApplication implements WebApplicationInitializer {


	public void onStartup(final ServletContext servletContext) throws ServletException {


		AnnotationConfigWebApplicationContext  rootContext = new AnnotationConfigWebApplicationContext();

		rootContext.scan("com.mehedi");
		servletContext.addListener(new ContextLoaderListener(rootContext));

		ServletRegistration.Dynamic appServlet =
				servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));

		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
}
