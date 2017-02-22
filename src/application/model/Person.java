package application.model;

import java.io.Serializable;

public class Person implements Serializable{
	

		public String lastName;
		public String firstName;
		public int age;
		public String gender;
		public static final int NAME_MAX_LENGTH = 64;
		public String team;
		public boolean isMale;
		
		
		public Person(String firstname, String lastname, int age, Boolean isMale){
			
			firstname = setFirstLetterBig(firstname);
			lastname = setFirstLetterBig(lastname);
			
			this.firstName=firstname;
			this.lastName=lastname;			
			this.age=age;			
			this.isMale=isMale;
		}
		
		public static boolean checkName(String nimi) {

			if (nimi.length() < 1 || nimi.length() > NAME_MAX_LENGTH)
				return false;

			for (int i = 0; i < nimi.length(); ++i) {
				int merkki = nimi.codePointAt(i);
				if (merkki != '-' && !Character.isLetter(merkki))
					return false;
			}

			return true;
		}
		
		
		 boolean setFirstName(String firstName) {		
			if(checkName(firstName)){
			this.firstName = firstName;
			return true; 
			}
			return false;
			
		}

		 boolean setLastName(String lastname) {		
			if(checkName(lastname)){
			this.lastName = lastname;
			return true;
			}
			return false;
		}

		 boolean setAge(int age) {
			if(age>0 && age <150){
			this.age = age;
			return true; }
			return false;
		}

		 void setGender(String gender) {
			this.gender = gender;
		}
		
		public String getFirstName(){
			return this.firstName;
		}
		
		public String getLastName(){
			return this.lastName;
		}
		
		public int getAge(){
			return this.age;
		}
		
		public Boolean isMale(){
			return this.isMale;
		}
		
		@Override
		public String toString(){
			return this.firstName+" "+this.lastName;
		}
		
		private String setFirstLetterBig(String name){
			String newName = name.substring(0, 1).toUpperCase() + name.substring(1);
			return newName;
		}
		
		
}
