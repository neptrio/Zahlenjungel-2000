package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextGeneratorTest {

    private TextGenerator textGenerator = new TextGenerator();

    @Test
    void getRandomFailureSentence() {

        String randomFailureSentence = textGenerator.getRandomFailureSentence();
        assertTrue(!randomFailureSentence.isEmpty(), "No failure sentence generated!");
    }

    @Test
    void getStatementText() {

        String statementText = textGenerator.getStatementText(Text.GREETING);
        assertTrue(!statementText.isEmpty(), "No statement text returned!");

    }

}