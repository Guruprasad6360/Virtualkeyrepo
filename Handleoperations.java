package com.lockedme;

import java.util.List;
import java.util.Scanner;

public class Handleoperations {
	public static void handlewelcomeScreenInput() {
	 boolean running= true;
	 Scanner sc= new Scanner(System.in);
	 do {
		 try {
			 MenuOptions.displayMenu();
			 int input=sc.nextInt();
			 switch(input) {
			 case 1: FileOperations.displayAllFiles("main");
                     break;
			 case 2: Handleoperations .handleFileOptions();    
			      break;
			 case 3: System.out.println("Program Executed Successfully");
			  running = false;
			  sc.close();
			  System.exit(0);
			  break;
			  default : System.out.println("Please select a valid option from above");
			 }
		 
	 }catch(Exception e) {System.out.println(e.getClass().getName());}
 } while(running== true);
}

	private static void handleFileOptions() {
		// TODO Auto-generated method stub
		boolean running=true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayFileMenuOptions();
                FileOperations.createMainFolderIfNotPresent("main");
                int input = sc.nextInt();
                switch(input) {
                        // file to be added into main directory.
                case 1: System.out.println("Enter the name of the file to be added to the \"main\" folder");
                         String fileToAdd = sc.next();
                         FileOperations.createFile(fileToAdd, sc);
                         break;
                
                        // file to be deleted switchcase
                case 2: System.out.println("Enter the name of the file to be Deleted to the \"main\" folder");
                        String fileToDelete = sc.next();
                        FileOperations.createMainFolderIfNotPresent("main");
                        List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "main");
                        String delectionPromt = "select index of which file to delete" + "(eNTER 0 TO DELETE all the elements)";
                        System.out.println(delectionPromt);
                        int idx = sc.nextInt();
                        if(idx!=0) {
                        	FileOperations.deleteFileRecursively(fileToDelete.formatted(idx-1));
                        }else {
                        	for(String path : filesToDelete) {
                        		FileOperations.deleteFileRecursively(path);
                        	}
                        }
                  break;
                        // files to be searched.
                case 3: System.out.println("Enter the name of the file to be searched from \"main\" folder");
                         String filename = sc.next();
                         
                         FileOperations.createMainFolderIfNotPresent("main");
                         FileOperations.displayFileLocations(filename, "main");
                         break;
                case 4: return;
                case 5: System.out.println("Program exited Successfully");
                        running=false;
                        sc.close();
                        System.exit(0);
               default : System.out.println("please select a valid options from above");
			}
		}catch(Exception e){System.out.println(e.getClass().getName());
		 handleFileOptions();}
	}while(running=false);

}
}