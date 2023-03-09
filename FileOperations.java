package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileOperations {
 public static void createMainFolderIfNotPresent(String folderName) {
	 File file = new File(folderName);
	// if file doesn't exist, create the main folder 
	 if(!file.exists()) {
		 file.mkdir();
	 }
 }
  public static void displayAllFiles(String path) {
	  // ALL the files and folders inside main folder --- display() options to end user
	  FileOperations.createMainFolderIfNotPresent("main");
	  System.out.println("Display all files with Directory structure in ascending order");
	  // listFilesInDirectory displays folder structure
	  List<String> filesListNames = FileOperations.listFilesInDirectory(path,0,new ArrayList<String>());
	  System.out.println("Displaying all files in ascending order");
	  Collections.sort(filesListNames);
	  filesListNames.stream().forEach(System.out::println);
  }
   public static List<String> listFilesInDirectory(String path, int indentationCount, List<String> fileListNames) {
	File dir =new File(path);
	File[] files = dir.listFiles();
	List<File> filesList = Arrays.asList(files);
	Collections.sort(filesList);
	if(files !=null && files.length>0) {
		for(File file : filesList) {
			System.out.println("".repeat(indentationCount*2));
			if(file.isDirectory()) {
				System.out.println("--"+ file.getName());
				fileListNames.add(file.getName());
				// Recusiverly indent or spcae to display files;
				listFilesInDirectory(file.getAbsolutePath() , indentationCount+1, fileListNames);
			}else {
				System.out.println("!----"+ file.getName());
			}
		}
	}else {
		System.out.println(" ".repeat(indentationCount * 2));
		System.out.println(" Empty Directory!!");
	}
	System.out.println();
	return fileListNames;
}
    public static void createFile(String fileToAdd, Scanner sc) {
    	FileOperations.createMainFolderIfNotPresent("main");
    	Path pathToFile = Paths.get("./main/" + fileToAdd);
    	try {
    		Files.createDirectories(pathToFile.getParent());
    		Files.createFile(pathToFile);
    		System.out.println(fileToAdd + " created successfully");
    		String choice = sc.next().toLowerCase();
    		sc.nextLine();
    		if(choice.equals("y")){
    		 System.out.println("Input content and press Enter ");
    		 String content = sc.nextLine();
    		 Files.write(pathToFile, content.getBytes());
    		 System.out.println("content written to file"+ fileToAdd);
    		 System.out.println("content can be read using vscode or any code editor");
    		}
    	}catch(IOException e) {
    		 System.out.println("Failed to create file" + fileToAdd);
    		 System.out.println(e.getClass().getName());
    	}
    }public static List<String> displayFileLocations(String fileName, String path){
		List<String> fileListNames = new ArrayList<>();
		FileOperations.searchFileRecursively(path,fileName, fileListNames);
    	if(fileListNames.isEmpty()) {
    		System.out.println("Couldn't find any file with given file name");
    	}else {
    		System.out.println("found file at below location");
    		List<String> files = IntStream.range(0, fileListNames.size()).mapToObj(index -> (index + 1)+ " : " + fileListNames.get(index)).collect(Collectors.toList());
    		files.forEach(System.out::println);
    	}
    	return fileListNames;
    	
    }
	private static void searchFileRecursively(String path, String fileName, List<String> fileListNames) {
		// TODO Auto-generated method stub
		File dir= new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		
		if(files!=null && files.length>0) {
			for(File file : filesList) {
				if(file.getName().startsWith(fileName)) {
					fileListNames.add(file.getAbsolutePath());
				}
				// Need to search in directory separatly to ensure all files of required 
				// filename are seprated. 
				if(file.isDirectory()) {
					searchFileRecursively(file.getAbsolutePath(), fileName, fileListNames);
				}
			}
		}
	}public static void deleteFileRecursively(String i) {
		File currFile = new File(i);
		File[] files = currFile.listFiles();
		if(files!=null && files.length>0) {
			for(File file : files) {
				String filename = file.getName() + "at" + file.getParent();
				if(file.isDirectory()) {
				deleteFileRecursively(file.getAbsolutePath());
				}if(file.delete()) {
					System.out.println(filename + " deleted successfully");
				}else {
					System.out.println("Failed to delete"+ filename);
				}
			}
		}String currFileName = currFile.getName() + "at" + currFile.getParent();
		if(currFile.delete()) {
			System.out.println(currFileName + "Deleted successfully");
		}else {
			System.out.println("failed to delete"+ currFileName);
		}
	}
}
