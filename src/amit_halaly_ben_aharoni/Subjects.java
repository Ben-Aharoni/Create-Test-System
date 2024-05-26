package amit_halaly_ben_aharoni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Subjects implements Serializable {
	private ArrayList<repositoryFacade> allrepositories = new ArrayList<repositoryFacade>();
	private static Subjects s = new Subjects();//static property for singleton use

	private Subjects() {//private constructor for singleton use
	}

	public static Subjects getS() {
		if (s == null)
			s= new Subjects();
		
		return s;
	}

	
	public void addRepository(repositoryFacade repositories) {
		allrepositories.add(repositories);
	}

	public ArrayList<repositoryFacade> getRepositories() {
		return allrepositories;
	}

	public String toString() {
		System.out.println("subjects:");
		for (int i = 0; i < allrepositories.size(); i++) {
			System.out.println();
			System.out.println((i + 1) + ")" + allrepositories.get(i).getSubject());
		}
		return "";
	}
}