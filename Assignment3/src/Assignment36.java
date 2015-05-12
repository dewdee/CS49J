public class Assignment36 {
	public static void main(String[] args){
		BST bst = new BST();
		
		Employee person = new Employee(3, "Sara");
		bst.insert(person);
		person = new Employee(1,"John");
		bst.insert(person);
		person = new Employee(6, "Jill");
		bst.insert(person);
		person = new Employee(1, "Bob");
		bst.insert(person);
<<<<<<< HEAD
		person = new Employee(4, "David");
		
		Employee s = bst.search(person);
		if(s == null){
			s = bst.getClosestEmployee(person);
		}
		System.out.println(s.getData());
=======
		
>>>>>>> 79aef4e99a1f66cdab2665d4425f573856b505f7
	}
}
