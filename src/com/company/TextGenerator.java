package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.Field;

public class TextGenerator implements ITextGenerator {

    private ArrayList<String> failureTexts = new ArrayList<>();

    public TextGenerator(){
        this.failureTexts.add("Das geht aber besser! ");
        this.failureTexts.add("Das war super falsch! ");
        this.failureTexts.add("Voll daneben! ");
        this.failureTexts.add("Noooope! ");
    }

    private Integer getRandomInteger(ArrayList list){
        return ThreadLocalRandom.current().nextInt(0, list.size());
    }

    public String getRandomFailureSentence() {
        return failureTexts.get(getRandomInteger(failureTexts));
    }

    public String getStatementText(Text text) {

        String statement;

        try {
            Field field = StringsDE.class.getField(text.name());
            statement = (String) field.get(null);
        } catch (NoSuchFieldException|IllegalAccessException e) {
            statement = "";
        }

        return statement;
    }
}
