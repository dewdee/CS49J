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
		if(index == 0){
			walker = walker.getNext();
		}
		else{
			int i = 1;
			while(walker.getNext() != null && i < index){ //walk to index, unless index is at the end
				walker = walker.getNext();
				i++;
			}
			// 3 4 5 6, delete 4 
			walker.setNext(walker.getNext().getNext());
		}
		size--;
	}
	public int getSize(){
		return size;
	}
	public void toArray(){

	}
	public void toSet(){

	}
	public void print(){

	}
}
public class Assignment35 {
	public static void main(String[] args){
		LinkedList test = new LinkedList();

		test.insert(2);
		test.insert(5);
		test.insert(1);
		test.insert(7);
		test.insert(4);
		try{
			test.delete(2);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
