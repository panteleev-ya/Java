package FactoryMethod.Factory;

import FactoryMethod.Buttons.Button;
import FactoryMethod.Buttons.HtmlButton;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}