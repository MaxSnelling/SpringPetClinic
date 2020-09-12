package max.springframework.petclinic.services.springdatajpa;

import max.springframework.petclinic.model.Owner;
import max.springframework.petclinic.model.Vet;
import max.springframework.petclinic.repositories.VetRepository;
import max.springframework.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetsSDjpaService implements VetService {

    private final VetRepository vetRepository;

    public VetsSDjpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findByID(Long aLong) {
        Optional<Vet> vetOptional = vetRepository.findById(aLong);
        if(vetOptional.isPresent()) {
            return vetOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
