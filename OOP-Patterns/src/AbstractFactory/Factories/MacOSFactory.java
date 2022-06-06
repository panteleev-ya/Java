package AbstractFactory.Factories;

import AbstractFactory.Button.Button;
import AbstractFactory.Button.MacOSButton;

import AbstractFactory.Checkbox.Checkbox;
import AbstractFactory.Checkbox.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
