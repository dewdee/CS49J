class LLNode{
	private LLNode next;
	private int data;
	public LLNode(){
		next = null;
		data = 0;
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
// Stack has: push, pop, getTop
class Stack{
	private LLNode top;
	private int size;
	public Stack(){
		top = null;
		size = 0;
	}
	public void push(int data){
		LLNode newLink = new LLNode(null, data);
		if(emptyStack())
			top = newLink;
		else{
			newLink.setNext(top);
			top = newLink;
		}
		size++;
	}
	public int pop(){
		LLNode out = top;
		top = out.getNext();
		size--;

		return out.getData();
	}
	public int getTop(){
		if(!emptyStack())
			return top.getData();
		else
			return -1;
	}
	public boolean emptyStack(){
		return (size == 0);
	}
	public int getSize(){
		return size;
	}
}
//Queue has: insertFront, insertRear, removeFront, removeRear
class Queue{
	private LLNode top;
	private LLNode rear;
	private int size;
	public Queue(){
		top = null;
		rear = null;
		size = 0;
	}
	public void insertFront(int data){ //insert beginning of queue
		LLNode newLink = new LLNode(null, data);
		if(emptyQueue())
			top = newLink; //nothing in the queue
		else{
			//shift everything back one
			LLNode temp = top;
			top = newLink;
			newLink.setNext(temp);
		}
		size++;
	}
	public void insertRear(int data){ //insert to end of queue
		LLNode newLink = new LLNode(null, data);
		if(emptyQueue())
			top = newLink;
		else
			rear.setNext(newLink);
		size++;
		rear = newLink;
	}
	public int removeFront(){ //remove from beginning of queue
		if(emptyQueue())
			return -1;
		else{
			if(size == 1){
				int temp = top.getData();
				top = null;
				rear = null;
				size--;
				return temp;
			}
			LLNode out = top;
			top = out.getNext();
			size--;

			return out.getData();
		}
	}
	public int removeRear(){ //remove from end of queue
		if(emptyQueue())
			return -1;
		else{
			if(size == 1){
				int temp = top.getData();
				top = null;
				rear = null;
				size--;
				return temp;
			}
			LLNode out = rear;
			rear = null;
			size--;

			return out.getData();
		}
	}
	public int getTop(){
		if(!emptyQueue())
			return top.getData();
		else
			return -1;
	}
	public int getRear(){
		if(!emptyQueue())
			return rear.getData();
		else
			return -1;
	}
	public boolean emptyQueue(){
		return (size == 0);
	}
	public int getSize(){
		return size;
	}
}
public class Problem3 {
	public static void main(String[] args){
		Stack s = new Stack();
		s.push(4);
		s.push(3);
		s.push(7);
		int a = s.pop();
		System.out.println("Popped: " + a);
		System.out.println("Top of stack: " + s.getTop());

		Queue q = new Queue();
		q.insertRear(3);
		q.insertFront(1);
		q.insertRear(5);
		//should be 1 -> 3 - > 5
		int b = q.removeFront();

		System.out.println("Front: " + b);
		System.out.println("Front: " + q.getTop());
		b = q.removeRear();
		System.out.println("Rear: " + b);
		System.out.println("Size: " + q.getSize());
	}
}
