
//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class UpdateProject {

	//Static variable for program use.
	static String projectChosen;
	static int count;
	static String projectFile = "poised.txt";
	static ReadFile projectReader = new ReadFile(projectFile);
	static WriteFile projectWriter = new WriteFile(projectFile);
	//Update any project class and methods. If the user wants to update any of the existing projects it will be done here.
	//Again the user get a display to choose from the following.

	public static void updateMenu() throws IOException {
		System.out.println("Please choose one of the following:\n1) Change Architect\n2) Change Contractor\n"
				+ "3) Change the due date\n4) Update payment\n5) Finalise Project\n6) Return to START MENU\n");
		Scanner sc = new Scanner(System.in);	//Get user input.
		int userChoice = sc.nextInt();

		switch (userChoice) {
			case 1:
				architect();
				updateMenu();
				break;
			case 2:
				contractors();
				updateMenu();
				break;
			case 3:
				dateDue();
				updateMenu();
				break;
			case 4:
				amountPaid();
				updateMenu();
				break;
			case 5:
				projectFinalize();
				updateMenu();
				break;
			case 6:
				MainMenu.startMenu();	//Return to the start of the program.
				break;
		}
	}

	public static void architect() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		projectChosen = sc.next();
		sc.nextLine();
		projectReader.fileReadContent();
		List<String> inputFileContent = projectReader.getFileContent();
		projectReader.findProjectFieldsOnProject(projectChosen);
		List<String> mainProject = projectReader.getProjectRecord();

		//Replace the changed fields and update the contents of inputFileContent to the data file
		if ((mainProject != null) && (mainProject.size() >= 21)) {
			System.out.println("Please enter the name of the architect:");
			String arch_name = sc.next();
			mainProject.set(8, arch_name);
			sc.nextLine();

			System.out.println("Please enter the telephone number of the architect:");
			String arch_tel = sc.next();
			mainProject.set(9, arch_tel);
			sc.nextLine();

			System.out.println("Please enter the email of the architect:");
			String arch_email = sc.next();
			mainProject.set(10, arch_email);
			sc.nextLine();

			System.out.println("Please enter the address of the architect:");
			String arch_address = sc.next();
			mainProject.set(11, arch_address);
			sc.nextLine();
			if (projectReader.getFoundProjectIndex() >= 0) {
				inputFileContent.set(projectReader.getFoundProjectIndex(), mainProject.toString());
			}
			projectWriter.writeStringListFile(inputFileContent);	//Call the file write method and execute.
		}
		updateMenu();	//Return back to previous menu.
	}

	public static void contractors() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		projectChosen = sc.next();	//Get user input.
		sc.nextLine();
		projectReader.fileReadContent();
		List<String> inputFileContent = projectReader.getFileContent();
		projectReader.findProjectFieldsOnProject(projectChosen);
		List<String> mainProject = projectReader.getProjectRecord();

		if ((mainProject != null) && (mainProject.size() >= 21)) {
			System.out.println("Please enter the name of the contractor:");
			String cont_name = sc.next();
			mainProject.set(12, cont_name);
			sc.nextLine();

			System.out.println("Please enter the telephone number of the contractor:");
			String cont_tel = sc.next();
			mainProject.set(13, cont_tel);
			sc.nextLine();

			System.out.println("Please enter the email of the contractor:");
			String cont_email = sc.next();
			mainProject.set(14, cont_email);
			sc.nextLine();

			System.out.println("Please enter the address of the contractor:");
			String cont_address = sc.next();
			mainProject.set(15, cont_address);
			sc.nextLine();
			if (projectReader.getFoundProjectIndex() >= 0) {
				inputFileContent.set(projectReader.getFoundProjectIndex(), mainProject.toString());
			}
			projectWriter.writeStringListFile(inputFileContent);	//Call the file write method and execute.
		}
		updateMenu();	//Return back to previous menu.
	}

	public static void dateDue() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		projectChosen = sc.next();
		sc.nextLine();
		projectReader.fileReadContent();
		List<String> inputFileContent = projectReader.getFileContent();
		List<String> mainProject = projectReader.getProjectRecord();
		System.out.println("Please enter the new Due Date:");
		String due_date = sc.nextLine();
		mainProject.set(5, due_date);
		if (projectReader.getFoundProjectIndex() >= 0) {
			inputFileContent.set(projectReader.getFoundProjectIndex(), mainProject.toString());
		}
		projectWriter.writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}

	public static void amountPaid() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		projectChosen = sc.next();	//Get user input.
		sc.nextLine();
		projectReader.fileReadContent();
		List<String> inputFileContent = projectReader.getFileContent();
		List<String> mainProject = projectReader.getProjectRecord();
		System.out.println("Please enter the total amount of the fee paid to date:");
		String amount_paid = sc.nextLine();

		mainProject.set(6, amount_paid);
		if (projectReader.getFoundProjectIndex() >= 0) {
			inputFileContent.set(projectReader.getFoundProjectIndex(), mainProject.toString());
		}
		projectWriter.writeStringListFile(inputFileContent);
		updateMenu();	//Return back to previous menu.
	}

	public static void projectFinalize() throws IOException {
		//Ask the user, which project do they wish to update.
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Project Number of the project that you wish to update: ");
		projectChosen = sc.next();	//Get user input.
		sc.nextLine();
		projectReader.fileReadContent();
		List<String> inputFileContent = projectReader.getFileContent();
		List<String> mainProject = projectReader.getProjectRecord();
		System.out.println("Do you wish to mark this project as FINISHED?(YES or NO):");
		String finished = sc.nextLine();

		mainProject.set(20, finished);
		if (projectReader.getFoundProjectIndex() >= 0) {
			inputFileContent.set(projectReader.getFoundProjectIndex(), mainProject.toString());
		}
		projectWriter.writeStringListFile(inputFileContent);	//Call the file write method and execute.
		updateMenu();	//Return back to previous menu.
	}
}