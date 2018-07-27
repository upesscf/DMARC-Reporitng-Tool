package dmarc;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
public class delete
{   
	static int count;
	static Connection con2;
	delete (int c,Connection a)
	{
		count=c;
		con2=a;
	}
	public static void deleteFiles(File folder) throws IOException
	{
		File[] files = folder.listFiles();
		for(File file: files)
		{
			if(file.isFile())
			{
				file.delete();
			}
			else if(file.isDirectory()) 
			{
				deleteFiles(file);
			}
		}
	} 
	  public void count()
	   {
		try
		{
			   Statement stmt1=con2.createStatement();
			   String sql3="create table if NOT EXISTS Count (Date VARCHAR(50),Files_parsed Varchar(50))";
	           stmt1.executeUpdate(sql3);
	           Date d = new Date();
	           String sql4="insert into Count values('"+d+"','"+count+"')";
	   		   stmt1.executeUpdate(sql4);
               JOptionPane.showMessageDialog(null,"Completed!!Check Your Database");
               System.exit(0);   
		}  
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}