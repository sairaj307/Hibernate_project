package Strings;

public class Comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "TNSIF";
		String s2 = "TNSIF";
		
		String s3 = new String("TNSIF");
		String s4 = new String("TNSIF");

		String s5 = new String("Bhalki");
		
		System.out.println("s1 == s2: " + (s1 == s2)+ "  s1 equals s2 "+ s1.equals(s2));
		System.out.println("s1 == s3: " + (s1 == s3)+ "  s1 equals s3 "+ s1.equals(s3));
		System.out.println("s4 == s3: " + (s4 == s3)+ "  s4 equals s3 "+ s4.equals(s3));
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		
		System.out.println(s1.compareTo("tnsif"));
		System.out.println(s1.compareToIgnoreCase("tnsif"));
		System.out.println(s1.compareTo(s2));
	}

}
