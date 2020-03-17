//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static poised.UpdateProject.projectChosen;

public class ProjectInfo {
    static List<String> mainProject;
    static String projectDetails;

    public static void ViewInfo() throws IOException, ParseException {
        //Display the following screen and allow user to choose on of the following.
        System.out.println("Please choose one of the following:\n1) View a specific project\n2) View all Projects over due\n"
                + "3) View all Projects\n4) Return to START MENU");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        //Based on user choice execute accordingly.
        switch (userChoice) {
            case 1:
                DisplayInfo();
                break;

            case 2:
                OverDue();
                break;

            case 3:
                DisplayAll();
                break;

            case 4:
                MainMenu.startMenu();
                break;
        }
    }

    public static void DisplayInfo() throws IOException, ParseException {
        //Display only the project that the user wishes to view.
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Project Number of the project that you wish to update: ");
        projectChosen = sc.next();
        sc.nextLine();
        FileReader fr = new FileReader("poised.txt");       //Read file.
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null)
            if (line.contains(projectChosen)) {
            line = line.replace("[", " ");      //Replace the bracket.
            line = line.replace("]", " ").strip();  //Replace the bracket and remove white space.
            String[] temp = line.split(",");    //Split info at the ',' and place in temp array.
            mainProject = Arrays.asList(temp);
            System.out.println(ScreenDisplay());
        }
        ViewInfo();
    }

    public static void OverDue() throws IOException, ParseException {
        //Search the file and display all projects that are overdue.
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        FileReader fr = new FileReader("poised.txt");       //Read file.
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {        //Read lines.
            line = line.replace("[", " ");      //Replace the bracket.
            line = line.replace("]", " ").strip();  //Replace the bracket and remove white space.
            String[] temp = line.split(",");    //Split info at the ',' and place in temp array.
            mainProject = Arrays.asList(temp);
            String sDate1= mainProject.get(5);
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            if (date1.before(today)) {
                System.out.println(ScreenDisplay());
            }
        }
        ViewInfo();
    }

    public static void DisplayAll() throws IOException, ParseException {
        //Display all the tasks that are saved in the file.
        FileReader fr = new FileReader("poised.txt");       //Read file.
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {        //Read lines.
            line = line.replace("[", " ");      //Replace the bracket.
            line = line.replace("]", " ").strip();  //Replace the bracket and remove white space.
            String[] temp = line.split(",");    //Split info at the ',' and place in temp array.
            mainProject = Arrays.asList(temp);
            System.out.println(ScreenDisplay());
        }
        ViewInfo();
    }

    public static String ScreenDisplay() throws IOException, ParseException {
        //Display all detail in a professional way.
        projectDetails = "*** Detailed Information about Projects***";
        projectDetails += "\nProject Number:\t\t\t\t\t  " + mainProject.get(0);
        projectDetails += "\nProject Name:\t\t\t\t\t " + mainProject.get(1);
        projectDetails += "\nProject Building Type:\t\t\t " + mainProject.get(2);
        projectDetails += "\nProject Address:\t\t\t\t " + mainProject.get(3);
        projectDetails += "\nProject ERF Number:\t\t\t\t " + mainProject.get(4);
        projectDetails += "\nCustomer's Name:\t\t\t\t " + mainProject.get(16);
        projectDetails += "\nCustomer's Telephone Number:\t " + mainProject.get(17);
        projectDetails += "\nCustomer's Email Address:\t\t " + mainProject.get(18);
        projectDetails += "\nCustomer's Address:\t\t\t\t " + mainProject.get(19);
        projectDetails += "\nArchitect's Name:\t\t\t\t " + mainProject.get(8);
        projectDetails += "\nArchitect's Telephone Number:\t " + mainProject.get(9);
        projectDetails += "\nArchitect's Email Address:\t\t " + mainProject.get(10);
        projectDetails += "\nArchitect's Address:\t\t\t " + mainProject.get(11);
        projectDetails += "\nContractor's Name:\t\t\t\t " + mainProject.get(12);
        projectDetails += "\nContractor's Telephone Number:\t " + mainProject.get(13);
        projectDetails += "\nContractor's Email Address:\t\t " + mainProject.get(14);
        projectDetails += "\nContractor's Address:\t\t\t " + mainProject.get(15);
        projectDetails += "\nProject Total Fee:\t\t\t\t " + mainProject.get(6);
        projectDetails += "\nProject Total Paid to date:\t\t " + mainProject.get(7);
        projectDetails += "\nProject Deadline:\t\t\t\t " + mainProject.get(5);
        projectDetails += "\nProject Finalised:\t\t\t\t " + mainProject.get(20);
        projectDetails += "\n";

        return projectDetails;
    }

}
