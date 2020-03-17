package poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProjectInfo {
    static List<String> mainProject;
    static String projectDetails;

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

    public static void DisplayInfo() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Project Number of the project that you wish to update: ");
        UpdateProject.projectChosen = sc.next();
        sc.nextLine();
        UpdateProject.projectReader.fileReadContent();
        List<String> inputFileContent = UpdateProject.projectReader.getFileContent();
        UpdateProject.projectReader.findProjectFieldsOnProject(UpdateProject.projectChosen);
        mainProject = UpdateProject.projectReader.getProjectRecord();
        System.out.println(projectDetails);
    }
    public static void DisplayAll() throws IOException {

        FileReader fr = new FileReader("poised.txt");       //Read file.
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {        //Read lines.
            line = line.replace("[", " ");      //Replace the bracket.
            line = line.replace("]", " ").strip();  //Replace the bracket and remove white space.
            String[] temp = line.split(",");    //Split info at the ',' and place in temp array.
            mainProject = Arrays.asList(temp);
        }
        fr.close();

        System.out.println(ScreenDisplay());
    }

    public static String ScreenDisplay() {

        projectDetails = "Project Number:\t\t\t\t\t   " + mainProject.get(0);
        projectDetails += "\nProject Name:\t\t\t\t\t " + mainProject.get(1);
        projectDetails += "\nProject Building Type:\t\t\t " + mainProject.get(2);
        projectDetails += "\nProject Address:\t\t\t\t " + mainProject.get(3);
        projectDetails += "\nProject ERF Number:\t\t\t\t " + mainProject.get(4);
        projectDetails += "\nCustomer's Name:\t\t\t\t " + mainProject.get(16);
        projectDetails += "\nCustomer's Telephone Number:\t " + mainProject.get(17);
        projectDetails += "\nCustomer's Email Address:\t\t " + mainProject.get(18);
        projectDetails += "\nCustomer's Address:\t\t\t\t " + mainProject.get(19);
        projectDetails += "\nArchitect's Name:\t\t\t\t  " + mainProject.get(8);
        projectDetails += "\nArchitect's Telephone Number:\t  " + mainProject.get(9);
        projectDetails += "\nArchitect's Email Address:\t\t  " + mainProject.get(10);
        projectDetails += "\nArchitect's Address:\t\t\t  " + mainProject.get(11);
        projectDetails += "\nContractor's Name:\t\t\t\t " + mainProject.get(12);
        projectDetails += "\nContractor's Telephone Number:\t " + mainProject.get(13);
        projectDetails += "\nContractor's Email Address:\t\t " + mainProject.get(14);
        projectDetails += "\nContractor's Address:\t\t\t " + mainProject.get(15);
        projectDetails += "\nProject Total Fee:\t\t\t\t " + mainProject.get(6);
        projectDetails += "\nProject Total Paid to date:\t\t " + mainProject.get(7);
        projectDetails += "\nProject Deadline:\t\t\t\t " + mainProject.get(5);
        projectDetails += "\nProject Finalised:\t\t\t\t " + mainProject.get(20);

        return projectDetails;
    }
}
