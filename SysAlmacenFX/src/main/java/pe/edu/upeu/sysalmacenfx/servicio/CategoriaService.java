package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;
    // CategoriaRepository repo=new CategoriaRepository()  "no hacer esto"

    //C
    public Categoria save(Categoria to) {
        return repo.save(to);
    }

    //R
    public List<Categoria> list() {
        return repo.findAll();
    }

    //U
    //esto es si quieres modificar

    public Categoria update(Categoria to,long id) {
      try {
          Categoria toe= repo.findById(id).get();
          if (toe != null) {
              toe.setNombre(to.getNombre());
          }
          return repo.save(toe);
      }catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
      return null;
    }

    public Categoria update(Categoria to) {
        return repo.save(to);
    }

    //D
    public void delete(long id) {
        repo.deleteById(id);
    }

    //D
    public Categoria buscarId(long id) {
        return repo.findById(id).get();
    }
    public Categoria searchById(long id) {
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for (Categoria cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCategoria()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }

}
