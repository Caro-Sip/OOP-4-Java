package exercise4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyNote {
    File note;
    public int lines;

    MyNote(File note){
        this.note = note;
        if (!note.exists()) {
            try {
                note.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        countLines();
    }

    private void countLines(){
        try(BufferedReader reader = new BufferedReader(new FileReader(note))){
            lines = 0;
            while(reader.readLine() != null){
                lines++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    void printNote(){
        try(BufferedReader reader = new BufferedReader(new FileReader(note))){
            String line;
            System.out.println("*****************************");
            int linenumber=0;
            while((line = reader.readLine()) != null){
                System.out.println((linenumber++) +"| " + line);
            }
            System.out.println("*****************************");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    void editMenu(){
        System.out.println("1. Append new line");
        System.out.println("2. Update at line");
        System.out.println("3. Delete line");
        System.out.println("4. Exit Edit Menu");
    }

    void addNewLine(String newLine){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(note, true))){
            writer.append(newLine);
            writer.newLine();
            lines++;
            System.out.println("Line #" + lines + " is appended to the note.\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    void deleteLine(int lineNumber){
        try(BufferedReader reader = new BufferedReader(new FileReader(note))){
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 0;
            while((line = reader.readLine()) != null){
                if(currentLine != lineNumber){
                    content.append(line).append("\n");
                }
                currentLine++;
            }
            
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(note))){
                writer.write(content.toString());
                lines--;
                System.out.println("Line #" + lineNumber + " is deleted.\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    void updateLine(int lineNumber, String newContent){
        try(BufferedReader reader = new BufferedReader(new FileReader(note))){
            StringBuilder content = new StringBuilder();
            String line;
            int currentLine = 0;
            while((line = reader.readLine()) != null){
                if(currentLine == lineNumber){
                    content.append(newContent);
                }
                else{
                    content.append(line);
                }
                content.append("\n");
                currentLine++;
            }
            
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(note))){
                writer.write(content.toString());
                System.out.println("Line #" + lineNumber + " is updated.\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
