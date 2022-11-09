package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
