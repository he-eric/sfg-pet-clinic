package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private LocalDate date;
    private String descriptionl;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescriptionl() {
        return descriptionl;
    }

    public void setDescriptionl(String descriptionl) {
        this.descriptionl = descriptionl;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
