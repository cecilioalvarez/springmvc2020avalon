package es.avalon.mvc.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.dominio.Categoria;
import es.avalon.dominio.Libro;
import es.avalon.repositorios.LibroRepository;
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

	@RequestMapping("/libro")
	public String libro(Model modelo) {
		modelo.addAttribute("libro",new Libro("1","java","pedro",20));
		return "paginaLibro";
	}
//	@RequestMapping("/listaLibros")
//	public String listaLibros (Model modelo) {
//		ArrayList<Libro> lista=new ArrayList<Libro>();
//		lista.add(new Libro("1","java","pedro",20));
//		lista.add(new Libro("2","net","ana",30));
//		modelo.addAttribute("lista",lista);
//		return "listaLibros";
//	}
	
	@RequestMapping("/listaLibros")
	public String listaLibros (Model modelo) {
		
		modelo.addAttribute("lista",servicio.buscarLibrosTodos());
		return "listaLibros";
	}
	
	@RequestMapping("/formularioInsertar")
	public String formularioInsertar () {
		return "formularioInsertar";
	}
	@RequestMapping("/insertar")
	public String insertar(Libro libro, Model modelo, String nombreCategoria) {
		
		Categoria c=servicio.buscarCategoriaPorNombre(nombreCategoria);
		libro.setCategoria(c);
		servicio.insertarLibros(libro);
		modelo.addAttribute("lista",servicio.buscarLibrosTodos());
		return "listaLibros";
	}
	@RequestMapping("borrar")
	public String Borrar(Model modelo, String isbn) {
		Libro l=servicio.buscarLibrosPorISBN(isbn);
		servicio.borrarLibros(l);
		modelo.addAttribute("lista",servicio.buscarLibrosTodos());
		return "listaLibros";
	}
}
