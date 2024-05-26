package amit_halaly_ben_aharoni;

import java.io.Serializable;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class repositoryFacade implements Serializable {
	private ArrayList<questions> allQuestions = new ArrayList<questions>();
	private ArrayList<answer_text> allanswers = new ArrayList<answer_text>();

	private String subject;

	public repositoryFacade(String subject) {
		this.subject = subject;

	}

	public String getSubject() {
		return subject;
	}

	public ArrayList<answer_text> getAnswers() {
		return this.allanswers;
	}

	public ArrayList<questions> getQustion() {
		return this.allQuestions;
	}

	public boolean isNotEmpty() {
		if (allQuestions.size() == 0)
			return false;
		return true;
	}

	public void addanswer(answer_text answertext) {
		allanswers.add(answertext);
	}

	public void addquestion(questions questions) {
		allQuestions.add(questions);
	}

	public void addAnswerToQuestion(int place_of_answer, int place_of_qustion, boolean is_correct) {
		if (((american_question) allQuestions.get(place_of_qustion - 1)).canAddAnswer()) {
			((american_question) allQuestions.get(place_of_qustion - 1)).addAnswer(allanswers.get(place_of_answer - 1),
					is_correct);

		} else
			System.out.println("can't add more answer");

	}

	public void removeAnswer(int place_of_qustion, int place_of_answer) {
		((american_question) allQuestions.get(place_of_qustion - 1)).RemoveAnswers(place_of_answer - 1);
	}

	public void removeQuestion(int place_of_qustion) {
		allQuestions.remove(place_of_qustion - 1);
	}

	Iterator<questions> Qiterator() {
		return new QIterator();
	}

	private class QIterator implements Iterator<questions> {
		private int cur = 0;

		public boolean hasNext() {
			return cur < allQuestions.size();
		}

		public questions next() {
			questions value = allQuestions.get(cur++);
			return value;
		}

	}

	Iterator<answer_text> Aiterator() {
		return new AIterator();
	}

	private class AIterator implements Iterator<answer_text> {
		private int cur = 0;

		public boolean hasNext() {
			return cur < allanswers.size();
		}

		public answer_text next() {
			answer_text value = allanswers.get(cur);
			System.out.print("(" + (++cur) + ") ");
			return value;
		}

	}

	public void maxnumofquestions(int num_of_questions) throws Exception {
		if (num_of_questions > 10) {
			throw new QuestionsExceptions();
		}
	}

	public void minnumofanswers(int answer_to_add, int numofanswers) throws Exception {
		if (answer_to_add > allanswers.size()) {
			answer_to_add = answer_to_add - allanswers.size();
			throw new answersException(answer_to_add);
		}
	}
}
