package string;

public class Reverse {
	public static void main(String args[])
	{
		String str="tharanya";
		String reverse=new StringBuffer(str).reverse().toString();
		System.out.println("before reverse:"+str);
		System.out.println("after reverse:"+reverse);
	}

}
