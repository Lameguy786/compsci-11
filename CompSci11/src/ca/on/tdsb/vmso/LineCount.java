// TO DO
// how many lines of code are there in total for this project?
// what is the maximum number of lines of code that you've had in a class
// assignment?

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.on.tdsb.vmso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
// https://stackoverflow.com/questions/10661636/how-to-count-lines-in-a-netbeans-project
public class LineCount {
    
    public void countLines() throws FileNotFoundException {
        
        String folderPath = "C:\\Users\\Owner\\Documents\\NetBeansProjects\\CompSci11\\src\\ca\\on\\tdsb\\vmso";
        
        System.out.println("root folder: " + folderPath);

        long totalLineCount = 0;
        final List<File> folderList = new LinkedList<>();
        folderList.add(new File(folderPath));
        while (!folderList.isEmpty()) {
            final File folder = folderList.remove(0);
            if (folder.isDirectory() && folder.exists()) {
                System.out.println("Scanning " + folder.getName());
                final File[] fileList = folder.listFiles();
                for (final File file : fileList) {
                    if (file.isDirectory()) {
                        folderList.add(file);
                    } else if (file.getName().endsWith(".java")
                            || file.getName().endsWith(".sql")) {
                        long lineCount = 0;
                        final Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            scanner.nextLine();
                            lineCount++;
                        }
                        totalLineCount += lineCount;
                        final String lineCountString;
                        if (lineCount > 99999) {
                            lineCountString = "" + lineCount;
                        } else {
                            final String temp = ("     " + lineCount);
                            lineCountString = temp.substring(temp.length() - 5);
                        }
                        System.out.println(lineCountString + " lines in " + file.getName());
                    }
                }
            }
        }
        System.out.println("Scan Complete: " + totalLineCount + " lines total");
    }
    
    public static void main(String[] args) {
        try {
            new LineCount().countLines();
        }
        catch(Exception e)
        {
            
        }
    }
}
