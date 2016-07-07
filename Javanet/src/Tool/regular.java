package Tool;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regular {

	public  ArrayList match(String pattern,String line)
	{
		ArrayList list = new ArrayList();
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		while(m.find())
		{
			list.add(m.group());
		}
		return list;
	}
}
