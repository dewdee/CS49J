class BST{
	private Node root;
	public BST(){
		root = null;
	}
	public boolean insert(int data){
		root = insert(root, data);

		System.out.println(data + " has been inserted into the tree.");
		return true;
	}
	private Node insert(Node leaf, int aData){
		//nothing in node
		if(leaf == null)
			leaf = new Node(leaf, aData);
		//else there is something in the node
		else{
			//need to compare if data is less than or greater than our root/parent node (alphabetically)
			if(aData < leaf.getData()){ //insert to left side
				leaf.setLeft(insert(leaf.getLeft(), aData));
				return leaf;
			}
			else if (aData > leaf.getData()){ //insert to right side
				leaf.setRight(insert(leaf.getRight(), aData));
				return leaf;
			}
			else //duplicate found
				leaf.setData(aData); //set with the same value
		}
		return leaf;
	}
	public boolean delete(int aData){
		if(root == null){
			System.out.println("Tree is empty.");
			return false;
		}	
		else if(search(aData) != aData){
			System.out.println(aData + " does not exist in the tree.");
			return false;
		}
		else{
			root = delete(root, aData);
			System.out.println(aData + " has been deleted.");
		}
		return true;
	}
	private Node delete(Node leaf, int aData){
		Node temp, newRoot;
		int tempData;
		//looking for node
		if(aData < leaf.getData()){
			leaf.setLeft(delete(leaf.getLeft(), aData));

		}
		else if (aData > leaf.getData()){
			leaf.setRight(delete(leaf.getRight(), aData));
		}
		else{ //found node

			//node with only one child or no child
			if(leaf.getLeft() == null){
				newRoot = leaf.getRight();
				return newRoot;
			}
			else{
				if(leaf.getRight() == null){
					newRoot = leaf.getLeft();
					return newRoot;
				}
				//node has two children, predecessor, looking for largest value in left subtree
				else{
					temp = leaf.getLeft();
					while(temp.getRight() != null) //traverse left subtree
						temp = temp.getRight();
					tempData = leaf.getData(); //swapping data around
					leaf.setData(temp.getData());
					temp.setData(tempData);
					leaf.setLeft(delete(leaf.getLeft(), temp.getData()));
				}
			}
		}
		return leaf;
	}
	public int search(int aData){
		if(root != null)
			return search(root, aData);
		else
			return -1; //nothing
	}
	private int search(Node leaf, int aData){
		if(leaf == null)
			return -1; //nothing
		if(root != null){
			if(aData < leaf.getData())
				return search(leaf.getLeft(), aData);
			else if(aData > leaf.getData())
				return search(leaf.getRight(), aData);
			else
				return leaf.getData();
		}
		else
			return -1; //nothing
	}
	public void inOrderTraversal(){
		if(root == null)
			System.out.println("Nothing in tree.");
		else{
			System.out.println("InOrder:");
			inOrderTraversal(root);
			System.out.println("");
		}
	}
	public void inOrderTraversal(Node leaf){
		if(leaf != null){
			inOrderTraversal(leaf.getLeft());
			System.out.print(leaf.getData() + " ");
			inOrderTraversal(leaf.getRight());
		}
	}
	public void postOrderTraversal(){
		if(root == null)
			System.out.println("Nothing in tree.");
		else{
			System.out.println("Post Order:");
			postOrderTraversal(root);
			System.out.println("");
		}
	}
	public void postOrderTraversal(Node leaf){
		if(leaf != null){
			postOrderTraversal(leaf.getLeft());
			postOrderTraversal(leaf.getRight());
			System.out.print(leaf.getData() + " ");
		}
	}
	public void preOrderTraversal(){
		if(root == null)
			System.out.println("Nothing in tree.");
		else{
			System.out.println("Pre Order:");
			preOrderTraversal(root);
			System.out.println("");
		}
	}
	public void preOrderTraversal(Node leaf){
		if(leaf != null){
			System.out.print(leaf.getData() + " ");
			preOrderTraversal(leaf.getLeft());
			preOrderTraversal(leaf.getRight());
		}
	}
	public void printRankOrder(){
		if(root == null)
			System.out.println("Nothing in tree.");
		else{
			System.out.println("Rank Order:");
			printRankOrder(root, 0);
			System.out.println("");
		}
	}
	private void printRankOrder(Node leaf, int level){
		if(leaf != null){
			level++;
			printRankOrder(leaf.getRight(),level);
			for(int i = 0; i < level; i++)
				System.out.print("	");
			System.out.printf("%d. %d\n", level, leaf.getData());
			printRankOrder(leaf.getLeft(),level);
		}
	}
	public Node getRoot(){
		return root;
	}
}