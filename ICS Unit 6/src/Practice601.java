import java.util.*;
public class Practice601 {

	public static void main(String[] args) {
		class Student {
			String fname, lname;
			int grade, age;
		}
		
		Student[] students = new Student[4];
		students[0] = new Student();
		students[1] = new Student();
		students[2] = new Student();
		students[3] = new Student();
		
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {
				if (j == 0) {
					students[i].fname = console.nextLine();
				}else if (j == 1) {
					students[i].lname = console.nextLine();
				}else if (j == 2) {
					students[i].age = Integer.parseInt(console.nextLine());
				}else {
					students[i].grade = Integer.parseInt(console.nextLine());
				}
			}
		}
		
		System.out.println(students[0].fname);
		System.out.println(students[1].lname);
		System.out.println(students[2].age);
		System.out.println(students[3].grade);

	}

}
