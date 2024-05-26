package amit_halaly_ben_aharoni;

import amit_halaly_ben_aharoni.questions.edifficulty;

public class OQfactory {
private edifficulty diff = edifficulty.easy;
	
	
	public  questions createOpenQuestion(String q , answer_text a , edifficulty diff) {
		switch (diff) {
		case easy: {
			return new open_question(q, a, diff);
		}
		case medium: {
			return new open_question(q, a, diff);
		}
		case hard: {
			return new open_question(q, a, diff);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + diff);
		}
		
	}
}
