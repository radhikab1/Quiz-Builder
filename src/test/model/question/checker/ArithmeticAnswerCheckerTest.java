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
    void testCorrectUserResponseEqualsAnswer() {
        assertTrue(arithmeticAnswerChecker.checkAnswer("6"));
    }

    @Test
    void testIncorrectUserResponseLargerThanAnswer() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("7"));
    }

    @Test
    void testIncorrectUserResponseLessThanAnswer() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("5"));
    }

    @Test
    public void testIncorrectUserResponseNonIntegerValue() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("5.0"));
    }

    @Test
    public void testIncorrectUserResponseGreaterThanRepresentableIntegerValue() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("2147483648"));
    }

    @Test
    public void testIncorrectUserResponseLessThanRepresentableIntegerValue() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("-2147483649"));
    }

    @Test
    public void testAnswerNotInterpretedAsInteger() {
        assertFalse(arithmeticAnswerChecker.checkAnswer("four"));
    }


}
