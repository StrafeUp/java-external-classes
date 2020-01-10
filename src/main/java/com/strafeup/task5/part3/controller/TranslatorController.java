package com.strafeup.task5.part3.controller;

import com.strafeup.task5.part3.model.Translator;
import com.strafeup.task5.part3.view.ConsolePrinter;
import com.strafeup.task5.part3.view.UserInput;

public class TranslatorController {
    private Translator translator;

    public TranslatorController() {
        this.translator = new Translator();
    }

    public void start() {
        menu();
    }

    private void menu() {

        int menuInput;
        while (true) {
            ConsolePrinter.print("Welcome to the tranlator\n" +
                    " 1. Add a new pair into dictionary\n" +
                    " 2. Translate a line\n" +
                    " 3. Load basic dictionary\n" +
                    " 5. Exit\n");
            menuInput = UserInput.getNumber();

            switch (menuInput) {
                case 1:
                    String[] tokens = UserInput.getLine().split(" -");
                    translator.addPair(tokens[0].strip(), tokens[1].strip());
                    break;
                case 2:
                    String lineToTranslate = UserInput.getLine();
                    ConsolePrinter.print(translator.translateLine(lineToTranslate));
                    break;
                case 3:
                    translator.loadBasicWords();
                    break;
                case 5:
                    return;
            }
        }
    }


}
