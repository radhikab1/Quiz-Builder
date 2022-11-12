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
        question = arithmeticQuestionAddition;
        arithmeticQuestionSubtraction = new ArithmeticQuestion(5, ArithmeticQuestion.Operation.SUBTRACTION,
                3,2);
        question = arithmeticQuestionSubtraction;
    }

    @Test
    public void testConstructor() {
        assertEquals(5, arithmeticQuestionMultiplication.getMaxMark());
        assertEquals(5, arithmeticQuestionAddition.getMaxMark());
        assertEquals(5, arithmeticQuestionSubtraction.getMaxMark());
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
    public void testIncorrectAnswerTooSmallMultiplication() {
        assertFalse(arithmeticQuestionMultiplication.isCorrect("5"));
    }

    @Test
    public void testIncorrectAnswerTooLargeMultiplication() {
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
    public void testIncorrectAnswerTooSmallAddition() {
        assertFalse(arithmeticQuestionAddition.isCorrect("4"));
    }

    @Test
    public void testIncorrectAnswerTooLargeAddition() {
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
    public void testIncorrectAnswerTooSmallSubtraction() {
        assertFalse(arithmeticQuestionSubtraction.isCorrect("0"));
    }

    @Test
    public void testIncorrectAnswerTooLargeSubtraction() {
        assertFalse(arithmeticQuestionSubtraction.isCorrect("2"));
    }

    @Test
    public void testCorrectAnswerMultiplication() {
        assertEquals(6, arithmeticQuestionMultiplication.correctAnswer(ArithmeticQuestion.Operation.MULTIPLICATION,
                2,3));
    }

    @Test
    public void testCorrectAnswerAddition() {
        assertEquals(5, arithmeticQuestionMultiplication.correctAnswer(ArithmeticQuestion.Operation.ADDITION,
                2,3));
    }

    @Test
    public void testCorrectAnswerSubtraction() {
        assertEquals(1, arithmeticQuestionMultiplication.correctAnswer(ArithmeticQuestion.Operation.SUBTRACTION,
                3,2));
    }

    @Test
    public void testMultiplicationQuestionString() {
        assertEquals("What is 2 * 3 ?", arithmeticQuestionMultiplication.questionString(ArithmeticQuestion.Operation.MULTIPLICATION,
                2,3));
    }

    @Test
    public void testAdditionQuestionString() {
        assertEquals("What is 2 + 3 ?", arithmeticQuestionMultiplication.questionString(ArithmeticQuestion.Operation.ADDITION,
                2,3));
    }

    @Test
    public void testSubtractionQuestionString() {
        assertEquals("What is 3 - 2 ?", arithmeticQuestionMultiplication.questionString(ArithmeticQuestion.Operation.SUBTRACTION,
                3,2));
    }
}
