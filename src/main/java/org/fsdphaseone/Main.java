package org.fsdphaseone;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declare variables
        final String dir = System.getProperty("user.dir");

        Scanner in = new Scanner(System.in);


        //menu contexts
        //1.Welcome page
        System.out.println("------------------------------------------------------------");
        System.out.println("("+dir+")");
        System.out.println("Select operation");
        System.out.println("\t1.List files\n\t2.Manage files\n\t3.Close program");
        System.out.println("------------------------------------------------------------");
        int option = in.nextInt();
        switch (option){
            case 1:
                System.out.println("List of files in current path:"+dir);
                filesInDir(dir);
                break;
            case 2:
                System.out.println("Manage Files:\n\t1.Create file\n\t2.Delete file\n\t3.Search file");
                option = in.nextInt();
                String file = "";
                switch (option){
                    case 1:
                        System.out.println("Enter file name:");
                        file = getInput();
                        System.out.println("Created:"+file);
                        createFile(dir, file);
                        break;

                    case 2:
                        System.out.println("Enter file name:");
                        file = getInput();
                        System.out.println("Deleted:"+file);
                        deleteFile(dir, file);
                        break;

                    case 3:
                        System.out.println("Enter file name:");
                        file = getInput();
                        System.out.println("Search:"+file);
                        searchFile(dir, file);
                        break;

                }
                break;
            case 3:
                System.out.println("Application closed");
                close();
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }








    }

    static String getInput(){
        Scanner userInputObj = new Scanner(System.in);
        return userInputObj.nextLine().toString();
    }



    static  void filesInDir(String dir){
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        int k = 1;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("\t"+k+"." + listOfFiles[i].getName());
                k++;
            }
        }
    }

    static void  createFile(String dir, String filename){
        try {
            File myObj = new File(dir+"/"+filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("\tFile already exists.");
            }
        } catch (IOException e) {
            System.out.println("\tAn error occurred.");
            e.printStackTrace();
        }
    }

    static  void deleteFile(String dir, String filename){
        //delete file
        File myObj = new File(dir+"/"+filename);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    static  void searchFile(String dir, String filename){
        //search for a file
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        int k = 1;
        boolean found = false;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String temp = listOfFiles[i].getName();
                temp = temp.toLowerCase();
                filename = filename.toLowerCase();
                if(temp.indexOf(filename) > 0){
                    //the file is found
                    System.out.println("\t"+k+"." + listOfFiles[i].getName());
                    found = true;
                }

                k++;
            }
        }
        //file not found
        if (!found){
            System.out.println("File not found");
        }

    }

    static void close(){
        System.exit(0);
    }


}