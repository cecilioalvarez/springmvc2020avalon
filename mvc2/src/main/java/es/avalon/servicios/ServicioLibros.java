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

	public Categoria buscarCategoriasPorNombre(String nombre) {
		return repositorioCategoria.buscarPorNombre(nombre);
	}

	public List<Libro> buscarTodos() {
		return repositorioLibro.buscarTodos();
	}

	public Libro buscarLibrosPorISBN(String isbn) {
		return repositorioLibro.buscarPorISBN(isbn);
	}

	public Libro buscarLibrosPorTitulo(String titulo) {
		return repositorioLibro.buscarPorTitulo(titulo);
	}

	@Transactional
	public void insertarLibros(Libro libro) {
		repositorioLibro.insertar(libro);
	}

	@Transactional
	public void salvarLibros(Libro libro) {
		repositorioLibro.salvar(libro);
	}

	@Transactional
	public void borrarLibros(Libro libro) {
		repositorioLibro.borrar(libro);
	}

	public List<Libro> ordenarLibrosTitulo() {
		return repositorioLibro.ordenarTitulo();
	}

	public List<Libro> ordenarLibrosAutor() {
		return repositorioLibro.ordenarAutor();
	}

}
