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
            assertTrue(quiz.hasMoreQuestions());
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
    void testSubmitAnswerAllIncorrectOnFirstTryOnly() {
        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(3, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("Cambodia");
            assertEquals(3, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 4 out of 6", quiz.endQuiz());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrectUntilLastAttempt() {
        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("saturn");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("jupiter");
            assertEquals(0, quiz.getMarkSoFar());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(1, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("Cambodia");
            assertEquals(1, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
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
            quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Mars");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Jupiter");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Pluto");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {

        }

        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("Cambodia");
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Russia");
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals("Your final mark is: 0 out of 6", quiz.endQuiz());
            assertFalse(quiz.hasMoreQuestions());
            fail("Expected OutOfTriesException");
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {

        }
    }

    @Test
    void testSubmitAnswerPartiallyCorrect() {
        try {
            quiz.getNextQuestion();
            quiz.submitAnswer("erth");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Mars");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Jupiter");
            assertEquals(0, quiz.getMarkSoFar());
            assertTrue(quiz.hasMoreQuestions());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.submitAnswer("Pluto");
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
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
}
