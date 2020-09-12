package max.springframework.petclinic.services.springdatajpa;

import max.springframework.petclinic.model.Pet;
import max.springframework.petclinic.model.PetType;
import max.springframework.petclinic.model.Speciality;
import max.springframework.petclinic.repositories.SpecialityRepository;
import max.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDjpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findByID(Long aLong) {
        Optional<Speciality> specialityptional = specialityRepository.findById(aLong);
        if(specialityptional.isPresent()) {
            return specialityptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
