package es.avalon.mvc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import es.avalon.dominio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/libros")
public class LibrosController {

	@Autowired
	private ServicioLibros servicio;
	
	
	@RequestMapping("/hola")
	public String hola() {

		return "hola";
	}

	@RequestMapping("/libro")
	public String libro(Model modelo) {

		modelo.addAttribute("libro", new Libro("1", "java", "pedro", 20));
		return "paginaLibro";
	}
	
	@RequestMapping("/listaLibros")
	public String listaLibros(Model modelo) {

		modelo.addAttribute("lista",servicio.buscarLibroTodos());
		return "listaLibros";
	}

}
