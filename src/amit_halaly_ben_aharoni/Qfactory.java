package amit_halaly_ben_aharoni;

import amit_halaly_ben_aharoni.questions.edifficulty;

public class Qfactory {

	private edifficulty diff = edifficulty.easy;
	
	
	public  questions createQuestion(String q , edifficulty diff) {
		switch (diff) {
		case easy: {
			return new american_question(q, diff);
		}
		case medium: {
			return new american_question(q, diff);
		}
		case hard: {
			return new american_question(q, diff);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + diff);
		}
		
	}
}
