package max.springframework.petclinic.services.springdatajpa;

import max.springframework.petclinic.model.Vet;
import max.springframework.petclinic.model.Visit;
import max.springframework.petclinic.repositories.VisitRepository;
import max.springframework.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDjpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDjpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findByID(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        if(visitOptional.isPresent()) {
            return visitOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {

    }
}
