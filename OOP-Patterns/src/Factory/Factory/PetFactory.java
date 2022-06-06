package Factory.Factory;

import Factory.Pets.*;

public class PetFactory {
    public Pet createPet(PetType type) {
        return switch (type) {
            case CAT -> new Cat();
            case DOG -> new Dog();
            case FISH -> new Fish();
            case GOOSE -> new Goose();
        };
    }
}
