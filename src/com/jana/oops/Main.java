package com.jana.oops;

public class Main {

	//Static Class
	public static class Student {
		int rollNo;
		String name;
		int age = 20;
		double marks;
		static String subject;
		//Default Constructor no-args
		public Student() {
			System.out.println("Student object created.\n");
		}
		
		//Parameterized Constructor
		public Student(int roll, String name, double marks) {
			this.rollNo = roll;
			this.name = name;
			this.marks = marks;

		}
		
		//Parameterized Constructor
		public Student(int roll, String name, double marks, String sub) {
			this.rollNo = roll;
			this.name = name;
			this.marks = marks;
			//Static fields cannot be this, as it has global access in the class
			subject = sub;
		}
		
		//Copy Constructor
		public Student(Student st) {
			this.rollNo = st.rollNo;
			this.name = st.name;
			this.marks = st.marks;
			this.age = st.age;
		}

		//Method
		void display() {
			// Text Blocks in Java 15
			// Assign values using String.format()-Legacy or .formatted() - modern
			System.out.print("""
					Roll No: %d
					Name: %s
					Age: %d
					""".formatted(rollNo, name, age));

			System.out.println(String.format("""
					Marks: %f
					Subject: %s
					""", marks, subject));
			System.out.println("==================================");

		}
	}

	public static void main(String[] args) {
		//Static field value assignment
		Student.subject = "Physics";

		//New Object Creation
		Student st1 = new Student();
		st1.rollNo = 10;
		st1.name = "Jana";
		st1.age = 25;
		st1.marks = 98.0;
		st1.display();

		Student st2 = new Student(11, "Jana2", 95.6);
		st2.display();

		Student st3 = new Student(12, "Jana3", 94.6, "Maths");
		st3.display();

		Student st4 = new Student(st2);
		st4.display();
		 
	}

}
