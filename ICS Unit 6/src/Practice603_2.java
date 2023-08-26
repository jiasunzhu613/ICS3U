
public class Practice603_2 {

	public static void main(String[] args) {
		class Student {
			String name, address, phone, email, password;
			int age, grade;
		
			public void print () {
		        System.out.println("-------------------------------------------------");
		        System.out.println("STUDENT INFO |             ");
		        System.out.println("Name         | " + name);
		        System.out.println("Age          | " + String.valueOf(age));
		        System.out.println("Password     | " + password);
		        System.out.println("---------------------------");
		        System.out.println("CONTACT INFO |             ");
		        System.out.println("Address      | " + address);
		        if (phone != null) {
		        	System.out.println("Phone        | " + phone);
		        }else {
		        	System.out.println("Phone        | ");
		        }
		        if (email != null) {
		        	System.out.println("Email        | " + email);
		        }else {
		        	System.out.println("Email        | ");
		        }
		        System.out.println("-------------------------------------------------");
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
		
		// Create random students 
        String [] names = {"Adam", "Bert", "Cansu", "David", "Ernie"};
        int [] ages = {12, 13, 14, 15, 16};
        String [] addresses = {"123 Happy Lane, Ottawa, ON", "45 Colonel By Dr, Ottawa, ON", "32 Abc Dr, Ottawa, ON"};
        String [] phones = {"613-555-3333", "613-555-3333", "613-555-2312"};


        Student [] students = new Student[4];

        for(int i = 0; i < 3; i++){
            students[i] = new Student();
            students[i].name = names[i];
            students[i].age = ages[i];
            students[i].address = addresses[i];
            students[i].phone = phones[i];
            students[i].email = "enter";
            students[i].setStudentPassword();
        }

        // Set student 0 email info
        students[0].email = "mom@gmail.com";

        // Test instance methods 
        students[3] = new Student();
        students[3].name = names[3];
        students[3].age = ages[3];
        students[3].copyHomeInfo(students[0]);
        students[3].setStudentPassword();

        // Print all student info
        for (int x=0; x<=3; x++){
        students[x].print();}

        //test checkPassword
        System.out.println("Password check:  " + students[0].checkPassword("no"));
        String pass = students[0].password;
        System.out.println("Valid password check: " + students[0].checkPassword(pass));
	}

}
