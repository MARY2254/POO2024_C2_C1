package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;
import pe.edu.upeu.sysalmacenfx.repositorio.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    // C
    public Usuario save(Usuario to) {
        return repo.save(to);
    }

    // R
    public List<Usuario> list() {
        return repo.findAll();
    }

    // U
    public Usuario update(Usuario to, long id) {
        try {
            Usuario existingUsuario = repo.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
            existingUsuario.setIdUsuario(to.getIdUsuario());
            return repo.save(existingUsuario);
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
            return null;
        }
    }

    // D
    public void delete(long id) {
        try {
            repo.deleteById(id);
            System.out.println("Usuario eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public Usuario buscarId(long id) {
        try {
            return repo.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        } catch (Exception e) {
            System.out.println("Error al buscar el usuario: " + e.getMessage());
            return null;
        }
    }
}
