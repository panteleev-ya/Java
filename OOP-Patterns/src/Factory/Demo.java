package Factory;

import Factory.AnimalShop.AnimalShop;
import Factory.Pets.Pet;
import Factory.Pets.PetType;

public class Demo {
    public static void main(String[] args) {
        AnimalShop animalShop = new AnimalShop();
        Pet myCat = animalShop.getPetFromType(PetType.CAT);
        myCat.sayHiToHuman();
    }
}
