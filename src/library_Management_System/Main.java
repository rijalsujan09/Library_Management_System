package library_Management_System;

import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {

		String[] Heading = { "\n"
				+ "\t\t\t\t\t Welcome", " to", " Library", " Management", " System" };
		
		for(int i=0; i<Heading.length; i++) {
			System.out.print(Heading[i]);
			Thread.sleep(100);
		}
		System.out.println();

		Users.usertype(scan);
		System.out.println("done project");

	}

}
