
//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.*;
import java.util.Scanner;
import static poised.ReadFile.*;
import static poised.WriteFile.writeStringListFile;

public class UpdateProject {
	//Static variable for program use.
	static String pro;
	static int count;
	//Update any project class and methods. If the user wants to update any of the existing projects it will be done here.
	//Again the user get a display to choose from the following.
	public static void updateMenu() throws IOException {
		System.out.println("Please choose one of the following:\n1) Change Architect\n2) Change Contractor\n"+
				"3) Change the due date\n4) Update payment\n5) Finalise Project\n6) Return to START MENU\n");
		Scanner sc = new Scanner(System.in);	//Get user input.
		int userChoice = sc.nextInt();

		if (userChoice == 1){
			architect();		//Update the architect's info.
		}
		if (userChoice == 2){
			contractors();		//Update the contractor's info.
		}
		if (userChoice == 3){
			dateDue();			//Update the date that the project is due.
		}
		if (userChoice == 4){
			amountPaid();		//Update the total amount paid for a project.
		}
		if (userChoice == 5){
			projectFinalize();	//Place the project in a finished state.
		}
		if (userChoice == 6){
			MainMenu.startMenu();	//Return to the start of the program.
		}
	}

	public static void architect() throws IOException{
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		pro = sc.next();	//Get user input.
		sc.nextLine();
		fileReadContent();	//Call the read file method.
		while (count < 4)
			{
				System.out.println("Please enter the name of the architect:");
				String arch_name = sc.next();
				mainProject.set(8,arch_name);
				sc.nextLine();
				count++;

				System.out.println("Please enter the telephone number of the architect:");
				String arch_tel = sc.next();
				mainProject.set(9,arch_tel);
				sc.nextLine();
				count++;

				System.out.println("Please enter the email of the architect:");
				String arch_email = sc.next();
				mainProject.set(10,arch_email);
				sc.nextLine();
				count++;

				System.out.println("Please enter the address of the architect:");
				String arch_address = sc.next();
				mainProject.set(11,arch_address);
				sc.nextLine();
				count++;

			}
		if (foundLineIndex >= 0) {		//Scan through the file for the project and replace the data where it's needed.
			inputFileContent.set(foundLineIndex, mainProject.toString());
		}
		writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}
	public static void contractors() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		pro = sc.next();	//Get user input.
		sc.nextLine();
		fileReadContent();	//Call the read file method.
		while (count < 4)
		{
			System.out.println("Please enter the name of the contractor:");
			String cont_name = sc.next();
			mainProject.set(12,cont_name);
			sc.nextLine();
			count++;

			System.out.println("Please enter the telephone number of the contractor:");
			String cont_tel = sc.next();
			mainProject.set(13,cont_tel);
			sc.nextLine();
			count++;

			System.out.println("Please enter the email of the contractor:");
			String cont_email = sc.next();
			mainProject.set(14,cont_email);
			sc.nextLine();
			count++;

			System.out.println("Please enter the address of the contractor:");
			String cont_address = sc.next();
			mainProject.set(15,cont_address);
			sc.nextLine();
			count++;

		}
		if (foundLineIndex >= 0) {	//Scan through the file for the project and replace the data where it's needed.
			inputFileContent.set(foundLineIndex, mainProject.toString());
		}
		writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}
	public static void dateDue() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		pro = sc.next();	//Get user input.
		sc.nextLine();
		fileReadContent();	//Call the read file method.
		System.out.println("Please enter the new Due Date:");
		String due_date = sc.nextLine();

		mainProject.set(5, due_date);
		System.out.println(mainProject);
		if (foundLineIndex >= 0) {	//Scan through the file for the project and replace the data where it's needed.
			inputFileContent.set(foundLineIndex, mainProject.toString());
		}
		writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}
	public static void amountPaid() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		pro = sc.next();	//Get user input.
		sc.nextLine();
		fileReadContent();	//Call the read file method.
		System.out.println("Please enter the total amount of the fee paid to date:");
		String amount_paid = sc.nextLine();

		mainProject.set(5, amount_paid);
		System.out.println(mainProject);
		if (foundLineIndex >= 0) {	//Scan through the file for the project and replace the data where it's needed.
			inputFileContent.set(foundLineIndex, mainProject.toString());
		}
		writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.

	}
	public static void projectFinalize() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		pro = sc.next();	//Get user input.
		sc.nextLine();
		fileReadContent();	//Call the read file method.
		System.out.println("Do you wish to mark this project as FINISHED?:");
		String finished = sc.nextLine();

		mainProject.set(20, finished);
		System.out.println(mainProject);
		if (foundLineIndex >= 0) {	//Scan through the file for the project and replace the data where it's needed.
			inputFileContent.set(foundLineIndex, mainProject.toString());
		}
		writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}
}