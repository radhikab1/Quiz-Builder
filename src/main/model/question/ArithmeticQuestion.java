package model.question;


import model.question.checker.ArithmeticAnswerChecker;

// Represents a question whose answer is an arithmetic computation (integer)
public class ArithmeticQuestion extends Question {
    public enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION
    }

    // REQUIRES: maxMark must be >= 0
    // EFFECTS: constructs arithmetic answer question with given maximum mark, question statement consisting of given
    // operation, first operand, and second operand, and correct answer given operation, first operand, and
    // second operand
    public ArithmeticQuestion(int maxMark, Operation operation, int firstOp, int secondOp) {
        super(maxMark, questionString(operation, firstOp, secondOp),
                new ArithmeticAnswerChecker(correctAnswer(operation, firstOp, secondOp)));

    }

    // REQUIRES: Operation is either "+", "-", or "*"
    // EFFECTS: returns correct answer to arithmetic question given operation, first operand, and second operand
    static int correctAnswer(Operation operation, int firstOp, int secondOp) {
        switch (operation) {
            case ADDITION:
                return firstOp + secondOp;
            case SUBTRACTION:
                return firstOp - secondOp;
            default:
                return firstOp * secondOp;
        }
    }

    // REQUIRES: Operation is either "+", "-", or "*"
    // EFFECTS: returns question string of arithmetic question given the operation, first operand, and second operand
    static String questionString(Operation operation, int firstOp, int secondOp) {
        switch (operation) {
            case ADDITION:
                return "What is " + firstOp + " " + "+" + " " + secondOp + " ?";
            case SUBTRACTION:
                return "What is " + firstOp + " " + "-" + " " + secondOp + " ?";
            default:
                return "What is " + firstOp + " " + "*" + " " + secondOp + " ?";
        }
    }
}
