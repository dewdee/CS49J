
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment36 {
	public static void main(String[] args){
		BST tree = new BST();

		menuOptions(tree);
	}
	public static void printMenu(){
		System.out.println("1. Add new Employee.");
		System.out.println("2. Delete employee.");
		System.out.println("3. Search.");
	}
	public static void menuOptions(BST tree){
		int menuChoice, ID;
		char contChoice = 'y';
		Employee person;
		Scanner in = new Scanner(System.in);

		do{
			printMenu();
			try{
				System.out.print("Select an option: ");
				menuChoice = in.nextInt();
				//Manager for all user input choices
				in.nextLine(); //flushes out nextline
				switch(menuChoice){
				case 1:
					try{
						System.out.print("Enter ID and name to insert(ID Name): ");

						String line = in.nextLine();

						String[] tokens = line.split("\\s+");
						if(Character.isDigit(tokens[0].charAt(0)))
							throw new InputMismatchException();
						person = new Employee(Integer.parseInt(tokens[0]), tokens[1]);
						tree.insert(person);
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 2:
					try{
						System.out.print("Enter ID to delete: ");
						ID = in.nextInt();
						tree.delete(ID);
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 3:
					try{
						System.out.print("Enter ID to search: ");
						ID = in.nextInt();
						person = tree.search(ID);
						if(person == null){
							System.out.print("ID " + ID + " not found, closest employee is: ");
							person = tree.getClosestEmployee(ID);
						}
						System.out.println(person.getData());
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				default:
					return;
				}
			}
			catch(Exception e){
				System.out.println(e);
				in.nextLine();
			}
			try{
				System.out.print("Do you wish to continue (Type y or n): ");
				contChoice = in.next(".").charAt(0);
				in.nextLine(); //flushes out nextline
				if(contChoice != 'y' && contChoice != 'n')
					throw new InputMismatchException();
			}
			catch(Exception e){
				System.out.println(e);
			}
			System.out.println("");
		}while(contChoice != 'n');

		in.close();
	}
}
