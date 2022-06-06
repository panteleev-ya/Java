package AbstractFactory.Factories;

import AbstractFactory.Button.Button;
import AbstractFactory.Checkbox.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
