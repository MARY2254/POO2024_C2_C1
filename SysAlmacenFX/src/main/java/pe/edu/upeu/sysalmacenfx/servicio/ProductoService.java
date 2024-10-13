package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.modelo.Producto;
import pe.edu.upeu.sysalmacenfx.repositorio.ProductoRepository;

import java.util.List;
@Service
public class ProductoService {
    @Autowired
    ProductoRepository repo;

    //C
    public Producto save(Producto to) {
        return repo.save(to);
    }

    //R
    public List<Producto> list() {
        return repo.findAll();
    }

    //U

    public Producto update(Producto to,long id) {
        try {
            Producto toe= repo.findById(id).get();
            if (toe != null) {
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public Producto update(Producto to) {
        return repo.save(to);
    }

    //D
    public void delete(long id) {
        repo.deleteById(id);
    }

    //D
    public Producto buscarId(long id) {
        return repo.findById(id).get();
    }
    public Producto searchById(long id) {
        return repo.findById(id).get();
    }
}
