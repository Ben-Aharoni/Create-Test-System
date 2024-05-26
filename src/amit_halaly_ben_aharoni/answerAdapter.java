package amit_halaly_ben_aharoni;

public class answerAdapter {
	public answer_text getText(hw3_answers a) {
		return a.hw3_getText();
	}

	public void setText(answer_text text, hw3_answers a) {
		a.hw3_setText(text);
	}

	public boolean getIs_correct(hw3_answers a) {
		return a.hw3_getIs_correct();
	}

	public void setIs_correct(boolean is_correct, hw3_answers a) {
		a.hw3_setIs_correct(is_correct);
		;
	}

	public String toString(hw3_answers a) {
		return a.hw3_toString();
	}
}
