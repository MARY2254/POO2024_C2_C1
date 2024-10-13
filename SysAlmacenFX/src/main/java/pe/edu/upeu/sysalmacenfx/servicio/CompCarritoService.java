package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.CompCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.CompCarritoRepository;

import java.util.List;

@Service
public class CompCarritoService {

    @Autowired
    CompCarritoRepository repo;

    // C
    public CompCarrito save(CompCarrito to) {
        return repo.save(to);
    }

    // R
    public List<CompCarrito> list() {
        return repo.findAll();
    }

    // U
    public CompCarrito update(CompCarrito to, long id) {
        try {
            CompCarrito existingCarrito = repo.findById(id).orElseThrow(() -> new Exception("Carrito no encontrado"));
            return repo.save(existingCarrito);
        } catch (Exception e) {
            System.out.println("Error al actualizar el carrito: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Carrito eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el carrito: " + e.getMessage());
        }
    }

    // Buscar por ID
    public CompCarrito buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Carrito no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el carrito: " + e.getMessage());
            return null;
        }
    }
}
