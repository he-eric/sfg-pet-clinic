package guru.springframework.sfgpetclinic.model;

public class VetSpeciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
