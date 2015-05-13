import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class LLNode{
	private LLNode next;
	private int data;

	public LLNode(int data){
		next = null;
		this.data = data;
	}
	public LLNode(LLNode aNode, int aData){
		next = aNode;
		data = aData;
	}
	public void setNext(LLNode aNode){
		next = aNode;
	}
	public void setData(int aData){
		data = aData;
	}
	public int getData(){
		return data;
	}
	public LLNode getNext(){
		return next;
	}
}
class LinkedList{
	private LLNode head;
	private int size;

	public LinkedList(){
		head = null;
		size = 0;
	}

	public void insertFront(int data){
		LLNode temp = new LLNode(data);
		LLNode list = head; //walker node to traverse through list

		if(list == null){
			head = temp;
		}
		else{
			head = temp;
			head.setNext(list);
		}
		size++;
	}
	public void insert(int index, int data){
		LLNode temp = new LLNode(data);
		LLNode walker = head; //walker node to traverse through list

		int i = 1;
		while(walker.getNext() != null && i < (index - 1)){ //walk to index, unless index is at the end
			walker = walker.getNext();
			i++;
		}
		//if we insert to middle without fixing link, all of next nodes disappear
		temp.setNext(walker.getNext());
		//now set current node as new node, with old next links
		walker.setNext(temp);
		size++;
	}
	public void delete(int index) throws Exception{
		if(index < 1 || index > size)
			throw new Exception("Index out of range.");
		if(getSize() == 0)
			throw new Exception("Nothing in the Linked List.");

		LLNode walker = head;
		//deleting the head node
		if((index - 1) == 0)
			walker = walker.getNext();
		else{
			int i = 1;
			while(walker.getNext() != null && i < (index - 1)){ //walk to index, unless index is at the end
				walker = walker.getNext();
				i++;
			}

			walker.setNext(walker.getNext().getNext());
		}
		size--;
	}
	public int getSize(){
		return size;
	}
	public int[] toArray(){
		int[] arr = new int[getSize()];

		LLNode walker = head;
		arr[0] = head.getData();
		int i = 1;
		while(walker.getNext() != null && i < getSize()){
			walker = walker.getNext();
			arr[i] = walker.getData();
			i++;
		}
		return arr;
	}
	public Set<Integer> toSet() throws Exception{
		if(getSize() == 0)
			throw new Exception("Nothing in the Linked List.");

		Set<Integer> newSet = new HashSet<Integer>();
		LLNode walker = head;
		newSet.add(walker.getData());

		while(walker.getNext() != null){
			walker = walker.getNext();
			newSet.add(walker.getData());
		}

		return newSet;
	}
	public void print() throws Exception{
		if(getSize() == 0)
			throw new Exception("Nothing in the Linked List.");

		LLNode walker = head;

		while(walker.getNext() != null){
			System.out.print(walker.getData() + " ");
			walker = walker.getNext();
		}
		if(walker.getNext() == null)
			System.out.print(walker.getData() + " ");
	}
}
public class Assignment35 {
	public static void main(String[] args) throws Exception{
		LinkedList list = new LinkedList();
		try{
			menuOptions(list);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void printMenu(){
		System.out.println("1. Add at first position.");
		System.out.println("2. Add at kth position.");
		System.out.println("3. Delete at kth position.");
		System.out.println("4. Print size of the list.");
		System.out.println("5. Convert list to array.");
		System.out.println("6. Convert list to set.");
		System.out.println("7. Print the list.");
	}
	public static void menuOptions(LinkedList list){
		int menuChoice = 0, data, position;
		char contChoice = 'y';
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
						System.out.print("Data to add: ");
						data = in.nextInt();
						list.insertFront(data);
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 2:
					try{
						System.out.print("Data to add: ");
						data = in.nextInt();
						System.out.print("Position: ");
						position = in.nextInt();
						list.insert(position, data);
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 3:
					try{
						System.out.print("Position(to delete): ");
						position = in.nextInt();
						list.delete(position);
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 4:
					System.out.print("List size: " + list.getSize());
					System.out.println("");
					break;
				case 5:
					try{
						System.out.print("List to array of size " + list.getSize() + ": ");
						int[] toArr = list.toArray();
						for(int i = 0; i < toArr.length; i++)
							System.out.print(toArr[i] + " ");
						System.out.println("");
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 6:
					try{
						System.out.print("List to set: ");
						Set<Integer> toSet = list.toSet();

						for(Iterator<Integer> it = toSet.iterator(); it.hasNext();)
							System.out.print(it.next() + " ");
						System.out.println("");
					}
					catch(Exception e){
						System.out.println(e);
					}
					break;
				case 7:
					try{
						list.print();
						System.out.println("");
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
/*
 * 1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 1
Data to add: 3
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 1
Data to add: 2
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 1
Data to add: 1
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 7
1 2 3 
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 2
Data to add: 4
Position: 2
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 7
1 4 2 3 
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 3
Position(to delete): 4
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 7
1 4 2 
Do you wish to continue (Type y or n): 5
java.util.InputMismatchException

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 5
List to array of size 3: 1 4 2 
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 2
Data to add: 4
Position: 4
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 7
1 4 2 4 
Do you wish to continue (Type y or n): y

1. Add at first position.
2. Add at kth position.
3. Delete at kth position.
4. Print size of the list.
5. Convert list to array.
6. Convert list to set.
7. Print the list.
Select an option: 6
List to set: 1 2 4 
Do you wish to continue (Type y or n): n
 */
