package com.company;

public interface ITextGenerator {
    /**
     * Get a random text
     * @return string of random sentence
     */
    String getRandomFailureSentence();

    /**
     * Get a specific system text.
     * @param text type you want to get
     * @return a specific system text
     */
    String getStatementText(Text text);
}