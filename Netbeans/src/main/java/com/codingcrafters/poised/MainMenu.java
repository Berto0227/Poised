package com.codingcrafters.poised;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    //Display welcome screen and ask user to start by selecting which one of the following option they would like to go to.
    //based on the users choice the program will take them to that specific class and contintue.
    static String projectFile = "poised.txt";

    public static void startMenu() throws IOException {
        System.out.println("Welcome to Poised Project Management.");
        System.out.println("Please choose one of the following:\n1) New Project\n2) Update Project\n3) Project Information\n4) Exit \n");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        switch (userChoice) {
            //This will ask you to register a new project.
            case 1:
                NewProject.Register(projectFile);
                break;
            //This will allow you to to update any of the information on an existing project.
            case 2:
                UpdateProject.updateMenu();
                break;
            //This will allow the user to display a project or display all projects.
            case 3:
                ProjectInfo.ViewInfo();
                break;
            case 4:
                System.exit(0);			//Exit the program
            default:
                System.out.println("You have not selected the correct option.\n");
                //If user has made an incorrect selection the program will prompt that and restart the program.
                startMenu();
                break;
        }

    }    

}
