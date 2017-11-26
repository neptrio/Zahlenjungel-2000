package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class GameLogic implements IGameLogic {

    private INumberGenerator numberGenerator;
    private ITextGenerator textGenerator;

    private BufferedReader userInputReader;
    private int tries = 0;

    public GameLogic(INumberGenerator numberGenerator, ITextGenerator textGenerator) {
        this.numberGenerator = numberGenerator;
        this.textGenerator = textGenerator;
        this.userInputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startGame(){
        ConsoleWriter.writeToConsole(textGenerator.getStatementText(Text.GREETING));
        checkUserInput(askForNumberInput());
    }

    private int askForNumberInput() {
        tries = ++tries;
        int expectedNumber = 0;

        try {
            ConsoleWriter.writeToConsole(textGenerator.getStatementText(Text.INPUT_NUMBER));
            expectedNumber = Integer.parseInt(userInputReader.readLine());
            ConsoleWriter.writeToConsole(MessageFormat.format(textGenerator.getStatementText(Text.EXPECTED_NUMBER), expectedNumber));

            return expectedNumber;

        } catch (NumberFormatException n) {
            ConsoleWriter.writeToConsole(textGenerator.getStatementText(Text.WRONG_INPUT_TYPE));
            checkUserInput(askForNumberInput());
        } catch (IOException e) {
            ConsoleWriter.writeToConsole(textGenerator.getStatementText(Text.UNKNOWN_FAILURE));
            System.out.println(e);
        }

        return expectedNumber;
    }

    private void checkUserInput(int number) {

        if (numberGenerator.isSecretNumber(number)) {
            endGame();
        } else {
            if (number < numberGenerator.getSecretNumber()) {
                ConsoleWriter.writeToConsole(textGenerator.getRandomFailureSentence() + textGenerator.getStatementText(Text.HINT_NUMBER_GREATER));
                checkUserInput(askForNumberInput());
            } else if (number > numberGenerator.getSecretNumber()) {
                ConsoleWriter.writeToConsole(textGenerator.getRandomFailureSentence() + textGenerator.getStatementText(Text.HINT_NUMBER_LESSER));
                checkUserInput(askForNumberInput());
            }
        }
    }

    private void endGame(){
        ConsoleWriter.writeToConsole(MessageFormat.format(textGenerator.getStatementText(Text.CONGRATULATION), tries));
    }

}
