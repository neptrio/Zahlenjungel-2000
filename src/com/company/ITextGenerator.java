package com.company;

public interface ITextGenerator {
    /**
     * Get a random text
     * @return string of random sentence
     */
    String getRandomFailureSentence();
    String getStatementText(Text text);
}