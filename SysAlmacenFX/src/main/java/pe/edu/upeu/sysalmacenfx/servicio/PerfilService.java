package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Perfil;
import pe.edu.upeu.sysalmacenfx.repositorio.PerfilRepository;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repo;

    // C
    public Perfil save(Perfil to) {
        return repo.save(to);
    }

    // R
    public List<Perfil> list() {
        return repo.findAll();
    }

    // U
    public Perfil update(Perfil to, long id) {
        try {
            Perfil existingPerfil = repo.findById(id).orElse(null);
            if (existingPerfil != null) {
                existingPerfil.setNombre(to.getNombre());
                return repo.save(existingPerfil);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    // D
    public void delete(long id) {
        repo.deleteById(id);
    }

    public Perfil findById(long id) {
        return repo.findById(id).orElse(null);
    }
}
