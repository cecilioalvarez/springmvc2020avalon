package es.avalon.mvc.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.dominio.Categoria;
import es.avalon.dominio.Libro;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/libros")
public class LibrosController {

	@Autowired
	private ServicioLibros servicio;

	// /libros/hola
	@RequestMapping("/hola")
	public String hola() {

		// sera devuelveme a la plantilla de hola
		return "hola";
	}

	// /libros/libro
	@RequestMapping("/libro")
	public String libro(Model modelo) {

		modelo.addAttribute("libro", new Libro("1", "java", "pedro", 20));
		return "paginaLibro";
	}
	
		@RequestMapping("/formularioInsertar")
		public String formularioInsertar() {

			return "formularioInsertar";
		}
		
		@RequestMapping("/formularioInsertar")
		public String insertar(Libro libro,Model modelo, String categoria) {
			
			//Insertar
			System.out.println(libro.getIsbn());
			System.out.println(libro.getTitulo());
			Categoria c=servicio.buscarCategoriaPorNombre(categoria);
			libro.setCategoria(c);
			servicio.insertarLibro(libro);
			
			modelo.addAttribute("lista",servicio.buscarLibroTodos());
			return "formularioInsertar";
		}

	// /libros/listaLibros
//	@RequestMapping("/listaLibros")
//	public String listaLibros(Model modelo) {
//
//		ArrayList<Libro> lista = new ArrayList<Libro>();
//		lista.add(new Libro("1", "java", "pedro", 20));
//		lista.add(new Libro("2", "net", "ana", 30));
//		modelo.addAttribute("lista", lista);
//
//		return "listaLibros";
//	}
	
	// /libros/listaLibros
		@RequestMapping("/listaLibros")
		public String listaLibros(Model modelo) {

			modelo.addAttribute("lista", servicio.buscarLibroTodos());

			return "listaLibros";
		}
}
