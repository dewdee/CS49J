public class BST{
	private Node root;
	public BST(){
		root = null;
	}
	public boolean insert(Employee person){
		if(search(person) == null){
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
	public boolean delete(Employee person){
		if(root == null){
			System.out.println("Tree is empty.");
			return false;
		}	
		else if(search(person) != person){
			//System.out.println(person.getData() + " does not exist in the tree, closest ID is: " + temp.getData());
			return false;
		}
		else{
			root = delete(root, person);
			System.out.println(person.getData() + " has been deleted.");
		}
		return true;
	}
	private Node delete(Node leaf, Employee person){
		Node temp, newRoot;
		Employee tempData;
		//looking for node
		if(person.getID() < leaf.getEmployee().getID()){
			leaf.setLeft(delete(leaf.getLeft(), person));

		}
		else if (person.getID() > leaf.getEmployee().getID()){
			leaf.setRight(delete(leaf.getRight(), person));
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
					tempData = leaf.getEmployee(); //swapping data around
					leaf.setData(temp.getEmployee());
					temp.setData(tempData);
					leaf.setLeft(delete(leaf.getLeft(), temp.getEmployee()));
				}
			}
		}
		return leaf;
	}
	public Employee search(Employee person){
		if(root != null)
			return search(root, person);
		else
			return null; //nothing
	}
	private Employee search(Node leaf, Employee person){
		if(leaf == null)
			return null; //nothing
		if(root != null){
			if(person.getID() < leaf.getEmployee().getID())
				return search(leaf.getLeft(), person);
			else if(person.getID() > leaf.getEmployee().getID())
				return search(leaf.getRight(), person);
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
	public Employee getClosestEmployee(Employee person){
		return getClosestEmployee(root,person);
	}
	private Employee getClosestEmployee(Node root, Employee person){
		Node closest = null;
		
		int minDistance = Integer.MAX_VALUE;
		Node curr = root;
		
		while(curr != null){
			int distance = Math.abs(curr.getEmployee().getID() - person.getID());
			if(distance < minDistance){
				minDistance = distance;
				closest = curr;
			}
			if(distance == 0)
				break;
			if(curr.getEmployee().getID() > person.getID())
				curr = curr.getLeft();
			else if(curr.getEmployee().getID() < person.getID())
				curr = curr.getRight();
		}
		
		return closest.getEmployee();
	}
	public Node getRoot(){
		return root;
	}
}