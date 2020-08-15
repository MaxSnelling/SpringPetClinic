package max.springframework.petlcinic.services.map;

import max.springframework.petlcinic.model.Owner;
import max.springframework.petlcinic.model.Pet;
import max.springframework.petlcinic.services.CrudService;
import max.springframework.petlcinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

    @Override
    public Pet findByID(Long id) {
        return super.findByID(id);
    }
}
