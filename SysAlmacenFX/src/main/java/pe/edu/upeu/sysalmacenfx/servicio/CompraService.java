package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Compra;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraRepository;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    CompraRepository repo;

    // C
    public Compra save(Compra to) {
        return repo.save(to);
    }

    // R
    public List<Compra> list() {
        return repo.findAll();
    }

    // U
    public Compra update(Compra to, long id) {
        try {
            Compra existingCompra = repo.findById(id).orElseThrow(() -> new Exception("Compra no encontrada"));
            return repo.save(existingCompra);
        } catch (Exception e) {
            System.out.println("Error al actualizar la compra: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Compra eliminada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la compra: " + e.getMessage());
        }
    }

    // Buscar por ID
    public Compra buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Compra no encontrada"));
        } catch (Exception e) {
            System.out.println("Error al buscar la compra: " + e.getMessage());
            return null;
        }
    }
}
