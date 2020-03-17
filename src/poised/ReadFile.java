//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

package poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    final List<String> inputFileContent = new ArrayList<>();
    List<String> mainProject = null;// = new ArrayList<>();
    int foundProjectIndex = -1;
    private String fileName;

    ReadFile(String inFile) {
        fileName = inFile;
    }

    //This is the file reading class and method. The file is opened and every line is read and the placed in an array for
    //data manipulation. First we remove the brackets and the spit each word at the ','. At some stage the program uses
    // a user's input as a find in line that needs to be updated.
    public void fileReadContent() throws IOException {
        FileReader fr = new FileReader(fileName);       //Read file.
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {        //Read lines.
            inputFileContent.add(line);
        }
        fr.close();     //Close file reader.
    }

    public void findProjectFieldsOnProject(String findProject) {
        mainProject = new ArrayList<>();
        int lineIndex = 0;
        for (String inputLine : inputFileContent) {
            if (inputLine.contains(findProject)) {
                foundProjectIndex = lineIndex;
                inputLine = inputLine.replace("[", " ");      //Replace the bracket.
                inputLine = inputLine.replace("]", " ").strip();  //Replace the bracket and remove white space.
                String[] temp = inputLine.split(",");    //Split info at the ',' and place in temp array.
                mainProject = Arrays.asList(temp);      //Place temp array into a list.
            }
            lineIndex +=1;
        }
    }

    public int getFoundProjectIndex() {
        return foundProjectIndex;
    }

    public List<String> getFileContent() {
        return inputFileContent;
    }

    public List<String> getProjectRecord() {
        return mainProject;
    }
}
