package EvamJavaBootcampWeek3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * HATTAP
 * TAN
 * */

public class Main {
	// needed varables
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();
	public static boolean checkError = true;

	// define a method to to check for possible errors.
	public static String checkInput(String[] str) {
		String event1 = str[0].toLowerCase();
		if (str.length == 1) {

			if (!(event1.equals("served"))) {
				checkError = false;
				return "error5"; // error1 ; if write served not correctly
			} else {
				checkError = true;
			}
		}
		if (str.length != 4) {

			if (str.length == 1) {
				if (!(event1.equals("served"))) {
					checkError = false;
					return "error5"; // error1
				} else {
					checkError = true;
				}
			} else {
				checkError = false;

				return "error0"; // error0; if event lengt is not equal 4
			}

		} else {

			String event = str[0].toLowerCase();
			String name = str[1];
			String Cgpa1 = str[2];
			double Cgpa = Double.parseDouble(Cgpa1);
			String id = str[3];
			int ID = Integer.parseInt(id);

			if (!(event.equals("enter"))) {
				checkError = false;
				return "error1"; // error1; if write "enter" not correctly
			} else {
				checkError = true;
			}
			if (name.length() < 1 || name.length() > 31) { // error2 ; if name length is not between 2 and 30
				checkError = false;
				return "error2"; //
			} else {
				checkError = true;
			}
			if (Cgpa < 0 || Cgpa > 4.00) {
				checkError = false;
				return "error3"; // error3 ; if cgpa is not between 0 and 4.00
			} else {
				checkError = true;
			}
			if (ID < 1 || ID > Math.pow(10, 5)) {
				checkError = false;
				return "error4"; // error4; if id is not between 1 and 100000
			} else {
				checkError = true;
			}

		}
		return "tr";

	}

	public static void main(String[] args) {

		System.out.println("******************MENU*******************"); // menu for user to use predefined data (
																			// choise 1)
		System.out.println("*       PLESE SELECT AN OPTÝON          *"); // or enter data manually ( choise 2)
		System.out.println("*                                       *");
		System.out.println("*       1. Use Predefined Data          *");
		System.out.println("*       2. Enter Data Manually          *");
		System.out.println("*                                       *");
		System.out.println("*****************************************");
		System.out.print("Choise : ");

		List<String> events = new ArrayList<>();
		// an array for predefined data
		Object[] predefinedData = { "ENTER John 3.75 50", "ENTER Mark 3.8 24", "ENTER Shafaet 3.7 35", "SERVED",
				"SERVED", "ENTER Samiha 3.85 36", "SERVED", "ENTER Ashley 3.9 42", "ENTER Maria 3.6 46",
				"ENTER Anik 3.95 49", "ENTER Dan 3.95 50", "SERVED" };

		int menuOption = scan.nextInt();
		System.out.println();

		// check number of selection of menu; must be 1 or 2
		while (menuOption < 1 || menuOption > 2) {
			System.out.print("Please enter number  ONLY 1 or 2 :  ");
			menuOption = scan.nextInt();
			System.out.println();
		}
		if (menuOption == 1) { // show user the number which he or she select.
			System.out.println("Your choise is :  " + menuOption + " (Predefined data)");
		} else {
			System.out.println("Your choise is :  " + menuOption + " (Manuel data from user)");
		}

		if (menuOption == 1) {
			// show predefined data to user
			for (int i = 0; i < predefinedData.length; i++) {

				String eventPredefined = (String) predefinedData[i];
				if (i % 3 == 0) {
					System.out.println();
				}
				int number = i + 1;

				System.out.print((number) + ". Data is : " + eventPredefined + "      *      ");
				events.add(eventPredefined);

			}

		} else { // select 2; if user wants to enter data manually

			System.out.print("Please enter number of  Event, Between 2 and 1000    :  ");
			int numberOfEvents = scan.nextInt();
			System.out.println();
			while (numberOfEvents < 2 || numberOfEvents > 1000) {
				System.out.print("Please enter number of  Event ONLY Between 2 and 1000   :  ");
				numberOfEvents = scan.nextInt();
				System.out.println();
			}

			int counter = 0;
			// control number of event; must be between 2 and 1000
			while (counter != numberOfEvents) {
				System.out.print("Please Enter " + (counter + 1) + ". Event  :   ");
				String event = scan.nextLine();
				while (event.equals("")) {
					event = scan.nextLine();
				}
				System.out.println();
				String[] checkInputsFromUser = event.split(" ");

				String controlInputs = checkInput(checkInputsFromUser);

				// control all possible error
				if (!controlInputs.equals("tr")) {
					if (checkError == false) {

						while (checkError == false) {

							// error 0
							if (controlInputs.equals("error0")) {
								System.out.println("You entered a missing value.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}
							// error 1
							if (controlInputs.equals("error1")) {
								System.out.println("please  type  ENTER correctly.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}
							// error 2
							if (controlInputs.equals("error2")) {
								System.out.println("name length must be between 2 and 30.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}
							// error 3
							if (controlInputs.equals("error3")) {
								System.out.println("Cgpa must be between 0 and 4.00.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}
							// error 4
							if (controlInputs.equals("error4")) {
								System.out.println("ID must be between 1 and 100000.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}
							// error 5
							if (controlInputs.equals("error5")) {
								System.out.println("please spell SERVED correctly.");
								System.out.print("Please Enter " + (counter + 1) + ". Event Again :   ");
								event = scan.nextLine();
								System.out.println();
								checkInputsFromUser = event.split(" ");
								controlInputs = checkInput(checkInputsFromUser);

							}

						}

					}
				}

				// after all, add events all dataa
				System.out.println();
				events.add(event);
				counter++;
			}

		}
		System.out.println();
		System.out.println("-*-*-*-*-*-*-*-");
		List<Student> students = priorities.getStudents(events);

		// print result to screen.
		if (students.isEmpty()) {
			System.out.println(" THE LIST IS EMPTY");
		} else {

			for (Student st : students) {

				System.out.println(" - " + st.getName() + " - ");

			}
			System.out.println("-*-*-*-*-*-*-*-");
		}
	}

}
