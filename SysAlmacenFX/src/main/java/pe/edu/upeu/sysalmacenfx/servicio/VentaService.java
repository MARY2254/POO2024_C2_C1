package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Venta;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaRepository;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    VentaRepository repo;

    // C
    public Venta save(Venta to) {
        return repo.save(to);
    }

    // R
    public List<Venta> list() {
        return repo.findAll();
    }

    // U
    public Venta update(Venta to, long id) {
        try {
            Venta existingVenta = repo.findById(id).orElseThrow(() -> new Exception("Venta no encontrada"));
            existingVenta.setIdVenta(to.getIdVenta());
            return repo.save(existingVenta);
        } catch (Exception e) {
            System.out.println("Error al actualizar la venta: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Venta eliminada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar la venta: " + e.getMessage());
        }
    }

    // Buscar por ID
    public Venta buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Venta no encontrada"));
        } catch (Exception e) {
            System.out.println("Error al buscar la venta: " + e.getMessage());
            return null;
        }
    }
}
