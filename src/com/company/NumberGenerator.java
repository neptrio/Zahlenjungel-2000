package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator implements INumberGenerator{

    private int secretNumber;

    public NumberGenerator(int range){
        this.secretNumber = this.generateSecretNumber(range);
    }

    private int generateSecretNumber(int range){
        return ThreadLocalRandom.current().nextInt(1, range+1);
    }

    public int getSecretNumber() {
        return this.secretNumber;
    }

    public boolean isSecretNumber(int n) {

        boolean isSecretNumber = false;

        if(this.secretNumber == n) isSecretNumber = true;

        return isSecretNumber;
    }
}
