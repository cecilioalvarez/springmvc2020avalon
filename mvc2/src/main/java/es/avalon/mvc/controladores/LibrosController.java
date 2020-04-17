package es.avalon.mvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibrosController {
	
	// /libros/hola
	@RequestMapping("/hola")
	public String hola() {
		
		// sera devuelveme a la plantilla de hola
		return "hola";
	}

}
