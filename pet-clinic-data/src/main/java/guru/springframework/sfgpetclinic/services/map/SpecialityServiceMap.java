package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.VetSpeciality;
import guru.springframework.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<VetSpeciality, Long> implements SpecialitiesService {

    @Override
    public Set<VetSpeciality> findAll() {
        return super.findAll();
    }

    @Override
    public VetSpeciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetSpeciality save(VetSpeciality object) {
        return super.save(object);
    }

    @Override
    public void delete(VetSpeciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

