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

	public List<Libro> buscarLibroTodos() {
		return repositorioLibro.buscarTodos();
	}

	public Libro buscarLibroPorISBN(String isbn) {
		return repositorioLibro.buscarPorISBN(isbn);
	}

	public Libro buscarLibroPorTitulo(String titulo) {
		return repositorioLibro.buscarPorTitulo(titulo);
	}

	@Transactional
	public void insertarLibro(Libro libro) {
		repositorioLibro.insertar(libro);
	}

	public void salvarLibro(Libro libro) {
		repositorioLibro.salvar(libro);
	}

	public void borrarLibro(Libro libro) {
		repositorioLibro.borrar(libro);
	}

	public List<Libro> ordenarLibroPorTitulo() {
		return repositorioLibro.ordenarPorTitulo();
	}

	public List<Libro> ordenarLibroPorPrecio() {
		return repositorioLibro.ordenarPorPrecio();
	}

	public List<Libro> ordenarLibroPorCategoria() {
		return repositorioLibro.ordenarPorCategoria();
	}

	public Categoria buscarCategoriaPorNombre(String nombre) {
		return repositorioCategoria.buscarPorNombre(nombre);
	}

	public List<Categoria> buscarCategoriaTodos() {
		return repositorioCategoria.buscarTodos();
	}

	public void insertarCategoria(Categoria categoria) {
		repositorioCategoria.insertarCategoria(categoria);
	}
	

}