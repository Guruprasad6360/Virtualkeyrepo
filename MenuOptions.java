package com.lockedme;

public class MenuOptions {
  public static void printWelcomeScreen(String appname, String developername) {
	    System.out.println("Welcome to Locker.com ");  
	    System.out.println(" This protoype is built by me");
	    System.out.println("You can use this application to-");
	    		System.out.println ("Retrive all files from the directory");
	    		System.out.println("Insert a specific file given by user");
	    		System.out.println("Search and delete a file from the directory");
	  //System.out.println(companyDetails);
	  //System.out.println(appFunction);
  }
  public static void displayMenu() {
	  System.out.println("Select any options number from below and press enter");
	  System.out.println("1). Retrive all files inside \"main\"folder\n"); 
	  System.out.println("2).Display menu for file operations"); 
	  System.out.println("3).Exit program\n");
	  //System.out.println(menu);
  }
  public static void displayFileMenuOptions() {
	  System.out.println(" select any option number from below and press enter");
			  System.out.println("1). ADD a file to \"main\folder\n"); 
			             System.out.println("2. Delete a file \"main\"folder\n");
			             System.out.println("3).Search for a file from \"main\folder\n");  
			             System.out.println("4). Show Previous Menu\n");
			             System.out.println("5).Exit Program");
	  //System.out.println(filemenu);
  }
}
