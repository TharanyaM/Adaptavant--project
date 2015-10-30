package date;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormate {
	public static void main(String args[])
	{
		Date d=new Date();
		String st="hh:mm:ss a";
		SimpleDateFormat std=new SimpleDateFormat(st);
		System.out.println(std.format(d));
		
	}

}
