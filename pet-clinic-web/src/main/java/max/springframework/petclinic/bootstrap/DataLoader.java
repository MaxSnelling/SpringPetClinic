package max.springframework.petclinic.bootstrap;

import max.springframework.petclinic.model.*;
import max.springframework.petclinic.services.OwnerService;
import max.springframework.petclinic.services.PetTypeService;
import max.springframework.petclinic.services.SpecialtyService;
import max.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
        System.out.println("Loaded vets: " + vetService.findAll());
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedRadiology = specialtyService.save(radiology);
        Speciality savedSurgery = specialtyService.save(surgery);
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        owner1.setAddress("123 Rookery Road");
        owner1.setCity("Birmingham");
        owner1.setTelephone("01921");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Doggo");
        owner1.getPets().add(pet1);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mary");
        owner2.setLastName("Collins");
        owner2.setAddress("124 Rookery Road");
        owner2.setCity("Birmingham");
        owner2.setTelephone("01323");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Catto");
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("James");
        vet1.setLastName("Black");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mark");
        vet2.setLastName("Daniels");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
    }
}
