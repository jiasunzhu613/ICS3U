
public class Practice610 {
	static class Student {
		private String name, address, phone, email, password;
		private int age, grade;

		public void setStudentPassword() {
			/*
			 * Generate a pasaword for the student. The password should be 6 characters in
			 * length. It should be made in the following manner: Take (the 2nd letter of
			 * the Name) + (the ones digit of the Age) + (the first character in the
			 * Address) + (digits 3-6 in the phone number)
			 */
			password = String.valueOf(name.charAt(1))
					+ String.valueOf(String.valueOf(age).charAt(String.valueOf(age).length() - 1));
			if (address != null) {
				password += String.valueOf(address.charAt(0));
			}
			if (phone != null) {
				password += phone.substring(3, 6);
			}
		}

		public static void displayContact(Student s) {
			System.out.println(s.name + " : " + s.phone);
		}
		
		public void printContact() {
			System.out.println(this.name + " : " + this.phone);
		}
		
		public String getStudentPassword(String adminPass) {
			if (adminPass.equals("admin")) {
				return this.password;
			}
			return "invalid";
		}
	}

	public static void main(String[] args) {
		
        String [] names = {"Adam", "Bert", "Cansu", "David", "Ernie"};
        int [] ages = {12, 13, 14, 15, 16};
        String [] addresses = {"123 Happy Lane, Ottawa, ON", "45 Colonel By Dr, Ottawa, ON", "32 Abc Dr, Ottawa, ON"};
        String [] phones = {"613-555-3333", "613-555-3334", "613-555-2312"};
        Student [] students = new Student[3];

        for(int i = 0; i < 3; i++){
            students[i] = new Student();
            students[i].name = names[i];
            students[i].age = ages[i];
            students[i].address = addresses[i];
            students[i].phone = phones[i];
            students[i].email = names[i]+"mom@gmail.com";
            students[i].setStudentPassword();
        }
       Student.displayContact(students[0]);
       students[1].printContact();

	}

}
