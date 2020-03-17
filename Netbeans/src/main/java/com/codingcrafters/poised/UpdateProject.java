package com.codingcrafters.poised;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class UpdateProject {

    //Static variable for program use.
    static String projectChosen;
    static int count;
    static Scanner sc = new Scanner(System.in);
    static String projectFile = "poised.txt";
    static ReadFile projectReader = new ReadFile(projectFile);
    static WriteFile projectWriter = new WriteFile(projectFile);
    //Update any project class and methods. If the user wants to update any of the existing projects it will be done here.
    //Again the user get a display to choose from the following.

    private static String getQuestionInput(String question) {
        String result = "";
        System.out.println(question);
        result = sc.nextLine();
        //sc.nextLine();
        return result;
    }

    public static void updateMenu() throws IOException {
        System.out.println("Please choose one of the following:\n1) Change Architect\n2) Change Contractor\n"
                + "3) Change the due date\n4) Update payment\n5) Finalise Project\n6) Return to START MENU\n");
        Scanner sc = new Scanner(System.in);	//Get user input.
        int userChoice = sc.nextInt();

        switch (userChoice) {
            case 1:
                architect();		//Update the architect's info.
                break;
            case 2:
                contractors();
                break;
            case 3:
                dateDue();
                break;
            case 4:
                amountPaid();
                break;
            case 5:
                projectFinalize();	//Place the project in a finished state.
                break;
            case 6:
                MainMenu.startMenu();	//Return to the start of the program.
                break;
        }
    }

    private static void getPrologueSelectProject() throws IOException {
        projectChosen = getQuestionInput("Please enter the Project Number of the project that you wish to update: ");
        projectReader.fileReadContent();
        projectReader.findProjectFieldsOnProject(projectChosen);
        if (projectReader.getFoundProjectIndex() < 0) {
            System.out.println("\nYou have entered a non-existing project, please try again\n");
            MainMenu.startMenu();
        }
    }

    private static void updateProjectData(List<String> inputFileContent, List<String> mainProject) {
        int projectIndex = projectReader.getFoundProjectIndex();
        if (projectIndex >= 0) {
            inputFileContent.set(projectIndex, mainProject.toString());
        }
        projectWriter.writeStringListFile(inputFileContent);	//Call the file write method and execute.   
    }

    public static void architect() throws IOException {
        //Ask the user, which project do they wish to update.
        getPrologueSelectProject();
        List<String> inputFileContent = projectReader.getFileContent();
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
            updateProjectData(inputFileContent, mainProject);
        }
        updateMenu();	//Return back to previous menu.
    }

    public static void contractors() throws IOException {
        //Ask the user, which project do they wish to update.
        getPrologueSelectProject();
        List<String> inputFileContent = projectReader.getFileContent();
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
            updateProjectData(inputFileContent, mainProject);
        }
        updateMenu();	//Return back to previous menu.
    }

    public static void dateDue() throws IOException {
        //Ask the user, which project do they wish to update.
        getPrologueSelectProject();
        List<String> inputFileContent = projectReader.getFileContent();
        List<String> mainProject = projectReader.getProjectRecord();
        System.out.println("Please enter the new Due Date:");
        String due_date = sc.nextLine();

        mainProject.set(5, due_date);
        System.out.println(mainProject);
        updateProjectData(inputFileContent, mainProject);
        updateMenu();	//Return back to previous menu.
    }

    public static void amountPaid() throws IOException {
        //Ask the user, which project do they wish to update.
        getPrologueSelectProject();
        List<String> inputFileContent = projectReader.getFileContent();
        List<String> mainProject = projectReader.getProjectRecord();
        System.out.println("Please enter the total amount of the fee paid to date:");
        String amount_paid = sc.nextLine();

        mainProject.set(6, amount_paid);
        System.out.println(mainProject);
        updateProjectData(inputFileContent, mainProject);
        updateMenu();	//Return back to previous menu.

    }

    public static void projectFinalize() throws IOException {
        //Ask the user, which project do they wish to update.
        getPrologueSelectProject();
        List<String> inputFileContent = projectReader.getFileContent();
        List<String> mainProject = projectReader.getProjectRecord();
        System.out.println("Do you wish to mark this project as FINISHED?:");
        String finished = sc.nextLine();

        mainProject.set(20, finished);
        System.out.println(mainProject);
        updateProjectData(inputFileContent, mainProject);
        updateMenu();	//Return back to previous menu.
    }
}
