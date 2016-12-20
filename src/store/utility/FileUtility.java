package store.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.PrintWriter;

public class FileUtility {
	public static File getUploadsDirectory() {
		String currentUsersHomeDir = System.getProperty("user.home");
		String uploadsFolder = currentUsersHomeDir + File.separator + "uploads";
		return new File(uploadsFolder);
	}
	
	private static File getUploadsLedger() {
		String currentUsersHomeDir = System.getProperty("user.home");
		String uploadsLedger = currentUsersHomeDir + File.separator + "uploads" +
				File.separator + "upload_file_list.txt";
		return new File(uploadsLedger);
	}
	
	private static String getUniqueName() throws FileNotFoundException, Exception {
		Scanner input = new Scanner(getUploadsLedger());
		int cur_incr = 0;
		int file_incr = 0;
		while(input.hasNext()) {
			cur_incr = input.nextInt();
			file_incr = cur_incr;
			cur_incr += 1;
		}
		
		input.close();
		
		PrintWriter output = new PrintWriter(getUploadsLedger());
		
		output.println(cur_incr);
		
		output.close();
		
		return "upload" + file_incr;
	}
	
	public static String uniqueFileName() {
		String filename = "";
		try {
			filename = getUniqueName();
		} catch(Exception ex) {
			System.out.println(ex);
			filename = Long.toString(new Date().getTime());
		}
		return getUploadsDirectory() + File.separator + filename;
	}
	
	public static void initUploads() {
		File uploadsDir = getUploadsDirectory();
		if (uploadsDir.exists()) {
			if(getUploadsLedger().exists()) {
				// all good to go
				System.out.println("File upload initialized.");
			} else {
				// create ledger
				PrintWriter output = null;
				try {
					output = new PrintWriter(getUploadsLedger());
					output.print(0);
					System.out.println("File upload initialized.");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Error in creating upload_file_list.txt.");
				} finally {
					if(output != null) {
						output.close();
					}
				}
			}
		} else {
			// create uploads dir
			if (uploadsDir.mkdir()) {
				// create ledger
				PrintWriter output = null;
				try {
					output = new PrintWriter(getUploadsLedger());
					output.print(0);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Error in creating upload_file_list.txt.");
				} finally {
					if(output != null) {
						output.close();
					}
				}
			} else {
				System.out.println("Error in creating uploads directory.");
			}
		}
	}
	
	public static void main(String[] args) {
		initUploads(); // initializes file upload
		System.out.println(getUploadsDirectory());
	}
}
