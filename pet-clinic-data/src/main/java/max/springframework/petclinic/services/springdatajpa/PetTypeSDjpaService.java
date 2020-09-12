package max.springframework.petclinic.services.springdatajpa;

import max.springframework.petclinic.model.PetType;
import max.springframework.petclinic.model.Vet;
import max.springframework.petclinic.repositories.PetTypeRepository;
import max.springframework.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDjpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDjpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findByID(Long aLong) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(aLong);
        if(petTypeOptional.isPresent()) {
            return petTypeOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
