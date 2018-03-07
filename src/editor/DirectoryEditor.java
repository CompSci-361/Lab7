package editor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import server.MainDictionary;
import transport.DirectoryTransport;
import transport.Employee;

public class DirectoryEditor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		DirectoryTransport transport = new DirectoryTransport();
		DirectoryProxy proxy = new DirectoryProxy(transport);
		MainDictionary dictionary = new MainDirectory(transport);
		//Read in commands and keep sending new Employees to the proxy
		boolean adding = false;
		System.out.println("Would you like to read from a file [y,n]: ");

		String decision = stdin.nextLine().trim();
		if (decision.equals("y")) {
			// The name of the file to open.
			String fileName;
			System.out.println("Enter the name of the file to open: ");
			fileName = stdin.nextLine().trim();

			// This will reference one line at a time
			String line = null;

			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = new FileReader(fileName);
				
				// Always wrap FileReader in BufferedReader.
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while ((line = bufferedReader.readLine()) != null) {
					adding = processString(line, adding);
				}
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			} catch (Exception ex) {
				System.err.println(ex.toString());
			}
		} else {
			while(true){
				System.out.println("Enter a command: ");
				String line = stdin.nextLine();
				adding = processString(line, adding);
			}
		}
	
	}
	public static boolean processString(String cmd, boolean adding) {
		String delims = "\\s+";
		String[] tokens = cmd.split(delims);
		if(tokens.length>2&&adding==false) {
			System.out.println("Select add first before entering data");
			return adding;
		}
		if(tokens.length>2&&adding == true) {
			Employee person = new Employee(tokens[0],tokens[1],tokens[2],tokens[3]);
			addPerson(person);
			return adding;
		}
		switch(tokens[0]) {
			case "ADD":{
				return true;
			}
			case "END": {
				return false;
			}
			case "CLR": {
				clear();
				return false;
			}
			case "PRINT": {
				print();
				return adding;
			}
		}
		return adding;
	}
	public static void addPerson(Employee send) {
		proxy.addPerson(send);
	}
	public static void clear() {
		proxy.clear();
	}
	public static void print() {
		proxy.print();
	}
	
}
