
//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static poised.UpdateProject.pro;


public class ReadFile {
    //Static variable for program use.
    static List<String> inputFileContent = new ArrayList<>();
    static int foundLineIndex = -1;
    static List<String> mainProject  = new ArrayList<>();
    //This is the file reading class and method. The file is opened and every line is read and the placed in an array for
    //data manipulation. First we remove the brackets and the spit each word at the ','. At some stage the program uses
    // a user's input as a find in line that needs to be updated.
    public static void fileReadContent() throws IOException {
        String fileName = "poised.txt";

        FileReader fr = new FileReader(fileName);       //Read file.
        BufferedReader br = new BufferedReader(fr);
        int lineIndex = 0;

        String line;
        while ((line = br.readLine()) != null) {        //Read lines.
            inputFileContent.add(line);
            if (line.contains(pro)) {
                foundLineIndex = lineIndex;
                line = line.replace("[", " ");      //Replace the bracket.
                line = line.replace("]", " ").strip();  //Replace the bracket and remove white space.
                String[] temp = line.split(",");    //Split info at the ',' and place in temp array.
                mainProject = Arrays.asList(temp);      //Place temp array into a list.
            }
            lineIndex += 1;     //Index each line that is read.
        }
        fr.close();     //Close file reader.
    }
}
