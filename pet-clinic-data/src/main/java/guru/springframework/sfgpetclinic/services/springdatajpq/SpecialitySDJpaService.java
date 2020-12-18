package guru.springframework.sfgpetclinic.services.springdatajpq;

import guru.springframework.sfgpetclinic.model.VetSpecialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpecialitySDJpaService implements SpecialtiesService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<VetSpecialty> findAll() {
        Set<VetSpecialty> vets = new HashSet<>();
        specialtyRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public VetSpecialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(VetSpecialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
