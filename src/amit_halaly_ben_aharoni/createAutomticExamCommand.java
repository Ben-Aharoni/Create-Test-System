package amit_halaly_ben_aharoni;

import java.io.FileNotFoundException;

public class createAutomticExamCommand implements Command {

	private automaticExam a;
	private repositoryFacade r;

	public createAutomticExamCommand(automaticExam a, repositoryFacade r) {
		this.a = a;
		this.r = r;
	}

	public void execute() {

		try {
			a.createExam(r);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
