package max.springframework.petclinic.services.map;

import max.springframework.petclinic.model.Speciality;
import max.springframework.petclinic.model.Vet;
import max.springframework.petclinic.services.SpecialtyService;
import max.springframework.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>0) {
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Vet findByID(Long id) {
        return super.findByID(id);
    }
}
