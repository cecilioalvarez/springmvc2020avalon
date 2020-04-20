package es.avalon.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.avalon.dominio.Categoria;
import es.avalon.dominio.Libro;
import es.avalon.repositorios.CategoriaRepository;
import es.avalon.repositorios.LibroRepository;

@Service
public class ServicioLibros {
	
	@Autowired
	private LibroRepository repositorioLibro;
	@Autowired
	private CategoriaRepository repositorioCategoria;
	
	public Categoria buscarCategoriaPorNombre(String nombre) {
		return repositorioCategoria.buscarPorNombre(nombre);
	}
	public List<Libro> buscarLibroTodos() {
		return repositorioLibro.buscarTodos();
	}
	public List<Libro> buscarLibroTodosOrdenadosPorTitulo() {
		return repositorioLibro.buscarTodosOrdenadosPorTitulo();
	}
	public List<Libro> buscarLibroTodosOrdenadosPorAutor() {
		return repositorioLibro.buscarTodosOrdenadosPorAutor();
	}
	public Libro buscarLibroPorISBN(String isbn) {
		return repositorioLibro.buscarPorISBN(isbn);
	}
	public Libro buscarLibroPorTitulo(String titulo) {
		return repositorioLibro.buscarPorTitulo(titulo);
	}
	
	//Ojo este metodo necesita una transaccion del transaction manager
	//begin
	@Transactional
	public void insertarLibro(Libro libro) {
		repositorioLibro.insertar(libro);
	}
	@Transactional
	public void salvarLibro(Libro libro) {
		repositorioLibro.salvar(libro);
	}
	@Transactional
	public void borrarLibro(Libro libro) {
		repositorioLibro.borrar(libro);
	}
	

}
