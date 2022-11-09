package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker arithmeticAnswerChecker;

    @BeforeEach
    public void runBefore() {
        arithmeticAnswerChecker = new ArithmeticAnswerChecker(6);
    }

    @Test
    void testUserResponseEqualsAnswer() {
        assertTrue(arithmeticAnswerChecker.checkAnswer("6"));
    }

    @Test
    void testUserResponseLargerThanAnswer() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("7"));
    }

    @Test
    void testUserResponseLessThanAnswer() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("5"));
    }

    @Test
    public void testAnswerNonIntegerValue() {
        try {
            arithmeticAnswerChecker.checkAnswer("5.0");
        } catch (NumberFormatException e) {

        }
    }

    @Test
    public void testAnswerGreaterThanIntegerValuesRange() {
        try {
            arithmeticAnswerChecker.checkAnswer("2147483648");
        } catch (NumberFormatException e) {

        }
    }

    @Test
    public void testAnswerLessThanIntegerValuesRange() {
        try {
            arithmeticAnswerChecker.checkAnswer("-2147483649");
        } catch (NumberFormatException e) {

        }
    }

    @Test
    public void testAnswerNotInterpretedAsInteger() {
        try {
            arithmeticAnswerChecker.checkAnswer("four");
        } catch (NumberFormatException e) {

        }
    }


}
