package amit_halaly_ben_aharoni;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class manualExam implements Examable {
	private repositoryFacade r;
	Scanner input = new Scanner(System.in);
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy-HH-mm");

	@Override
	public void createExam(repositoryFacade r) throws FileNotFoundException {
		Iterator<questions> it = r.Qiterator();
		Iterator<answer_text> Ait = r.Aiterator();
		answerAdapter a = new answerAdapter();
		PrintWriter pw = new PrintWriter(new File("exam-" + (df.format(date)) + ".txt"));
		PrintWriter pwa = new PrintWriter(new File("solution-" + (df.format(date)) + ".txt"));
		int question_counter = 0;
		int num_of_question = 0;
		boolean is_valid_num = false;
		if (r.isNotEmpty()) {
			while (!is_valid_num) {
				System.out.println("please enter how many question do you want? (there is " + r.getQustion().size()
						+ " in that subject)");
				try {
					num_of_question = input.nextInt();
					r.maxnumofquestions(num_of_question);
					is_valid_num = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			pw.println("the test:\n");
			pwa.println("the test with solutions:\n");
			while (question_counter < num_of_question) {
				int choose_test1 = 0;
				int choose_test2 = 0;
				int counter_answer = 0;
				boolean is_correct = true;
				System.out.println("choose a question from the list: ");
				int count = 1;
				while (it.hasNext()) {
					System.out.print("(" + count++ + ") ");
					System.out.println(it.next());
				}
				choose_test1 = input.nextInt();
				pw.println("(Q" + (question_counter + 1) + ") " + r.getQustion().get(choose_test1 - 1));
				pwa.println("(Q" + (question_counter + 1) + ") " + r.getQustion().get(choose_test1 - 1));
				if (r.getQustion().get(choose_test1 - 1) instanceof american_question) {
					int answer_to_add = 6
							- ((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers().size();
					is_valid_num = false;
					while (!is_valid_num) {
						System.out.println("how many answers would you like for this question");
						int numofanswers = input.nextInt();
						try {
							r.minnumofanswers(answer_to_add, numofanswers);
							System.out.println("these are the answers to the question you choosed from the repository");
							for (int i = 0; i < ((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers()
									.size(); i++) {
								System.out.println((i + 1) + ") " + a.getText(
										((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers().get(i))
										.getSolution());
							}

							for (int i = 0; i < numofanswers; i++) {
								System.out.println("choose an answer from the list:");
								while (Ait.hasNext()) {
									System.out.println(Ait.next());
								}
								Ait = r.Aiterator();
								System.out.println();
								choose_test2 = input.nextInt();
								System.out.println("is the answer true or false?");
								is_correct = input.nextBoolean();
								r.addAnswerToQuestion(choose_test2, choose_test1, is_correct);
							}
							is_valid_num = true;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}

					for (int i = 0; i < ((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers()
							.size(); i++) {
						((american_question) r.getQustion().get(choose_test1 - 1)).booleanAnswer();
						pw.println((counter_answer + 1) + ") "
								+ a.getText(
										((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers().get(i))
										.getSolution());
						pwa.println((counter_answer + 1) + ") "
								+ a.getText(
										((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers().get(i))
										.getSolution()
								+ " ("
								+ a.getIs_correct(
										((american_question) r.getQustion().get(choose_test1 - 1)).getAnswers().get(i))
								+ ")");
						counter_answer++;
					}
				} else {
					pwa.println(((open_question) r.getQustion().get(choose_test1 - 1)).getAnswer().toString());
					pw.println("_________________________________________________.");
				}

				question_counter++;
				pw.println("------------------------------------------\n");
				pwa.println("-----------------------------------------\n");
			}

		} else {
			pw.println("you are wasting paper :(");
			pwa.println("you are wasting paper :(");
		}
		pw.println("End");
		pwa.println("End");
		pw.close();
		pwa.close();
	}

}
