package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class LimitedTriesQuizTest extends QuizTest {
    private LimitedTriesQuiz limitedTriesQuiz;
    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        limitedTriesQuiz = new LimitedTriesQuiz(questionList);
        quiz = limitedTriesQuiz;
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals(6, quiz.getMaxMark());
    }

    @Test
    void testSubmitAnswerAllCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 6 out of 6", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrectAttemptsLeft() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 6 out of 6", quiz.endQuiz());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerPartiallyCorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Mars");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Jupiter");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Saturn");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Pluto");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {

        }

        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(2, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 2 out of 6", quiz.endQuiz());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrectNoAttemptsLeft() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Mars");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Jupiter");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Saturn");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Pluto");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {

        }

        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("China");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Russia");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 0 out of 6", quiz.endQuiz());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {

        }
    }
}
