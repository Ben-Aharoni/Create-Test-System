package amit_halaly_ben_aharoni;

import java.io.Serializable;

public class hw3_answers implements Serializable {

	private answer_text text;
	private boolean is_correct;

	public hw3_answers(answer_text text, boolean is_correct) {
		hw3_setText(text);
		hw3_setIs_correct(is_correct);
	}

	public answer_text hw3_getText() {
		return text;
	}

	public void hw3_setText(answer_text text) {
		this.text = text;
	}

	public boolean hw3_getIs_correct() {
		return is_correct;
	}

	public void hw3_setIs_correct(boolean is_correct) {
		this.is_correct = is_correct;
	}

	public String hw3_toString() {
		System.out.println(text.toString() + " (" + hw3_getIs_correct() + ")");
		return "";
	}

}
