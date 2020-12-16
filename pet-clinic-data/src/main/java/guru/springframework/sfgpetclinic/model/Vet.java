package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<VetSpecialty> specialities = new HashSet<>();

    public Set<VetSpecialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<VetSpecialty> specialities) {
        this.specialities = specialities;
    }
}
