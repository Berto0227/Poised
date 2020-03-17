//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    //Display welcome screen and ask user to start by selecting which one of the following option they would like to go to.
    //based on the users choice the program will take them to that specific class and contintue.
    public static void startMenu() throws IOException, ParseException {

        System.out.println("Welcome to Poised Project Management.");
        System.out.println("Please choose one of the following:\n1) New Project\n2) Update Project\n3) Project Information\n4) Exit \n");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        if (userChoice == 1) {

            NewProject.Register();        //This will ask you to register a new project.

        } else if (userChoice == 2) {

            UpdateProject.updateMenu();        //This will allow you to to update any of the information on an existing project.

        } else if (userChoice == 3) {

            ProjectInfo.ViewInfo();                    //This will allow the user to display a project or display all projects.

        } else if (userChoice == 4) {

            System.exit(0);            //Exit the program
        } else {

            System.out.println("You have not selected the correct option.\n");
            //If user has made an incorrect selection the program will prompt that and restart the program.
            startMenu();

        }

    }

    //Main Method. Start of the program.
    public static void main(String[] args) throws IOException, ParseException {

        MainMenu.startMenu();

    }
}
