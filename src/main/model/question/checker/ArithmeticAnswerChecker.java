package model.question.checker;

// Checks answers to arithmetic answer questions
public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        return answer == Integer.parseInt(userResponse);
    }
}
