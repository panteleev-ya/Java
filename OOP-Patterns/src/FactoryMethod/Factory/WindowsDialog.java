package FactoryMethod.Factory;

import FactoryMethod.Buttons.Button;
import FactoryMethod.Buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
