package max.springframework.petclinic.services.map;

import max.springframework.petclinic.model.Speciality;
import max.springframework.petclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtyMapService extends AbstractMapService<Speciality, Long>  implements SpecialtiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findByID(Long id) {
        return super.findByID(id);
    }
}
