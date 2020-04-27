package es.avalon.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public List<LibroDTO> buscarTodos(){
		
		List<Libro> lista = servicio.buscarLibroTodos();
		List<LibroDTO> otra = new ArrayList<LibroDTO>();
		
		for(Libro l :lista) {
			LibroDTO nuevo = new LibroDTO(l.getIsbn(),l.getTitulo(),l.getAutor(),l.getPrecio(),l.getCategoria().getNombre());
			otra.add(nuevo);
		}
		 return otra; 
		
	}
}
