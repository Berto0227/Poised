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
    public void fileReadContent() {
        foundProjectIndex = -1;
        inputFileContent.clear();
        try {
            FileReader fr = new FileReader(fileName);       //Read file.
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            line = line.strip();
            while ((line = br.readLine()) != null) {        //Read lines.
                inputFileContent.add(line);
            }
            fr.close();     //Close file reader.

        } catch (IOException ie) {    //Catch error if need be.
            ie.printStackTrace();

        }
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
            lineIndex += 1;
        }
    }

    private String[] sanitiseSplitRecord(String projectFields) {
        String inputLine = projectFields;
        inputLine = inputLine.replace("[", " ");      //Replace the bracket.
        inputLine = inputLine.replace("]", " ").strip();  //Replace the bracket and remove white space.
        return inputLine.split(",");
    }

    public int getFoundProjectIndex() {
        return foundProjectIndex;
    }

    public void resetMatches() {
        foundProjectIndex = -1;
        mainProject = null;
    }

    public int matchedRecordsCount() {
        if (foundProjectIndex >= 0)
            return 1;
        else
            return inputFileContent.size();
    }

    public List<String> getFileContent() {
        return inputFileContent;
    }

    public List<String> getProjectRecord() {
        return mainProject;
    }

    public List<String> getProjectRecordOnIndex(int index) {
        if (mainProject != null)
            return mainProject;
        else {
            String inputRecord = inputFileContent.get(index);
            String[] inputRecordFields = sanitiseSplitRecord(inputRecord);
            return Arrays.asList(inputRecordFields);
        }
    }
}
