import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Assignment34 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		try{
			Queue<String> students = readFile("Enrolled.txt");
			Queue<String> waitlist = readFile("Waitlist.txt");
			
			String name;
			int capacity = students.size();
			System.out.println("Enter the names of students who want to drop");
			while(!(name = in.nextLine()).equals("q")){
				if(students.contains(name))
					students.remove(name);
				else
					System.out.println("Student " + name + " does not appear to have enrolled in this class");
			}
			while(students.size() < capacity){
				String newStudent = waitlist.poll();
				students.add(newStudent);
			}
			writeFile("Enrolled_v1.txt", students);
			System.out.println("Enrolled_v1.txt has been created.");
			writeFile("Waitlist_v1.txt", waitlist);
			System.out.println("Waitlist_v1.txt has been created.");
		}
		catch(Exception e){
			System.out.println(e);
		}
		in.close();
	}
	public static Queue<String> readFile(String fileName) throws IOException{
		Queue<String> students = new LinkedList<String>();
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
			
			String line;
			System.out.println("Contents of " + fileName);
			while((line = in.readLine()) != null){
				students.add(line);
				System.out.println(line);
			}
			in.close();
			return students;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return students;
	}
	public static void writeFile(String fileName, Queue<String> q) throws IOException{
		try{
			PrintStream writer = new PrintStream(new File(fileName));
			while(!q.isEmpty())
				writer.println(q.poll());
			writer.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/*
 * Contents of Enrolled.txt
Sarah
John
Bob
Jill
Jack
Mike
Sana
Charlie
Kate
Kathy
Contents of Waitlist.txt
Noah
Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina
Enter the names of students who want to drop
Jack
Mike
q
Enrolled_v1.txt has been created.
Waitlist_v1.txt has been created.

Contents of Enrolled.txt
Sarah
John
Bob
Jill
Jack
Mike
Sana
Charlie
Kate
Kathy
Contents of Waitlist.txt
Noah
Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina
Enter the names of students who want to drop
Charlie
Katy
Student Katy does not appear to have enrolled in this class
Kate
Kathy
q
Enrolled_v1.txt has been created.
Waitlist_v1.txt has been created.
Sarah
John
Bob
Jill
Jack
Mike
Sana
Noah
Jason
Helen

Ben
Judy
George
Rich
Toby
Tom
Gina

Contents of Enrolled.txt
Sarah
John
Bob
Jill
Jack
Mike
Sana
Charlie
Kate
Kathy
Contents of Waitlist.txt
Noah
Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina
Enter the names of students who want to drop
Noah
Student Noah does not appear to have enrolled in this class
Sana
q
Enrolled_v1.txt has been created.
Waitlist_v1.txt has been created.

Sarah
John
Bob
Jill
Jack
Mike
Charlie
Kate
Kathy
Noah

Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina

Contents of Enrolled.txt
Sarah
John
Bob
Jill
Jack
Mike
Sana
Charlie
Kate
Kathy
Contents of Waitlist.txt
Noah
Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina
Enter the names of students who want to drop
Jack
q
Enrolled_v1.txt has been created.
Waitlist_v1.txt has been created.

Sarah
John
Bob
Jill
Mike
Sana
Charlie
Kate
Kathy
Noah


Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina

Contents of Enrolled.txt
Sarah
John
Bob
Jill
Jack
Mike
Sana
Charlie
Kate
Kathy
Contents of Waitlist.txt
Noah
Jason
Helen
Ben
Judy
George
Rich
Toby
Tom
Gina
Enter the names of students who want to drop
Sarah
Mike
Jack
Jill
Kathy
Kate
q
Enrolled_v1.txt has been created.
Waitlist_v1.txt has been created.

John
Bob
Sana
Charlie
Noah
Jason
Helen
Ben
Judy
George


Rich
Toby
Tom
Gina

 * */
 