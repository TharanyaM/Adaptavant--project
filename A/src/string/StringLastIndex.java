package string;

public class StringLastIndex {
	public static void main(String args[])
	{
		String str="Hello World,hello india";
		int last=str.lastIndexOf("World");
		if(last==-1)
		{
			System.out.println("index not found");
			
		}
		else
		{
			System.out.println("index value is:" +last);
		}
	}
}