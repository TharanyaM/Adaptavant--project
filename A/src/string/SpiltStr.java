package string;

public class SpiltStr {
	public static void main(String args[])
	{
		String st="hello world well come all";
		String[] a=st.split("\\s");
		for(int i=0;i<=a.length;i++)
		{
			System.out.println(a);
		}
	}

}
