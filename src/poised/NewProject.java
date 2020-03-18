//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class NewProject {
    //Create a new project class and method. The user is asked a set of questions. The data given by the user is then
    //stored to a variable and saved into and array and written to a file.
    public static void Register() throws IOException, ParseException {

        Scanner sc = new Scanner(System.in);

        //The program asks the user a set of questions as seen below.
        String[] mainProject = new String[21];        //Create an array.
        System.out.println("Please enter the Project Number:");
        String project_num = sc.nextLine();
        mainProject[0] = project_num;

        System.out.println("Please enter the Project Name:");
        String project_name = sc.nextLine();
        mainProject[1] = project_name;

        System.out.println("Please enter the Building Type:");
        String build_type = sc.nextLine();
        mainProject[2] = build_type;

        System.out.println("Please enter the Project's Address:");
        String address = sc.nextLine();
        mainProject[3] = address;

        System.out.println("Please enter the Project's ERF Number:");
        String erf_num = sc.nextLine();
        mainProject[4] = erf_num;

        System.out.println("Please enter the due date for this project(dd/mm/yyyy):");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        String due_date = sc.nextLine();
        mainProject[5] = due_date;

        System.out.println("Please enter the total price for this Project:");
        String tot_fee = sc.nextLine();
        mainProject[6] = tot_fee;

        System.out.println("Please enter the deposit amount:");
        String tot_paid = sc.nextLine();
        mainProject[7] = tot_paid;

        System.out.println("Please enter the name of the architect:");
        String arch_name = sc.nextLine();
        mainProject[8] = arch_name;

        System.out.println("Please enter the telephone number of the architect:");
        String arch_tel = sc.nextLine();
        mainProject[9] = arch_tel;

        System.out.println("Please enter the email of the architect:");
        String arch_email = sc.nextLine();
        mainProject[10] = arch_email;

        System.out.println("Please enter the address of the architect:");
        String arch_address = sc.nextLine();
        mainProject[11] = arch_address;

        System.out.println("Please enter the name of the contractor:");
        String cont_name = sc.nextLine();
        mainProject[12] = cont_name;

        System.out.println("Please enter the telephone number of the contractor:");
        String cont_tel = sc.nextLine();
        mainProject[13] = cont_tel;

        System.out.println("Please enter the email of the contractor:");
        String cont_email = sc.nextLine();
        mainProject[14] = cont_email;

        System.out.println("Please enter the address of the contractor:");
        String cont_address = sc.nextLine();
        mainProject[15] = cont_address;

        System.out.println("Please enter the name of the customer:");
        String cust_name = sc.nextLine();
        mainProject[16] = cust_name;

        System.out.println("Please enter the telephone number of the customer:");
        String cust_tel = sc.nextLine();
        mainProject[17] = cust_tel;

        System.out.println("Please enter the email of the customer:");
        String cust_email = sc.nextLine();
        mainProject[18] = cust_email;

        System.out.println("Please enter the address of the customer:");
        String cust_address = sc.nextLine();
        mainProject[19] = cust_address;

        String complete = "NO";
        mainProject[20] = complete;

        try        //Using a try/catch we first see if such a file is there. If not the catch will display an error.
        {
            FileWriter fw = new FileWriter("poised.txt", true);

            fw.write(Arrays.toString(mainProject));
            fw.write("\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainMenu.startMenu();
    }
}
