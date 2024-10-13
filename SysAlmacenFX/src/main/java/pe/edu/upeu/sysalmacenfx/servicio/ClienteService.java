package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Cliente;
import pe.edu.upeu.sysalmacenfx.repositorio.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    // C
    public Cliente save(Cliente to) {
        return repo.save(to);
    }

    // R
    public List<Cliente> list() {
        return repo.findAll();
    }

    // U
    public Cliente update(Cliente to, long id) {
        try {
            Cliente toe = repo.findById(id).orElseThrow(() -> new Exception("Cliente no encontrado"));
            toe.setNombres(to.getNombres());

            return repo.save(toe);
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Cliente eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
        }
    }
    // Buscar por ID
    public Cliente buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Cliente no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente: " + e.getMessage());
            return null;
        }
    }
}
