package max.springframework.petclinic.bootstrap;

import max.springframework.petlcinic.model.Owner;
import max.springframework.petlcinic.model.Vet;
import max.springframework.petlcinic.services.OwnerService;
import max.springframework.petlcinic.services.VetService;
import max.springframework.petlcinic.services.map.OwnerServiceMap;
import max.springframework.petlcinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mary");
        owner2.setLastName("Collins");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("James");
        vet1.setLastName("Black");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mark");
        vet2.setLastName("Daniels");
        vetService.save(vet2);

        System.out.println("Loaded vets: " + vetService.findAll());
    }
}
