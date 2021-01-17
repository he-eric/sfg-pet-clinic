package guru.springframework.sfgpetclinic.services.springdatajpq;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).build();
    }

    @Test
    void findByLastName() {
        Owner ownerReturn = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(ownerReturn);
        Owner owner = ownerSDJpaService.findByLastName("Smith");
        assertEquals("Smith", owner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownersReturn = new HashSet<>();
        ownersReturn.add(Owner.builder().id(1L).build());
        ownersReturn.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownersReturn);
        assertNotNull(ownerSDJpaService.findAll());
        assertEquals(2, ownerSDJpaService.findAll().size());
        verify(ownerRepository, times(2)).findAll();
    }

    @Test
    void findByExistingId() {
        Owner ownerReturn = Owner.builder().id(1L).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(ownerReturn));
        assertEquals(ownerReturn.getId(), ownerSDJpaService.findById(1L).getId());
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByNonexistentId() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(ownerSDJpaService.findById(1L));
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void save() {
        Owner ownerReturn = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(ownerReturn);
        assertNotNull(ownerSDJpaService.save(ownerReturn));
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}