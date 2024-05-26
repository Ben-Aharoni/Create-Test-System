package amit_halaly_ben_aharoni;

public class AddNewAnswerCommand implements Command {
	private String name;
	private repositoryFacade r;

	public AddNewAnswerCommand(String name, repositoryFacade r) {
		this.name = name;
		this.r = r;

	}

	@Override
	public void execute() {
		r.addanswer(new answer_text(name));
	}
}
