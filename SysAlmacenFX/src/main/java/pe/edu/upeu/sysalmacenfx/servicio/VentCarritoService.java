package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.VentCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.VentCarritoRepository;

import java.util.List;

@Service
public class VentCarritoService {

    @Autowired
    VentCarritoRepository repo;

    // C
    public VentCarrito save(VentCarrito to) {
        return repo.save(to);
    }

    // R
    public List<VentCarrito> list() {
        return repo.findAll();
    }

    // U
    public VentCarrito update(VentCarrito to, long id) {
        try {
            VentCarrito existingVentCarrito = repo.findById(id).orElseThrow(() -> new Exception("VentCarrito no encontrado"));
            existingVentCarrito.setNombreProducto(to.getNombreProducto());
            existingVentCarrito.setCantidad(to.getCantidad());

            return repo.save(existingVentCarrito);
        } catch (Exception e) {
            System.out.println("Error al actualizar el VentCarrito: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("VentCarrito eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el VentCarrito: " + e.getMessage());
        }
    }

    public VentCarrito buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("VentCarrito no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el VentCarrito: " + e.getMessage());
            return null;
        }
    }
}
