package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.VetSpecialty;
import guru.springframework.sfgpetclinic.services.SpecialtiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<VetSpecialty, Long> implements SpecialtiesService {

    @Override
    public Set<VetSpecialty> findAll() {
        return super.findAll();
    }

    @Override
    public VetSpecialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return super.save(object);
    }

    @Override
    public void delete(VetSpecialty object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

