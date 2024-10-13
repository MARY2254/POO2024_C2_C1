package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.CompraDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraDetalleRepository;

import java.util.List;

@Service
public class CompraDetalleService {

    @Autowired
    CompraDetalleRepository repo;

    // C
    public CompraDetalle save(CompraDetalle to) {
        return repo.save(to);
    }

    // R
    public List<CompraDetalle> list() {
        return repo.findAll();
    }

    // U
    public CompraDetalle update(CompraDetalle to, long id) {
        try {
            CompraDetalle existingDetalle = repo.findById(id).orElseThrow(() -> new Exception("Detalle no encontrado"));
            return repo.save(existingDetalle);
        } catch (Exception e) {
            System.out.println("Error al actualizar el detalle de compra: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Detalle de compra eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el detalle de compra: " + e.getMessage());
        }
    }

    // Buscar por ID
    public CompraDetalle buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Detalle no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el detalle de compra: " + e.getMessage());
            return null;
        }
    }
}
