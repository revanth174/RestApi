package com.nvr.api.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration  implements WebApplicationInitializer{

	public void onStartup(ServletContext container) throws ServletException {
		
		AnnotationConfigWebApplicationContext context
		  = new AnnotationConfigWebApplicationContext();
		//This type of context can then be configured registering a configuration class:
		context.register(SpringConfig.class);
		
		container.addListener(new ContextLoaderListener(context));
		
		//The next step is creating and registering our dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container
				  .addServlet("dispatcher", new DispatcherServlet(context));
				 
				dispatcher.setLoadOnStartup(1);
				dispatcher.addMapping("/");
		
	}

}
