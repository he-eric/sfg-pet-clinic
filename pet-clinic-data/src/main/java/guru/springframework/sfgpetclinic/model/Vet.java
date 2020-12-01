package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<VetSpecialty> specialities = new HashSet<>();

    public Set<VetSpecialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<VetSpecialty> specialities) {
        this.specialities = specialities;
    }
}
