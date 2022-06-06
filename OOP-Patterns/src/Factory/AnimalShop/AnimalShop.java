package Factory.AnimalShop;

import Factory.Factory.PetFactory;
import Factory.Pets.Pet;
import Factory.Pets.PetType;

import java.util.HashMap;

public class AnimalShop {
    private final PetFactory petFactory;
    private final HashMap<PetType, Pet> uniquePets;

    public AnimalShop() {
        petFactory = new PetFactory();
        uniquePets = new HashMap<>();
    }

    public Pet getPetFromType(PetType type) {
        Pet uniquePet;
        if (!uniquePets.containsKey(type)) {
            uniquePet = petFactory.createPet(type);
            uniquePets.put(type, uniquePet);
        } else {
            uniquePet = uniquePets.get(type);
        }
        return uniquePet;
    }
}
