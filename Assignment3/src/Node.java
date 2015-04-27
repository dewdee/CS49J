public class Node {
	private Node left, right;
	private Employee person;
	
	public Node(){
		left = null;
		right = null;
		person = null;
	}
	public Node(Node root, Employee person){
		root = new Node();
		this.person = person;
	}
	public Node getLeft(){
		return left;
	}
	public Node getRight(){
		return right;
	}
	public Employee getEmployee(){
		return person;
	}
	public void setLeft(Node leaf){
		left = leaf;
	}
	public void setRight(Node leaf){
		right = leaf;
	}
	public void setData(Employee person){
		this.person = person;
	}
}
