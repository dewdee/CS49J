
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
		System.out.println("4. Print tree.");
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
						if(!Character.isDigit(tokens[0].charAt(0)))
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
				case 4:
					tree.printRankOrder();
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
/*
1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 1
Enter ID and name to insert(ID Name): 3 Sara
3 Sara has been inserted into the tree.
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 1
Enter ID and name to insert(ID Name): 6 Jill
6 Jill has been inserted into the tree.
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: a
java.util.InputMismatchException
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 1
Enter ID and name to insert(ID Name): 1 Bob
1 Bob has been inserted into the tree.
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 4
Rank Order:
		2. 6 Jill
	1. 3 Sara
		2. 1 Bob

Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 3
Enter ID to search: 4
ID 4 not found, closest employee is: 3 Sara
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 2
Enter ID to delete: 4
4 does not exist in the tree, closest employee is: 3 Sara
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 2
Enter ID to delete: 3
3 Sara has been deleted.
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 4
Rank Order:
		2. 6 Jill
	1. 1 Bob

Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 1
Enter ID and name to insert(ID Name): 8 Michael
8 Michael has been inserted into the tree.
Do you wish to continue (Type y or n): y

1. Add new Employee.
2. Delete employee.
3. Search.
4. Print tree.
Select an option: 4
Rank Order:
			3. 8 Michael
		2. 6 Jill
	1. 1 Bob

Do you wish to continue (Type y or n): 
*/