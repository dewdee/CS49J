public class Assignment36 {
	public static void main(String[] args){
		BST bst = new BST();
		
		Employee person = new Employee(5, "Michael");
		bst.insert(person);
		person = new Employee(2,"Josh");
		bst.insert(person);
		person = new Employee(9, "David");
		bst.insert(person);
		person = new Employee(2, "David");
		bst.insert(person);
	}
}
