package amit_halaly_ben_aharoni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import amit_halaly_ben_aharoni.questions.edifficulty;

public class create_test {

	public static void writeRepository(repositoryFacade r) throws IOException, FileNotFoundException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("binaryRfile.dat"));
		outFile.writeObject(r);
		outFile.close();
	}

	public static repositoryFacade readRepository() throws IOException, ClassNotFoundException {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("binaryRfile.dat"));
		repositoryFacade r = (repositoryFacade) inFile.readObject();
		inFile.close();
		return r;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
		Subjects s = Subjects.getS();
		Qfactory qf = new Qfactory();
		OQfactory oqf = new OQfactory();
		ATfactory atf = new ATfactory();

		repositoryFacade r = new repositoryFacade("general knowledge");
		r.addquestion(qf.createQuestion("1 + 1 ?", edifficulty.easy));
		r.addquestion(qf.createQuestion("2 + 2 ?", edifficulty.easy));
		r.addquestion(qf.createQuestion("4 + 4 ?", edifficulty.medium));
		r.addquestion(qf.createQuestion("2 - 1 ?", edifficulty.medium));
		r.addquestion(qf.createQuestion("4 + 5 ?", edifficulty.easy));
		r.addquestion(qf.createQuestion("3 + 3 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("4 + 8 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("7 + 7 ?", edifficulty.medium));
		r.addquestion(qf.createQuestion("7 - 5 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("10 - 9 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("9 - 9 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("7 - 4 ?", edifficulty.hard));
		r.addquestion(qf.createQuestion("6 + 6 ?", edifficulty.easy));
		r.addquestion(qf.createQuestion("10 + 1 ?", edifficulty.hard));
		r.addquestion(oqf.createOpenQuestion("who is the most amazing person in world ?",
				atf.getAnswer_Text("ben aharoni kallll!!!!!"), edifficulty.easy));
		r.addquestion(oqf.createOpenQuestion("who is the most amazing lecturer in world ?",
				atf.getAnswer_Text("keren kalif kallll!!!!!"), edifficulty.medium));
		r.addquestion(oqf.createOpenQuestion("who's gonna get 100 in the final test ?",
				atf.getAnswer_Text("ben and amit for sure"), edifficulty.easy));
		r.addquestion(oqf.createOpenQuestion("who said the famous quote ''ini thi bininging'' ?",
				atf.getAnswer_Text("jacob zuma"), edifficulty.hard));
		r.addquestion(oqf.createOpenQuestion("which singer is nicknamed ''the king'' ?",
				atf.getAnswer_Text("zohar argov"), edifficulty.medium));
		r.addquestion(oqf.createOpenQuestion("what is the best course in afeka ?",
				atf.getAnswer_Text("development tools"), edifficulty.easy));

		r.addanswer(atf.getAnswer_Text("89"));
		r.addanswer(atf.getAnswer_Text("1000"));
		r.addanswer(atf.getAnswer_Text("0"));
		r.addanswer(atf.getAnswer_Text("1"));
		r.addanswer(atf.getAnswer_Text("3"));
		r.addanswer(atf.getAnswer_Text("4"));
		r.addanswer(atf.getAnswer_Text("5"));
		r.addanswer(atf.getAnswer_Text("6"));
		r.addanswer(atf.getAnswer_Text("7"));
		r.addanswer(atf.getAnswer_Text("8"));
		r.addanswer(atf.getAnswer_Text("9"));
		r.addanswer(atf.getAnswer_Text("10"));
		r.addanswer(atf.getAnswer_Text("11"));
		r.addanswer(atf.getAnswer_Text("12"));
		r.addanswer(atf.getAnswer_Text("13"));
		r.addanswer(atf.getAnswer_Text("14"));
		r.addanswer(atf.getAnswer_Text("15"));
		r.addanswer(atf.getAnswer_Text("16"));
		r.addanswer(atf.getAnswer_Text("17"));
		r.addanswer(atf.getAnswer_Text("18"));
		writeRepository(r);

		// repository r = readRepository();
		s.addRepository(r);
		notifyListner nl = new notifyListner();

		int choose = 0;
//create a repository
		do {
			System.out.println("press:\n 1) to view all the questions and the answers for each question \n "
					+ "2) to add a new answer to repository \n"
					+ " 3) to add a new answer to an american question only \n " + "4) to add a new question \n"
					+ " 5) to remove a certain answer from a question \n" + " 6) to remove a question \n"
					+ " 7) to create a new repositry \n" + " 8) to register a new subscriber\n " + "-1) to exit  \n ");

			// Ait = r.Aiterator();
			choose = input.nextInt();
			switch (choose) {
			case 1:
				int choose_subject = -1, flag1 = 0;
				while (flag1 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject = input.nextInt();
					if (choose_subject > s.getRepositories().size() || choose_subject < 0) {
						System.out.println("invalid input");
					} else
						flag1 = 1;
				}
				if (s.getRepositories().get(choose_subject - 1).isNotEmpty()) {
					Iterator<questions> it = s.getRepositories().get(choose_subject - 1).Qiterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}
					it = r.Qiterator();
				} else
					System.out.println("there is no questions in that repository");

				break;

			case 2:
				int flag2 = 0, choose_subject1 = 0;
				while (flag2 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject1 = input.nextInt();
					if (choose_subject1 > s.getRepositories().size() || choose_subject1 < 0) {
						System.out.println("invalid input");
					} else
						flag2 = 1;

				}
				String answertext;
				System.out.println("write your answer:");
				answertext = input.next();
				Command ana = new AddNewAnswerCommand(answertext, s.getRepositories().get(choose_subject1 - 1));
				ana.execute();
				nl.notifyAllTheListners(1);
				break;

			case 3:

				int choose1 = 0, choose2 = 0, count3 = 1, choose_subject2 = 0, flag3 = 0;
				boolean iscorrect = true;
				while (flag3 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject2 = input.nextInt();
					if (choose_subject2 > s.getRepositories().size() || choose_subject2 < 0) {
						System.out.println("invalid input");
					} else
						flag3 = 1;
				}
				if (s.getRepositories().get(choose_subject2 - 1).isNotEmpty()) {
					System.out.println("choose a question from the list:");
					Iterator<questions> it = s.getRepositories().get(choose_subject2 - 1).Qiterator();
					while (it.hasNext()) {

						if (it.next() instanceof american_question) {
							System.out.print("(" + count3++ + ") ");
							System.out.println(it.next());

						}
					}
					if (s.getRepositories().get(choose_subject2 - 1).getAnswers().size() > 2) {
						choose1 = input.nextInt();
						System.out.println("choose an answer from the list: ");
						Iterator<answer_text> Ait = s.getRepositories().get(choose_subject2 - 1).Aiterator();
						while (Ait.hasNext()) {
							System.out.println(Ait.next());
						}
						choose2 = input.nextInt();
						System.out.println("enter if true or false:");
						iscorrect = input.nextBoolean();
						s.getRepositories().get(choose_subject2 - 1).addAnswerToQuestion(choose2, choose1, iscorrect);
					} else
						System.out.println("there is no answers in that repository");
				} else
					System.out.println("there is no questions in that repository");
				break;

			case 4:
				int flag4 = 0, choose_subject3 = 0;
				while (flag4 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject3 = input.nextInt();
					if (choose_subject3 > s.getRepositories().size() || choose_subject3 < 0) {
						System.out.println("invalid input");
					} else
						flag4 = 1;
				}
				String newquestion = "";
				System.out.println("what type of question do you want to add? 1-american/2-open");
				int q_type = input.nextInt();
				if (q_type == 1) {
					System.out.println("write your question : ");
					newquestion = input.next();
					System.out.println("what level of difficulty is the question? (easy-e/medium-m/hard-h");
					char choice = input.next().charAt(0);

					if (choice == 'e') {
						s.getRepositories().get(choose_subject3 - 1)
								.addquestion(new american_question(newquestion, edifficulty.easy));
					} else if (choice == 'm') {
						s.getRepositories().get(choose_subject3 - 1)
								.addquestion(new american_question(newquestion, edifficulty.medium));
					} else {
						s.getRepositories().get(choose_subject3 - 1)
								.addquestion(new american_question(newquestion, edifficulty.hard));
					}
				} else {
					System.out.println("write your question : ");
					newquestion = input.next();
					System.out.println("write the answer for your question : ");
					String newanswer = input.next();
					System.out.println("what level of difficulty the question is? (easy-e/medium-m/hard-h");
					char choice2 = input.next().charAt(0);

					if (choice2 == 'e') {
						s.getRepositories().get(choose_subject3 - 1).addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.easy));
					} else if (choice2 == 'm') {
						s.getRepositories().get(choose_subject3 - 1).addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.medium));
					} else {
						s.getRepositories().get(choose_subject3 - 1).addquestion(
								new open_question(newquestion, new answer_text(newanswer), edifficulty.hard));
					}
				}
				break;

			case 5:
				int choose4 = 0, choose6 = 0, count5 = 1, flag5 = 0, choose_subject4 = 0;
				while (flag5 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject4 = input.nextInt();
					if (choose_subject4 > s.getRepositories().size() || choose_subject4 < 0) {
						System.out.println("invalid input");
					} else
						flag5 = 1;
				}
				if (s.getRepositories().get(choose_subject4 - 1).isNotEmpty()) {
					System.out.println("choose a question from the list:");
					Iterator<questions> it = s.getRepositories().get(choose_subject4 - 1).Qiterator();
					while (it.hasNext()) {
						questions question = it.next();
						if (question instanceof american_question) {
							System.out.print("(" + count5++ + ") ");
							System.out.println(question);
						}
					}
					choose4 = input.nextInt();
					System.out.println(s.getRepositories().get(choose_subject4 - 1).getQustion().get(choose4 - 1));
					System.out.println("choose an answer to remove");
					choose6 = input.nextInt();
					s.getRepositories().get(choose_subject4 - 1).removeAnswer(choose4, choose6);
				} else
					System.out.println("there is no questions in that repository");
				break;

			case 6:
				int choose3 = 0, count6 = 1, flag6 = 0, choose_subject5 = 0;
				while (flag6 == 0) {
					System.out.println("choose a subject:");
					s.toString();
					choose_subject5 = input.nextInt();
					if (choose_subject5 > s.getRepositories().size() || choose_subject5 < 0) {
						System.out.println("invalid input");
					} else
						flag5 = 1;
				}
				if (s.getRepositories().get(choose_subject5 - 1).isNotEmpty()) {
					System.out.println("choose a question to remove from the list:");
					Iterator<questions> it = s.getRepositories().get(choose_subject5 - 1).Qiterator();
					while (it.hasNext()) {
						System.out.print("(" + count6++ + ") ");
						System.out.println(it.next());
					}
					choose3 = input.nextInt();
					s.getRepositories().get(choose_subject5 - 1).removeQuestion(choose3);
				} else
					System.out.println("there is no questions in that repository");
				break;
			case 7:
				input.nextLine();
				System.out.println("enter the subject of the repository");
				String subject = input.nextLine();
				Command cr = new createNewRepositoryCommand(s, subject);
				cr.execute();
				nl.notifyAllTheListners(2);
				break;
			case 8:
				nl.addLisiner(new notifyListner());
				break;
			default:
				if (choose != -1)
					System.out.println("invalid case please try again");
			}

		} while (choose != -1);
		System.out.println("goodbye :(");
//create a test file
		int choose3 = 0, flag = 0, choose_subject = 0;
		while (flag == 0) {
			System.out.println("choose a subject that you want to create a test with:");
			s.toString();
			choose_subject = input.nextInt();
			if (choose_subject > s.getRepositories().size() || choose_subject < 0) {
				System.out.println("invalid input");
			} else
				flag = 1;
		}
		do {
			System.out.println("press:\n 1) for manual exam \n " + "2) for automatic exam \n" + "-1) to exit");
			choose3 = input.nextInt();
			switch (choose3) {
			case 1:
				manualExam m = new manualExam();
				m.createExam(s.getRepositories().get(choose_subject - 1));
				System.out.println("created!");
				break;
			case 2:
				// automaticExam a = new automaticExam();
				Command tc = new createAutomticExamCommand(new automaticExam(),
						s.getRepositories().get(choose_subject - 1));
				// a.createExam(s.getRepositories().get(choose_subject - 1));
				tc.execute();
				nl.notifyAllTheListners(3);
				break;

			default:
				if (choose3 != -1)
					System.out.println("invalid case please try again");
			}
		} while (choose3 != -1);
		System.out.println("goodbye!");

	}
}