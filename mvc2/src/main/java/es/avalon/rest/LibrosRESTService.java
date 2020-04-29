package es.avalon.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.avalon.dominio.Categoria;
import es.avalon.dominio.Libro;
import es.avalon.rest.dto.LibroDTO;
import es.avalon.servicios.ServicioLibros;

@Controller
@RequestMapping("/webapi")
public class LibrosRESTService {
	
	@Autowired
	ServicioLibros servicio;
	
	@RequestMapping("/libros")
	@ResponseBody

	public List<LibroDTO> buscarTodos() {
		
		//Contiene datos
		List<Libro> lista= servicio.buscarLibroTodos();
		
		//Esta vacia
		List<LibroDTO> otra= new ArrayList<LibroDTO>();
		
		for (Libro l: lista) {
			LibroDTO nuevo= new LibroDTO(l.getIsbn(),l.getTitulo(),l.getAutor(),l.getPrecio(),l.getCategoria().getNombre());
			otra.add(nuevo);
		}
		return otra;
		
	}
	@RequestMapping(value="/libros/{isbn}", method=RequestMethod.DELETE)
	@ResponseBody
	public void borrar(@PathVariable String isbn) {
		servicio.borrarLibro(new Libro(isbn));
	}
	
	@RequestMapping(value="/libros", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public void insertar(@RequestBody LibroDTO libro) {
		
		Categoria c=servicio.buscarCategoriaPorNombre(libro.getCategoria());
		
		Libro nuevo= new Libro (libro.getIsbn(), libro.getTitulo(), libro.getAutor(), (int)libro.getPrecio());
		nuevo.setCategoria(c);
		servicio.insertarLibro(nuevo);
	}
		
}
