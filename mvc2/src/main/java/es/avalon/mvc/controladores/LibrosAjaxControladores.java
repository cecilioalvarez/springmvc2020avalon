package es.avalon.mvc.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/librosajax")
public class LibrosAjaxControladores {

	@RequestMapping("listaLibros")
	public String listaLibros() {
		
		return "listaLibrosajax";
	}
	
	
}
