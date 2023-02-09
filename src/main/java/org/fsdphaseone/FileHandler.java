package org.fsdphaseone;
import java.io.File;
import java.util.Arrays;

public class FileHandler {

    public File[] files(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        return  listOfFiles;
//        System.out.println("===============Files list, not sorted");
//        for (int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isFile()) {
//                System.out.println(i+"." + listOfFiles[i].getName());
//            } else if (listOfFiles[i].isDirectory()) {
//                System.out.println("Directory " + listOfFiles[i].getName());
//            }
//        }
    }
}
