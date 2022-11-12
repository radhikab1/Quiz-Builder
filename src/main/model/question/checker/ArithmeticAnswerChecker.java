package model.question.checker;

// Checks answers to arithmetic questions
public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    // EFFECTS: constructs checker for given answer
    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        try {
            Integer.parseInt(userResponse);
            return answer == Integer.parseInt(userResponse);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
