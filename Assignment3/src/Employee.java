
public class Employee{
	private int id;
	private String name;
	
	Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	public String getData(){
		return Integer.toString(id) + " " + name;
	}
	public void setData(int id, String name){
		this.id = id;
		this.name = name;
	}
}
