
public class Practice605 {

	public static void main(String[] args) {
		class Student {
			String name, address, phone, email, password;
			int age, grade;
			
			public Student() {
				name = "student";
				grade = 9;
				age = 14;
				password = "cb";
			}
			
			public Student(String name, int grade, int age) {
				this.name = name;
				this.age = age;
				this.grade = grade;
				password = "cb";
			}
			
			public Student(String name) {
				this.name = name;
				grade = 9;
				age = 14;
				password = "cb";
			}
			
			public void print(){

		        // Prints a chart displaying the student's info

		        System.out.println("-------------------------------------------------");
		        System.out.println("STUDENT INFO |             ");
		        System.out.println("Name         | " + this.name);
		        System.out.println("Age          | " + this.age);
		        System.out.println("Grade        | " + this.grade);
		        System.out.println("Password     | " + this.password);

		    }
			
			public void setStudentPassword () {
				/*
				 * Generate a password for the student. 
				 * The password should be 6 characters in length. 
				 * It should be made in the following manner:
				 * Take (the 2nd letter of the Name) + 
				 * (the ones digit of the Age) + 
				 * (the first character in the Address) + 
				 * (digits 3-6 in the phone number)
				 */
				password = String.valueOf(name.charAt(1)) + 
						   String.valueOf(String.valueOf(age).charAt(String.valueOf(age).length() - 1));
				if (address != null) {
					password += String.valueOf(address.charAt(0));
				}
				if (phone != null) {
					password += phone.substring(3, 6);
				}
			}
			
			public boolean checkPassword (String password) {
				return this.password == password;
			}
			
			public void copyHomeInfo (Student other) {
				this.address = other.address;
				this.phone = other.phone;
				this.email = other.email;
			}
		}
		
		// Instance of Student using default constructor
        Student s1 = new Student();

        // Instance of Student using constuctor 2
        Student s2 = new Student("William Gates", 11, 16);

        // Instance of Student using constructor 3
        Student s3 = new Student("Steven Jobs");

        s1.print();
        s2.print();
        s3.print();
	}

}
