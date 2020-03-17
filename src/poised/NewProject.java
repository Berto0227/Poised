
//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NewProject {
	//Create a new project class and method. The user is asked a set of questions. The data given by the user is then
	//stored to a variable and saved into and array and written to a file.
	public static void Register() throws IOException {

			String[] mainProject = new String[21];		//Create an array.
			
			Scanner sc = new Scanner(System.in);
			int count = 0;
			//The program asks the user a set of questions as seen below.
			while(count < 21)
			{
				System.out.println("Please enter the Project Number:");
				String project_num = sc.nextLine();
				mainProject[0] = project_num;
				sc.nextLine();
				count++;
			
				System.out.println("Please enter the Project Name:");
				String project_name = sc.nextLine();
				mainProject[1] = project_name;
				sc.nextLine();
				count++;
			
				System.out.println("Please enter the Building Type:");
				String build_type = sc.nextLine();
				mainProject[2] = build_type;
				sc.nextLine();
				count++;
			
				System.out.println("Please enter the Project's Address:");
				String address = sc.nextLine();
				mainProject[3] = address;
				sc.nextLine();
				count++;

				System.out.println("Please enter the Project's ERF Number:");
				String erf_num = sc.nextLine();
				mainProject[4] = erf_num;
				sc.nextLine();
				count++;

				System.out.println("Please enter the due date for this project:");
				String due_date = sc.nextLine();
				mainProject[5] = due_date;
				sc.nextLine();
				count++;

				System.out.println("Please enter the total price for this Project:");
				String tot_fee = sc.nextLine();
				mainProject[6] = tot_fee;
				sc.nextLine();
				count++;

				System.out.println("Please enter the deposit amount:");
				String tot_paid = sc.nextLine();
				mainProject[7] = tot_paid;
				sc.nextLine();
				count++;

				System.out.println("Please enter the name of the architect:");
				String arch_name = sc.nextLine();
				mainProject[8] = arch_name;
				sc.nextLine();
				count++;

				System.out.println("Please enter the telephone number of the architect:");
				String arch_tel = sc.nextLine();
				mainProject[9] = arch_tel;
				sc.nextLine();
				count++;

				System.out.println("Please enter the email of the architect:");
				String arch_email = sc.nextLine();
				mainProject[10] = arch_email;
				sc.nextLine();
				count++;

				System.out.println("Please enter the address of the architect:");
				String arch_address = sc.nextLine();
				mainProject[11] = arch_address;
				sc.nextLine();
				count++;

				System.out.println("Please enter the name of the contractor:");
				String cont_name = sc.nextLine();
				mainProject[12] = cont_name;
				sc.nextLine();
				count++;

				System.out.println("Please enter the telephone number of the contractor:");
				String cont_tel = sc.nextLine();
				mainProject[13] = cont_tel;
				sc.nextLine();
				count++;

				System.out.println("Please enter the email of the contractor:");
				String cont_email = sc.nextLine();
				mainProject[14] = cont_email;
				sc.nextLine();
				count++;

				System.out.println("Please enter the address of the contractor:");
				String cont_address = sc.nextLine();
				mainProject[15] = cont_address;
				sc.nextLine();
				count++;

				System.out.println("Please enter the name of the customer:");
				String cust_name = sc.nextLine();
				mainProject[16] = cust_name;
				sc.nextLine();
				count++;

				System.out.println("Please enter the telephone number of the customer:");
				String cust_tel = sc.nextLine();
				mainProject[17] = cust_tel;
				sc.nextLine();
				count++;

				System.out.println("Please enter the email of the customer:");
				String cust_email = sc.nextLine();
				mainProject[18] = cust_email;
				sc.nextLine();
				count++;

				System.out.println("Please enter the address of the customer:");
				String cust_address = sc.nextLine();
				mainProject[19] = cust_address;
				sc.nextLine();
				count++;

				String complete = "NO";
				mainProject[20] = complete;
				count++;
			}
			try		//Using a try/catch we first see if such a file is there. If not the catch will display an error.
			{
				FileWriter fw = new FileWriter("poised.txt", true); 
			    
				fw.write(Arrays.toString(mainProject));
				fw.write("\n");
				fw.close();
			}
			catch (Exception e)
			{
			    e.printStackTrace();
			    System.out.println("No such file exists.");
			}
			sc.close();	//Close input scanner.
			MainMenu.startMenu();
	}
}
