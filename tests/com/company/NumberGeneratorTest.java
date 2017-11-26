package com.company;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    private int numberRange = 10;
    private NumberGenerator numberGenerator = new NumberGenerator(numberRange);

    @Test
    void getSecretNumber() {
        int generatedNumber = this.numberGenerator.getSecretNumber();
        assertThat(generatedNumber).isGreaterThan(0).isLessThanOrEqualTo(numberRange);
    }

    @Test
    void isSecretNumber() {
        assertTrue(this.numberGenerator.isSecretNumber(this.numberGenerator.getSecretNumber()));
    }

}