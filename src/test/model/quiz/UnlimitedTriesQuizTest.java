package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnlimitedTriesQuizTest extends QuizTest {
    private UnlimitedTriesQuiz unlimitedTriesQuiz;

    @BeforeEach
    void runBefore() {
        QuestionList questionList = generateQuestionList();
        unlimitedTriesQuiz = new UnlimitedTriesQuiz(questionList);
        quiz = unlimitedTriesQuiz;
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
            assertEquals(1, unlimitedTriesQuiz.getNumAttempts());
            quiz.getNextQuestion();
            feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(2, unlimitedTriesQuiz.getNumAttempts());
            assertEquals("It took you 2 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (Exception e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrectOnce() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertEquals(2, unlimitedTriesQuiz.getNumAttempts());
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
            assertEquals(3, unlimitedTriesQuiz.getNumAttempts());
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
            assertEquals(4, unlimitedTriesQuiz.getNumAttempts());
            assertEquals("It took you 4 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrect() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(2, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }

    @Test
    void testSubmitAnswerAllIncorrectMultipleTimes() {
        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("erth");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(1, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("saturn");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(2, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("jupiter");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(3, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("moon");
            assertEquals("Incorrect!", feedback);
            assertEquals(0, quiz.getMarkSoFar());
            assertEquals(4, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertEquals(5, unlimitedTriesQuiz.getNumAttempts());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Cambodia");
            assertEquals("Incorrect!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(6, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("China");
            assertEquals("Incorrect!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(7, unlimitedTriesQuiz.getNumAttempts());
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
            assertEquals(8, unlimitedTriesQuiz.getNumAttempts());
            assertEquals("It took you 8 attempts to answer 2 questions correctly.", quiz.endQuiz());
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
            assertEquals(1, unlimitedTriesQuiz.getNumAttempts());
            fail("Expected AnswerIncorrectException");
        } catch (AnswerIncorrectException e) {

        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }

        try {
            String feedback = quiz.submitAnswer("Earth");
            assertEquals("Correct!", feedback);
            assertEquals(4, quiz.getMarkSoFar());
            assertEquals(2, unlimitedTriesQuiz.getNumAttempts());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }


        try {
            quiz.getNextQuestion();
            String feedback = quiz.submitAnswer("Canada");
            assertEquals("Correct!", feedback);
            assertEquals(6, quiz.getMarkSoFar());
            assertFalse(quiz.hasMoreQuestions());
            assertEquals(3, unlimitedTriesQuiz.getNumAttempts());
            assertEquals("It took you 3 attempts to answer 2 questions correctly.", quiz.endQuiz());
        } catch (AnswerIncorrectException e) {
            fail("Should not have thrown exception.");
        } catch (OutOfTriesException e) {
            fail("Should not have thrown exception.");
        }
    }
}
