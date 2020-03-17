package com.codingcrafters.poised;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private String fileName;
    
    WriteFile(String outFile) {
        fileName = outFile;
    }
    //File writer class and method. Data that has been edited and has been replaced will now be written back to the file.
    public void writeStringListFile(List<String> content) {
        //String fileName = "poised.txt";
        try {       //Using try/catch we check if the file is available.
            FileWriter fw = new FileWriter(fileName, false);   //Open file for writing.
            BufferedWriter fileWriter = new BufferedWriter(fw);
            for (String item : content) {
                fileWriter.write(item + "\n"); // \n is newline character is needed for separating the text lines
            }
            fileWriter.close();     //Close file writer.
            fw.close();
        } catch (IOException ie) {    //Catch error if need be.
            ie.printStackTrace();
        }
    }
}
