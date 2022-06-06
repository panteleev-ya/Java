package Factory.Pets;

public class Goose implements Pet {
    @Override
    public void sayHiToHuman() {
        System.out.println("Gaa-gaa!");
    }
}
