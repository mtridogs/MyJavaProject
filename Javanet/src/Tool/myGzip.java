package Tool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class myGzip {
	
public static String ZipString(String str) throws IOException
{
byte strings[] = str.getBytes("UTF-8");
ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(1024);  
GZIPOutputStream gzipOutput = new GZIPOutputStream(byteOutput, 1024);  
gzipOutput.write(strings);  
gzipOutput.close(); 
String ZipString = new String(strings,"UTF-8");
return ZipString;	
}
	
}
