public class BST{
	private Node root;
	public BST(){
		root = null;
	}
	public boolean insert(Employee person){
		if(search(person.getID()) == null){
			root = insert(root, person);
			System.out.println(person.getData() + " has been inserted into the tree.");
		}
		else{
			System.out.println("ID already taken by another employee.");
			return false;
		}
		
		return true;
	}
	private Node insert(Node leaf, Employee person){
		//nothing in node
		if(leaf == null)
			leaf = new Node(leaf, person);
		//else there is something in the node
		else{
			//need to compare if data is less than or greater than our root/parent node (alphabetically)
			if(person.getID() < leaf.getEmployee().getID()){ //insert to left side
				leaf.setLeft(insert(leaf.getLeft(), person));
				return leaf;
			}
			else if (person.getID() > leaf.getEmployee().getID()){ //insert to right side
				leaf.setRight(insert(leaf.getRight(), person));
				return leaf;
			}
		}
		return leaf;
	}
	public boolean delete(int ID){		
		if(root == null){
			System.out.println("Tree is empty.");
			return false;
		}
		else if(search(ID) == null){
			Employee person = getClosestEmployee(ID);
			System.out.println(ID + " does not exist in the tree, closest employee is: " + person.getData());
			return false;
		}
		else{
			System.out.println(root.getEmployee().getData() + " has been deleted.");
			root = delete(root, ID);
		}
		return true;
	}
	private Node delete(Node leaf, int ID){
		Node temp, newRoot;
		Employee tempData;
		//looking for node
		if(ID < leaf.getEmployee().getID())
			leaf.setLeft(delete(leaf.getLeft(), ID));
		else if (ID > leaf.getEmployee().getID())
			leaf.setRight(delete(leaf.getRight(), ID));
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
					tempData = leaf.getEmployee(); //swapping data around
					leaf.setData(temp.getEmployee());
					temp.setData(tempData);
					leaf.setLeft(delete(leaf.getLeft(), ID));
				}
			}
		}
		return leaf;
	}
	public Employee search(int ID){
		if(root != null)
			return search(root, ID);
		else
			return null; //nothing
	}
	private Employee search(Node leaf, int ID){
		if(leaf == null)
			return null; //nothing
		if(root != null){
			if(ID < leaf.getEmployee().getID())
				return search(leaf.getLeft(), ID);
			else if(ID > leaf.getEmployee().getID())
				return search(leaf.getRight(), ID);
			else
				return leaf.getEmployee();
		}
		else
			return null; //nothing
	}
/*	BinaryTreeNode* getClosestNode(BinaryTreeNode* pRoot, int value)
	{
	    BinaryTreeNode* pClosest = NULL;
	    int minDistance = 0x7FFFFFFF;
	    BinaryTreeNode* pNode = pRoot;
	    while(pNode != NULL){
	        int distance = abs(pNode->m_nValue - value);
	        if(distance < minDistance){
	            minDistance = distance;
	            pClosest = pNode;
	        }

	        if(distance == 0)
	            break;

	        if(pNode->m_nValue > value)
	            pNode = pNode->m_pLeft;
	        else if(pNode->m_nValue < value)
	            pNode = pNode->m_pRight;
	    }

	    return pClosest;
	}*/
	public Employee getClosestEmployee(int ID){
		return getClosestEmployee(root, ID);
	}
	private Employee getClosestEmployee(Node root, int ID){
		Node closest = null;
		
		int minDistance = Integer.MAX_VALUE;
		Node curr = root;
		
		while(curr != null){
			int distance = Math.abs(curr.getEmployee().getID() - ID);
			if(distance < minDistance){
				minDistance = distance;
				closest = curr;
			}
			if(distance == 0)
				break;
			if(curr.getEmployee().getID() > ID)
				curr = curr.getLeft();
			else if(curr.getEmployee().getID() < ID)
				curr = curr.getRight();
		}
		
		return closest.getEmployee();
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
			System.out.printf("%d. %d %s\n", level, leaf.getEmployee().getID(), leaf.getEmployee().getName());
			printRankOrder(leaf.getLeft(),level);
		}
	}
}