package max.springframework.petclinic.services.springdatajpa;

import max.springframework.petclinic.model.Owner;
import max.springframework.petclinic.model.Pet;
import max.springframework.petclinic.repositories.PetRepository;
import max.springframework.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDjpaService implements PetService {

    private final PetRepository petRepository;

    public PetSDjpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findByID(Long aLong) {
        Optional<Pet> petOptional = petRepository.findById(aLong);
        if(petOptional.isPresent()) {
            return petOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
