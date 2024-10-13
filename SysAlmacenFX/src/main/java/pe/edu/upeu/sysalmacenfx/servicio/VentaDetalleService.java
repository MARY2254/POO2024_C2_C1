package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.VentaDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaDetalleRepository;

import java.util.List;

@Service
public class VentaDetalleService {

    @Autowired
    VentaDetalleRepository repo;

    // C
    public VentaDetalle save(VentaDetalle to) {
        return repo.save(to);
    }

    // R
    public List<VentaDetalle> list() {
        return repo.findAll();
    }

    // U
    public VentaDetalle update(VentaDetalle to, long id) {
        try {
            VentaDetalle existingVentaDetalle = repo.findById(id).orElseThrow(() -> new Exception("VentaDetalle no encontrado"));
            existingVentaDetalle.setIdVentaDetalle(to.getIdVentaDetalle()); // Cambia esto a los campos correctos
            return repo.save(existingVentaDetalle);
        } catch (Exception e) {
            System.out.println("Error al actualizar el VentaDetalle: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("VentaDetalle eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el VentaDetalle: " + e.getMessage());
        }
    }

    // Buscar por ID
    public VentaDetalle buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("VentaDetalle no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el VentaDetalle: " + e.getMessage());
            return null;
        }
    }
}
