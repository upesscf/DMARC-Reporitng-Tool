package dmarc;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.GZIPInputStream;
import java.util.*;
public class unz 
{       
        String name,s;
        static String testfolder,output;
        int a=1; 
        ArrayList<String> list=new ArrayList<String>();   
        void func(String q,String b)
        {
             testfolder=q;
             output=b;
        }
        void unzip() 
        {	
        	String destDir="",zipFilePath="";	
        	File folder = new File(testfolder);
        	File[] listOfFiles = folder.listFiles();
        	for (File file : listOfFiles) 
        	{
        		if (file.isFile())
        		{
        			name=file.getName();
        			zipFilePath =testfolder+"/"+name; 
        			if(zipFilePath.lastIndexOf(".") != -1 && zipFilePath.lastIndexOf(".") != 0)
        				s=zipFilePath.substring(zipFilePath.lastIndexOf(".")+1);
        			destDir= output;
        			if(s.equalsIgnoreCase("zip"))
        			{
        				File dir = new File(destDir);
        				if(!dir.exists()) dir.mkdirs();
        					FileInputStream fis;
        				byte[] buffer = new byte[1024];
        				try
        				{
        					fis = new FileInputStream(zipFilePath);
        					ZipInputStream zis = new ZipInputStream(fis);
        					ZipEntry ze = zis.getNextEntry();
        					while(ze != null)
    	        		{
    	        		
    	        			File newFile = new File(destDir + File.separator + a+".xml");
    	        			a++;
    	        			new File(newFile.getParent()).mkdirs();
    	        			FileOutputStream fos = new FileOutputStream(newFile);
    	        			int len;
    	        			while ((len = zis.read(buffer)) > 0) 
    	        			{
    	        				fos.write(buffer, 0, len);
    	        			}
    	        			fos.close();
    	        			zis.closeEntry();
    	        			ze = zis.getNextEntry();
    	        		}
    	        		zis.closeEntry();
    	        		zis.close();
    	        		fis.close();
    	        	}
    	        	catch (IOException e) 
    	        	{
    	        		e.printStackTrace();
    	        	}
    	        }
    	        else if(s.equalsIgnoreCase("xml"))
    	        {
    	        	try
    	        	{
    	        		Files.move(Paths.get(zipFilePath),Paths.get(output+"/"+a));
    	        		a++;
    	            }
    	        	catch(Exception e)
    	        	{
    	        	e.printStackTrace();
    	        	}
    	        }
    	        else if(s.equalsIgnoreCase("gz"))
    	        {
    	        	unz gZipFile = new unz();
    	        	gZipFile.unGunzipFile(zipFilePath,output+"/"+a+".xml");
    	        	a++;
    	        }
    	}   }
    	
    	        File folder1 = new File(output);
    	    	File[] listOfFiles1 = folder1.listFiles();
    	      	for (File file1 : listOfFiles1) 
    	    	{
    	    	    if (file1.isFile())
    	    	    {
    	    	    	list.add(file1.getName());
    	    	    }
    	    	}  
    	      	int countl = list.size();
    	        System.out.println("Size of list = " + countl); 
    	}
     public void unGunzipFile(String compressedFile, String decompressedFile) 
     {  	  
          byte[] buffer = new byte[1024];
    	  try 
    	  {
    	     FileInputStream fileIn = new FileInputStream(compressedFile);
    	     GZIPInputStream gZIPInputStream = new GZIPInputStream(fileIn);
    	     FileOutputStream fileOutputStream = new FileOutputStream(decompressedFile);
    	     int bytes_read;
    	     while ((bytes_read = gZIPInputStream.read(buffer)) > 0)
    	     {
                    fileOutputStream.write(buffer, 0, bytes_read);
     	     } 	 
    	     gZIPInputStream.close();
 	         fileOutputStream.close();
           } 
    	  catch (IOException ex) 
    	  {
    	     ex.printStackTrace();
    	  }
      }  
    }

