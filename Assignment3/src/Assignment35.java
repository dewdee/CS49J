import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
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

	public void insert(int data){
		LLNode temp = new LLNode(data);
		LLNode walker = head; //walker node to traverse through list

		if(walker == null){
			head = temp;
		}
		else{
			while(walker.getNext() != null) //find end of list
				walker = walker.getNext();
			//set end of list as the new data
			walker.setNext(temp);
		}
		size++;
	}
	public void insert(int index, int data){
		LLNode temp = new LLNode(data);
		LLNode walker = head; //walker node to traverse through list

		int i = 1; //index starts at 1, not 0
		while(walker.getNext() != null && i < index){ //walk to index, unless index is at the end
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
		if(index < 0 || index > size)
			throw new Exception("Index out of range.");
		if(getSize() == 0)
			throw new Exception("Nothing in the Linked List.");

		LLNode walker = head;
		//deleting the head node
		if(index == 0)
			walker = walker.getNext();
		else{
			int i = 1;
			while(walker.getNext() != null && i < index){ //walk to index, unless index is at the end
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
			System.out.println(walker.getData());
			walker = walker.getNext();
		}
		if(walker.getNext() == null)
			System.out.println(walker.getData());
	}
}
public class Assignment35 {
	public static void main(String[] args) throws Exception{
		LinkedList test = new LinkedList();

		test.insert(2);
		test.insert(5);
		test.insert(1);
		test.insert(7);
		test.insert(4);
		test.delete(2);
		test.print();
		
		System.out.println("Size: " + test.getSize());
		int[] toArr = test.toArray();
		Set<Integer> toSet = test.toSet();
		
		for(Iterator<Integer> it = toSet.iterator(); it.hasNext();){
			System.out.print(it.next());
		}
		System.out.println(Arrays.toString(toArr));
	}
}
