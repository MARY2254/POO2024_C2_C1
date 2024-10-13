package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.UnidadMedida;
import pe.edu.upeu.sysalmacenfx.repositorio.UnidadMedidaRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class UnidadMedidaService {
    @Autowired
    UnidadMedidaRepository repo;

    //C
    public UnidadMedida save(UnidadMedida to) {
        return repo.save(to);
    }

    //R
    public List<UnidadMedida> list() {
        return repo.findAll();
    }

    //U

    public UnidadMedida update(UnidadMedida to, long id) {
        try {
            UnidadMedida toe= repo.findById(id).get();
            if (toe != null) {
                toe.setNombreMedida(to.getNombreMedida());
            }
            return repo.save(toe);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public UnidadMedida update(UnidadMedida to) {
        return repo.save(to);
    }

    //D
    public void delete(long id) {
        repo.deleteById(id);
    }

    //D
    public UnidadMedida buscarId(long id) {
        return repo.findById(id).get();
    }
    public UnidadMedida searchById(long id) {
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for (UnidadMedida cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdUnidad()));
            cb.setValue(cate.getNombreMedida());
            listar.add(cb);
        }
        return listar;
    }
}
