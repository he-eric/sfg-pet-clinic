package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long ownerId1 = 1L;
    Long ownerId2 = 2L;
    String owner1LastName = "Marley";
    String owner2LastName = "Jax";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner1 = Owner.builder().id(ownerId1).lastName(owner1LastName).build();
        Owner owner2 = Owner.builder().id(ownerId2).lastName(owner2LastName).build();
        ownerServiceMap.save(owner1);
        ownerServiceMap.save(owner2);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(owner1LastName);
        assertNotNull(owner);
        assertEquals(owner1LastName, owner.getLastName());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId2);
        assertNotNull(owner);
        assertEquals(ownerId2, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 3L;
        Owner owner = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner);
        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNonexistingId() {
        Owner owner = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(owner);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        Owner owner = ownerServiceMap.findById(ownerId1);
        assertNotNull(owner);
        ownerServiceMap.delete(owner);
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId2);
        assertEquals(1, ownerServiceMap.findAll().size());
    }
}