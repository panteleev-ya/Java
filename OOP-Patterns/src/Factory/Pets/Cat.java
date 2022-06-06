package Factory.Pets;

public class Cat implements Pet {
    @Override
    public void sayHiToHuman() {
        System.out.println("Meow!");
    }
}
