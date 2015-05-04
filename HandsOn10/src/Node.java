public class Node{
	private Node left, right;
	private int data;

	public Node(){
		left = null;
		right = null;
		data = 0;
	}
	public Node(Node root, int aData){
		root = new Node();
		data = aData;
	}
	public Node getLeft(){
		return left;
	}
	public Node getRight(){
		return right;
	}
	public int getData(){
		return data;
	}
	public void setLeft(Node leaf){
		left = leaf;
	}
	public void setRight(Node leaf){
		right = leaf;
	}
	public void setData(int aData){
		data = aData;
	}
}
