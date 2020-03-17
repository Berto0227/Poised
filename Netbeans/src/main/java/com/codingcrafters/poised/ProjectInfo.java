package com.codingcrafters.poised;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProjectInfo {

    public static void ViewInfo() throws IOException {

        System.out.println("Please choose one of the following:\n1) View a specific project\n2) View all Projects\n"
                + "3) Return to START MENU\n");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        switch (userChoice) {
            case 1:
                DisplayInfo();
                break;

            case 2:
                DisplayAll();
                break;

            case 3:
                MainMenu.startMenu();
                break;
        }
    }

    public static <projectDetails> String DisplayOutput(String project) throws IOException {
        String projectFile = "poised.txt";
        ReadFile projectReader = new ReadFile(projectFile);
        projectReader.fileReadContent();
        if ((project != null) && (project.length() >= 2)) {
            projectReader.findProjectFieldsOnProject(project);
        } else {

        }
        String projectDetails = "";
        int recordCount = projectReader.matchedRecordsCount();
        for (int ix = 0; ix < recordCount; ix++) {
            List<String> mainProject = projectReader.getProjectRecordOnIndex(ix);            
            if ( (mainProject != null) && (mainProject.size() >= 21) ) {
                projectDetails += "Project Number:\t\t\t " + mainProject.get(0);
                projectDetails += "\nProject Name:\t\t\t " + mainProject.get(1);
                projectDetails += "\nProject Building Type:\t\t " + mainProject.get(2);
                projectDetails += "\nProject Address:\t\t " + mainProject.get(3);
                projectDetails += "\nProject ERF Number:\t\t " + mainProject.get(4);
                projectDetails += "\nCustomer's Name:\t\t " + mainProject.get(16);
                projectDetails += "\nCustomer's Telephone Number:\t\t " + mainProject.get(17);
                projectDetails += "\nCustomer's Email Address:\t\t " + mainProject.get(18);
                projectDetails += "\nCustomer's Address:\t\t " + mainProject.get(19);
                projectDetails += "\nArchitect's Name:\t\t " + mainProject.get(8);
                projectDetails += "\nArchitect's Telephone Number:\t\t " + mainProject.get(9);
                projectDetails += "\nArchitect's Email Address:\t\t " + mainProject.get(10);
                projectDetails += "\nArchitect's Address:\t\t " + mainProject.get(11);
                projectDetails += "\nContractor's Name:\t\t " + mainProject.get(12);
                projectDetails += "\nContractor's Telephone Number:\t\t " + mainProject.get(13);
                projectDetails += "\nContractor's Email Address:\t\t " + mainProject.get(14);
                projectDetails += "\nContractor's Address:\t\t " + mainProject.get(15);
                projectDetails += "\nProject Total Fee:\t\t " + mainProject.get(6);
                projectDetails += "\nProject Total Paid to date:\t " + mainProject.get(7);
                projectDetails += "\nProject Deadline:\t\t " + mainProject.get(5);
                projectDetails += "\nProject Finalised:\t\t " + mainProject.get(20) + "\n\n";
            }
        }
        projectDetails += "\n";

        return projectDetails;
    }

    public static void DisplayInfo() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Project Number of the project that you wish to view: ");
        String projectChosen = sc.next();
        sc.nextLine();
        System.out.println(DisplayOutput(projectChosen));
        ViewInfo();
    }

    public static void DisplayAll() throws IOException {
        System.out.println(DisplayOutput(""));
        ViewInfo();
    }
}
