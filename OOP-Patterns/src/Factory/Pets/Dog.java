package Factory.Pets;

public class Dog implements Pet {
    @Override
    public void sayHiToHuman() {
        System.out.println("Bark bark bark!");
    }
}
