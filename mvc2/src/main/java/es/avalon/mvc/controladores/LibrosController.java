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

		modelo.addAttribute("lista", servicio.buscarLibroTodos());
		return "listaLibros";
	}

	@RequestMapping("/formularioInsertar")
	public String formularioInsertar() {

		return "formularioInsertar";
	}

	@RequestMapping("/insertar")
	public String insertar(Libro libro, Model modelo, String categoria) {

		Categoria c = servicio.buscarCategoriaPorNombre(categoria);
		libro.setCategoria(c);
		servicio.insertarLibro(libro);

		modelo.addAttribute("lista", servicio.buscarLibroTodos());
		return "listaLibros";
	}

	@RequestMapping("/borrar")
	public String borrar(String isbn, Model modelo) {

		Libro libro = servicio.buscarLibroPorISBN(isbn);
		servicio.borrarLibro(libro);

		modelo.addAttribute("lista", servicio.buscarLibroTodos());
		return "listaLibros";
	}

	@RequestMapping("/detalles")
	public String detalles(Model modelo, String isbn) {

		Libro libro = servicio.buscarLibroPorISBN(isbn);
		modelo.addAttribute("libro", libro);
		return "detalles";
	}

	@RequestMapping("/formularioActualizar")
	public String formularioActualizar(Libro libro, Model modelo) {

		modelo.addAttribute("libro", libro);
		return "formularioActualizar";
	}
	
	@RequestMapping("/salvar")
	public String salvar(Libro libro, Model modelo, String categoria) {

		Categoria c = servicio.buscarCategoriaPorNombre(categoria);
		libro.setCategoria(c);
		servicio.salvarLibro(libro);

		modelo.addAttribute("lista", servicio.buscarLibroTodos());
		return "listaLibros";
	}
}
