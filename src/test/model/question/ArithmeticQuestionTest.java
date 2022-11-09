package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    private ArithmeticQuestion arithmeticQuestionMultiplication;
    private ArithmeticQuestion arithmeticQuestionAddition;
    private ArithmeticQuestion arithmeticQuestionSubtraction;

    @BeforeEach
    public void runBefore() {
        arithmeticQuestionMultiplication = new ArithmeticQuestion(5,
                ArithmeticQuestion.Operation.MULTIPLICATION, 2,3);
        question = arithmeticQuestionMultiplication;
        arithmeticQuestionAddition = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.ADDITION,
                2,3);
        arithmeticQuestionSubtraction = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.SUBTRACTION,
                3,2);
    }

    @Test
    public void testConstructor() {
        assertEquals(5, arithmeticQuestionMultiplication.getMaxMark());
    }

    @Test
    public void testQuestionStringMultiplication() {
        assertEquals("What is 2 * 3 ? [5 points]", arithmeticQuestionMultiplication.getQuestionString());
    }

    @Test
    public void testAnswerCorrectMultiplication() {
        assertTrue(arithmeticQuestionMultiplication.isCorrect("6"));
    }

    @Test
    public void testAnswerTooSmallMultiplication() {
        assertFalse(arithmeticQuestionMultiplication.isCorrect("5"));
    }

    @Test
    public void testAnswerTooLargeMultiplication() {
        assertFalse(arithmeticQuestionMultiplication.isCorrect("7"));
    }

    @Test
    public void testQuestionStringAddition() {
        assertEquals("What is 2 + 3 ? [5 points]", arithmeticQuestionAddition.getQuestionString());
    }

    @Test
    public void testAnswerCorrectAddition() {
        assertTrue(arithmeticQuestionAddition.isCorrect("5"));
    }

    @Test
    public void testAnswerTooSmallAddition() {
        assertFalse(arithmeticQuestionAddition.isCorrect("4"));
    }

    @Test
    public void testAnswerTooLargeAddition() {
        assertFalse(arithmeticQuestionAddition.isCorrect("6"));
    }

    @Test
    public void testQuestionStringSubtraction() {
        assertEquals("What is 3 - 2 ? [5 points]", arithmeticQuestionSubtraction.getQuestionString());
    }

    @Test
    public void testAnswerCorrectSubtraction() {
        assertTrue(arithmeticQuestionSubtraction.isCorrect("1"));
    }

    @Test
    public void testAnswerTooSmallSubtraction() {
        assertFalse(arithmeticQuestionSubtraction.isCorrect("0"));
    }

    @Test
    public void testAnswerTooLargeSubtraction() {
        assertFalse(arithmeticQuestionSubtraction.isCorrect("2"));
    }
}
