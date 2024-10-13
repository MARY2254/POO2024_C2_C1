package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Proveedor;
import pe.edu.upeu.sysalmacenfx.repositorio.ProveedorRepository;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository repo;

    // C
    public Proveedor save(Proveedor to) {
        return repo.save(to);
    }

    // R
    public List<Proveedor> list() {
        return repo.findAll();
    }

    // U
    public Proveedor update(Proveedor to, long id) {
        try {
            Proveedor existingProveedor = repo.findById(id).orElseThrow(() -> new Exception("Proveedor no encontrado"));
            existingProveedor.setIdProveedor(to.getIdProveedor());
            return repo.save(existingProveedor);
        } catch (Exception e) {
            System.out.println("Error al actualizar el proveedor: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Proveedor eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
        }
    }

    // Buscar por ID
    public Proveedor buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Proveedor no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el proveedor: " + e.getMessage());
            return null;
        }
    }
}
