public class Problem6{
	public static void main(String[] args){
		BST b = new BST();
		
		b.insert(6);
		b.insert(1);
		b.insert(8);
		b.insert(3);
		b.insert(5);
		b.insert(2);
		b.insert(7);
		b.insert(9);
		b.insert(10);
		b.insert(0);
		b.printRankOrder();
		b.inOrderTraversal();
		b.postOrderTraversal();
		b.preOrderTraversal();
		if(isBST(b.getRoot()))
			System.out.println("Valid BST.");
	}
	public static boolean isBST(Node root){
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); //min value holds -2^31, max is 2^31 - 1
	}
	public static boolean isBST(Node leaf, int min, int max){
		if(leaf == null)
			return true;
		if(leaf.getData() <= min || leaf.getData() >= max)
			return false;
		return isBST(leaf.getLeft(), min, leaf.getData()) && isBST(leaf.getRight(), leaf.getData(), max);
	}
}