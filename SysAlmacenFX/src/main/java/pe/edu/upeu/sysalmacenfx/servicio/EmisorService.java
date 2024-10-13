package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Emisor;
import pe.edu.upeu.sysalmacenfx.repositorio.EmisorRepository;

import java.util.List;

@Service
public class EmisorService {

    @Autowired
    EmisorRepository repo;

    // C
    public Emisor save(Emisor to) {
        return repo.save(to);
    }

    // R
    public List<Emisor> list() {
        return repo.findAll();
    }

    // U
    public Emisor update(Emisor to, long id) {
        try {
            Emisor existingEmisor = repo.findById(id).orElseThrow(() -> new Exception("Emisor no encontrado"));
            return repo.save(existingEmisor);
        } catch (Exception e) {
            System.out.println("Error al actualizar el emisor: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Emisor eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el emisor: " + e.getMessage());
        }
    }

    // Buscar por ID
    public Emisor buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Emisor no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el emisor: " + e.getMessage());
            return null;
        }
    }
}
