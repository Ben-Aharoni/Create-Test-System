package amit_halaly_ben_aharoni;

public class createNewRepositoryCommand implements Command {

	private Subjects s;
	private String name;

	public createNewRepositoryCommand(Subjects s, String name) {

		this.s = s;
		this.name = name;

	}

	public void execute() {
		s.addRepository(new repositoryFacade(name));
	}
}
