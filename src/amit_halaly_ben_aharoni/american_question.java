package amit_halaly_ben_aharoni;

import java.io.Serializable;
import java.util.ArrayList;

public class american_question extends questions implements Serializable {
	private ArrayList<hw3_answers> answer = new ArrayList<hw3_answers>();
	private final int max_numofanswers = 10;

	public american_question(String question, edifficulty difficulty) {
		super(question, difficulty);
		answer.add(new hw3_answers(new answer_text("more then one answer is true"), false));
		answer.add(new hw3_answers(new answer_text("all answers is wrong"), true));
	}

	public boolean canAddAnswer() {
		if (answer.size() < max_numofanswers) {
			return true;
		} else
			return false;
	}

	public void addAnswer(answer_text answer_text, boolean is_correct) {
		answer.add(new hw3_answers(answer_text, is_correct));
	}

	public void RemoveAnswers(int placeofanswer) {
		if (answer.size() < placeofanswer) {
			System.out.println("no answer to remove");
			return;
		}
		answer.remove(placeofanswer);
	}

	public void booleanAnswer() {
		answerAdapter a = new answerAdapter();
		int counter = 0;
		for (int i = 2; i < answer.size(); i++) {
			if (i == answer.size()) {
				return;
			}
			if (a.getIs_correct(answer.get(i)) == true) {
				counter++;
				if (counter == 1) {
					a.setIs_correct(false, answer.get(1));
				}
				if (counter >= 2) {
					a.setIs_correct(true, answer.get(0));
					a.setIs_correct(false, answer.get(1));
				}
			}
		}
	}

	public edifficulty getdifficulty() {
		return difficulty;
	}

	public ArrayList<hw3_answers> getAnswers() {
		return answer;
	}

	public String toString() {
		answerAdapter a = new answerAdapter();
		System.out.println(super.toString());
		for (int j = 0; j < answer.size(); j++) {
			if (j == answer.size()) {
				System.out.println();
				return "";
			}
			System.out.print((j + 1) + ") ");
			System.out.print(a.toString(answer.get(j)));
		}
		return "\n";
	}
}
