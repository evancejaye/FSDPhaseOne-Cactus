package org.fsdphaseone;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileHandler {

    static  void filesInDir(String dir){
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        int k = 1;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("\t"+ listOfFiles[i].getName());
                k++;
            }
        }
    }

    static void  createFile(String dir, String filename){
        try {
            File myObj = new File(dir+"/"+filename);
            if (myObj.createNewFile()) {
                System.out.println("\tFile created: " + myObj.getName());
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
            System.out.println("\tDeleted the file: " + myObj.getName());
        } else {
            System.out.println("\tFailed to delete the file.");
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
                if(temp.indexOf(filename) >= 0){
                    //the file is found
                    System.out.println("\t"+ listOfFiles[i].getName());
                    found = true;
                }

                k++;
            }
        }
        //file not found
        if (!found){
            System.out.println("\tFile not found");
        }

    }

    static void close(){
        System.exit(0);
    }


}
