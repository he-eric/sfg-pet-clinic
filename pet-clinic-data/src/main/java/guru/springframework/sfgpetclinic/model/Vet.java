package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<VetSpeciality> specialities;

    public Set<VetSpeciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<VetSpeciality> specialities) {
        this.specialities = specialities;
    }
}
