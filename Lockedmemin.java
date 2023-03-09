package com.lockedme;

public class Lockedmemin {
  public static void main(String[] args) {
	// Main function to invoke methods from different classes.
	FileOperations.createMainFolderIfNotPresent("main");
	MenuOptions.printWelcomeScreen("LockedMe", "Guruprasad");
	Handleoperations.handlewelcomeScreenInput();
}
}
