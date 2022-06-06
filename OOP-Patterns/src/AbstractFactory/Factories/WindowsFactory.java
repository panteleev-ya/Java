package AbstractFactory.Factories;

import AbstractFactory.Button.Button;
import AbstractFactory.Checkbox.Checkbox;
import AbstractFactory.Checkbox.WindowsCheckbox;
import AbstractFactory.Button.WindowsButton;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
