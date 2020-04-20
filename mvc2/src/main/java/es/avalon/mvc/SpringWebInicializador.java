package es.avalon.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import es.avalon.mvc.controladores.LibrosController;

public class SpringWebInicializador implements WebApplicationInitializer {

	// cuando se arranca la aplicacion
	
	public void onStartup(ServletContext contenedor) throws ServletException {

		//registro el fichero que configura spring completo
		
		AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
		contexto.register(SpringConfigurador.class);
		contexto.setServletContext(contenedor);
		contexto.refresh();
		ServletRegistration.Dynamic servlet = contenedor.addServlet("dispatcher", new DispatcherServlet(contexto));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/*");

	}
}
