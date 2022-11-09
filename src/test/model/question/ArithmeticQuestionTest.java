package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    private ArithmeticQuestion arithmeticQuestion;

    @BeforeEach
    public void runBefore() {
        arithmeticQuestion = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.MULTIPLICATION,
                2,3);
        question = arithmeticQuestion;
    }

    @Test
    public void testConstructor() {
        assertEquals(5, arithmeticQuestion.getMaxMark());
    }

    @Test
    public void testQuestionString() {
        assertEquals("What is 2 * 3 ? [5 points]", arithmeticQuestion.getQuestionString());
    }

    @Test
    public void testAnswerCorrect() {
        assertTrue(arithmeticQuestion.isCorrect("6"));
    }

    @Test
    public void testAnswerTooSmall() {
        assertFalse(arithmeticQuestion.isCorrect("5"));
    }

    @Test
    public void testAnswerTooLarge() {
        assertFalse(arithmeticQuestion.isCorrect("7"));
    }
}
