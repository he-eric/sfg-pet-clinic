package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.VetSpecialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<VetSpecialty, Long> {
}
