package dmarc;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class UserHandler extends DefaultHandler  
{  static String a,b,c,d,e,f,g,h,i,j,k,l,m,n,p,filename,z,x,da;
   static Connection con,con1;
   static long d1;
   static Date time;
   boolean bDate=false;
   boolean bOrg_name=false;
   boolean bEmail=false;
   boolean bReport_id=false;
   boolean bAdkim=false;
   boolean bAspf=false;
   boolean bp=false;
   boolean bSource_ip=false;
   boolean bCount = false;
   boolean bDisposition = false;
   boolean bSPF = false;
   boolean bDKIM = false;
   boolean bDomain=false;
   boolean bResult=false;
   UserHandler(String m,Connection a,Connection b)
   {
	  filename=m;
	  con=a;
	  con1=b;
   }
   public void startElement(String uri,String localName, String qName, Attributes attributes) throws SAXException
   {
	  if (qName.equalsIgnoreCase("org_name")) 
	  {
	    bOrg_name=true;
	  }
	  else if(qName.equalsIgnoreCase("begin"))
	  {
		  bDate=true;
	  }
      else if (qName.equalsIgnoreCase("email")) 
	  {
	    bEmail=true;
	  }
      else if (qName.equalsIgnoreCase("report_id")) 
	  {
	     bReport_id=true;
	  }
	  else if (qName.equalsIgnoreCase("adkim")) 
      {
	    bAdkim=true;
	  }
	  else if (qName.equalsIgnoreCase("aspf")) 
	  {
        bAspf=true;
	  }
	  else if (qName.equalsIgnoreCase("p")) 
	  {
	    bp=true;
	  }
	  else if (qName.equalsIgnoreCase("source_ip")) 
      {
         bSource_ip=true;
      }
      else if (qName.equalsIgnoreCase("disposition")) 
      {
         bDisposition = true;
      }
      else if (qName.equalsIgnoreCase("SPF"))
      {
         bSPF = true;
      }
      else if (qName.equalsIgnoreCase("DKIM"))
      {
         bDKIM = true;
      }
      
      else if (qName.equalsIgnoreCase("count"))
      {
         bCount = true;
      }
   }
   public void endElement(String uri,String localName, String qName) throws SAXException
   {  
      if (qName.equalsIgnoreCase("record")) 
      {
    	  database();
    	  
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException
   {   
	   if (bOrg_name)
	   {
		     a=new String(ch, start, length);
		     bOrg_name = false;
	   }
	   else if(bDate)
	   {
		   da=new String(ch, start, length);
		   bDate = false;
		   d1=Long.parseLong(da);
		   timestamp(d1);
	   }
	   else if (bEmail)
	   {
		     b=new String(ch, start, length);
		     bEmail = false;
	   }
	   else if (bReport_id)
	   {
		   c=new String(ch, start, length);
	       bReport_id = false;
	   }
	   else if (bAdkim)
	   {
		    d=new String(ch, start, length);
		   bAdkim = false;
	   }
	   else if (bAspf)
	   {
		    e=new String(ch, start, length);
		   bAspf = false;
	   }
	   else if (bp)
	   {      f=new String(ch, start, length);
	         bp = false;
	   }
	   else if (bSource_ip)
	   {    
		     g=new String(ch, start, length);
	         bSource_ip = false;
	   }
	   else if (bCount)
	   {
		    h=new String(ch, start, length);
		    bCount = false;
       } 
	   else if (bDisposition) 
	   { 
		    i=new String(ch, start, length);
		    bDisposition = false;
       } 
	   else if (bSPF) 
	   {
		   j=new String(ch, start, length);  
		   if(j.length()==4)
		      z=j;
		   else if(j.length()>4)
			   getAllUserNames(filename);
		   bSPF=false;
       	}
	   	else if (bDKIM) 
	   	{
		   k=new String(ch, start, length);
		   if(k.length()==4)
				 x=k;
		   else if(k.length()>4)
	        	 getdkim(filename);
		   bDKIM=false;
	   	}
   	}
   public void getAllUserNames(String fileName)
   {	
		try 
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File(fileName);
			if (file.exists()) {
				Document doc = db.parse(file);
				Element docEle = doc.getDocumentElement();
				NodeList studentList = docEle.getElementsByTagName("spf");
				int len1 = studentList.getLength();
                String s="",s1="";
            	if (studentList!=null && studentList.getLength() > 0)
				{   
					for (int i = 0; i<len1; i++) 
					{   
						Node node = studentList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element e = (Element) node;
							NodeList nodeList = e.getElementsByTagName("domain");
							Node n1=nodeList.item(0);
							Node n2;
							if(n1!=null)
							{	n2=n1.getChildNodes().item(0);
								if(n2!=null)
									s= nodeList.item(0).getChildNodes().item(0).getTextContent();
								else
									s="";
								l=s;
							}	
								nodeList = e.getElementsByTagName("result");
								Node n3=nodeList.item(0);
								Node n4;
								if(n3!=null)
								{	
									n4=n3.getChildNodes().item(0);
									if(n4!=null)
										s1=nodeList.item(0).getChildNodes().item(0).getTextContent();
									else
										s1="";
									m=s1;
							}
					}
				} 
			
			}
		}
	}
		catch (Exception e)
		{
			System.out.println(e);
		}
}
   
   public void getdkim(String fileName)
   {
	   try
	  
	   {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
	        File file = new File(fileName);
                if (file.exists()) {
				Document doc = db.parse(file);
				Element docEle = doc.getDocumentElement();
				NodeList studentList1 = docEle.getElementsByTagName("dkim");
               int len2 = studentList1.getLength();
               String s2="",s3="";
               if (studentList1!=null && studentList1.getLength() > 0) 
				{
					for (int i = 0; i<len2; i++)
					{
						Node node = studentList1.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE)
						{
							Element e1 = (Element) node;
							NodeList nodeList = e1.getElementsByTagName("domain");
							Node n5=nodeList.item(0);
							Node n6;
							
							if(n5!=null)
							{
								n6=n5.getChildNodes().item(0);
								if(n6!=null)
									s2= nodeList.item(0).getChildNodes().item(0).getTextContent();
								else
									s2="";
								n=s2;
							}
							nodeList = e1.getElementsByTagName("result");
							Node n7=nodeList.item(0);
							Node n8;
							if(n7!=null)
							{	
								n8=n7.getChildNodes().item(0);
								if(n8!=null)
									s3=nodeList.item(0).getChildNodes().item(0).getTextContent();
								else
									s3="";
								p=s3;
							}
						}	
					}
				} 
			}
	   }
	   
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
   public void timestamp(long timeStamp)
   {
      time = new java.util.Date((long)timeStamp*1000);
   }	 
   public void database()
   {	
	   try
	   {

	   Statement stmt1=con1.createStatement();
	   String sql="create table if not exists Reports(Date VARCHAR(50),Org_Name VARCHAR(50),Email VARCHAR(50),Report_id VARCHAR(255),"
						+ "Policy_adkim VARCHAR(50),Policy_aspf VARCHAR(50),Policy VARCHAR(50),Source_ip VARCHAR(50),"
						+ "ip_count VARCHAR(50),Disposition VARCHAR(50),Record_Dkim VARCHAR(50), Record_Spf VARCHAR(50), "
						+ "Auth_Spf_Domain VARCHAR(50), Auth_Spf_Results VARCHAR(50), Auth_Dkim_Domain VARCHAR(50),"
						+ "Auth_Dkim_Results VARCHAR(50))";
          stmt1.executeUpdate(sql);
	  String sql2="insert into Reports values('"+time+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"
	    		+ ""+h+"','"+i+"','"+z+"','"+x+"','"+l+"','"+m+"','"+n+"','"+p+"')";
          stmt1.executeUpdate(sql2);		 
	   
           }
	   
           catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
 
	   
   }
