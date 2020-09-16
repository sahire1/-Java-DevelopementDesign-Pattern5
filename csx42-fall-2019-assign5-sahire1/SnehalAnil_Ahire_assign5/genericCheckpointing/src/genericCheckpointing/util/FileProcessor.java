package genericCheckpointing.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MySpecialTypes;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


public class FileProcessor 
{	


	//public String[] strValues=new String[3];
	//public String[] strValues1=new String[4];
	public ArrayList<String> strValues= new ArrayList<String>();  
	//\public ArrayList<String> strValues1= new ArrayList<String>();  
	public ArrayList<String> Values= new ArrayList<String>(); 
	private static String inputfile;
	
	public void set_input_file(String inputIn)
	{
		inputfile=inputIn;
		
	}
	

//new method





		
	public ArrayList<String> readfile1()  
	{
	//	ArrayList<String> ret = new ArrayList<String>(); 
			//CITED CODE https://www.journaldev.com/709/java-read-file-line-by-line
		
		//int i=0;
		
		 
		int a;
		long b;
		String c;
		boolean d;
		int e;
		
		//System.ou.println(inputfile);
		File f = new File(inputfile);
		if(f.exists() )
		{

			
		}
		else
		{
			MyLogger ml=new MyLogger();
					ml.setDebugValue(5);
					ml.writeMessage(" FILE DOES NOT EXISTS ",MyLogger.DebugLevel.FileDoesNotExists);
			
		}
		
		BufferedReader reader;
		try {
					reader = new BufferedReader(new FileReader(inputfile));
					String line = reader.readLine();
					String typeIn;
				
					
					while (line != null) 
					{
					 
					 //delete after this
					 //for(String i:ValuesIn)
						//{ 
					//System.out.println(line);
						String[] l1 = line.split(" ");
								for(int j=0;j<l1.length;j++)
								{
									if(j==2)
									{
										//System.out.println(j+"  "+l1[j]);
										l1[j]=l1[j].replace("<"," ");
										//System.out.println("  new	"+l1[j]);
										//Values.add(l1[j]);
											if(l1[j].contains("xsi:type"))
											{
												l1[j]=l1[j].replace("xsi:type","");
												l1[j]=l1[j].replace(">","");
												l1[j]=l1[j].replace("=","");
												
												//System.out.println("  new	"+l1[j]);
												Values.add(l1[j]);
											}
											else
											{
												//System.out.println("  new	"+l1[j]);
												Values.add(l1[j]);
											}
										
										
									}
									if(j==3)
									{
										String[] l2 = line.split(">");
												for(int k=0;k<l2.length;k++)
												{
													
													if(k==1)
													{
														String[] l3= l2[k].split("<");
													
															//for(int m=0;m<l3.length;m++)
													//if(m==0)
														//{
															//System.out.println("m"+0+"  "+l3[0]);
															Values.add(l3[0]);
													//	}
													}
													
												
												}
									}
								}
					
							
							
						//}
					 
					 //delete before this
					 strValues.add(line);
					 
					 
			//			i++;
						//input.add("hi");
						//input.add(line);

						line = reader.readLine();
					}

		//	ArrayList<String> infile = new ArrayList<String>(Arrays.asList(strValues)); 
			//ret=infile;
	
		reader.close();
			
			} catch (IOException e1) 
				{
					MyLogger ml=new MyLogger();
					ml.setDebugValue(4);
					ml.writeMessage(" IO EXCEPTION ",MyLogger.DebugLevel.FILE_PROCESSOR);
				}
				finally
				{
					
				}
		return Values; 
		

	}







	
	
}


