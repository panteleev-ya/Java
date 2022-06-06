package AbstractFactory.App;

import AbstractFactory.Button.Button;
import AbstractFactory.Checkbox.Checkbox;
import AbstractFactory.Factories.GUIFactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
