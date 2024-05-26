package amit_halaly_ben_aharoni;

import java.util.ArrayList;
import java.util.List;

public class notifyListner implements observer {
private List<observer> listners = new ArrayList<>();
	

	public void addLisiner(observer l) {	
		listners.add(l);
	}

	public void notifyAllTheListners(int i){
		for(observer listner:  listners)
		{
			listner.actionCompleted(i);	
		}
		
	
	}
	public void actionCompleted(int i) {
		switch(i)
		{
		case 1:
			System.out.println("the new answer has been added!");
			break;
		case 2:
			System.out.println("the new repository has been added!");
			break;
		case 3:
			System.out.println("the automatic Exam has been created!");
		
		}
		
	}

}
