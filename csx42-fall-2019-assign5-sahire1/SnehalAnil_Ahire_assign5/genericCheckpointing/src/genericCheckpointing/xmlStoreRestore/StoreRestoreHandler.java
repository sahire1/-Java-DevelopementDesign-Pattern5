package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.Class;
import genericCheckpointing.util.FileProcessor;
import java.util.ArrayList;
import java.util.List;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MySpecialTypes;
import java.lang.reflect.InvocationTargetException;
import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.SerStrategy;
import genericCheckpointing.util.XMLSerialization;
import genericCheckpointing.util.SerializableObject;
import java.io.FileWriter;

public class StoreRestoreHandler implements InvocationHandler
{
	ArrayList<String> ValuesIn= new ArrayList<String>();
	String Name="";
	SerStrategy XmlSer=new XMLSerialization();
	
	 public void GetOutput(String OutputFileIn)
			{//level=in;
			Name=OutputFileIn;
		//System.out.println(Name);
			}
			
			
	@Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable 
	{
		 // SerializableObject obj = new SerializableObject;
		  Object retobj=new Object();
		  retobj=null;
		  ArrayList<SerializableObject> obj= new ArrayList<SerializableObject>(); //This has serialized classes
		  //
		  if(method.getName().equals("readObj"))
		  {
			//System.out.println("Working");
			  
			  //System.out.println("Working"); Method[] declaredMethods = Whatever.class.getDeclaredMethods();
                //System.out.println(Method.getParameterNames(method));
					
			  
			  
				FileProcessor f=new FileProcessor();
				ValuesIn=f.readfile1();
					
				obj=writetoclass(ValuesIn);
		
			return obj;
			 
				
			  
		  }else if(method.getName().equals("writeObj"))
		  {
			 // System.out.println("Working2");
			
			SerializeData((SerializableObject)args[0],XmlSer,(FileWriter)args[3]);
			
		 }
		  
	   //write readobj and writeobj here
	    return retobj;
	   
    }
	
			
			//FileWriter fw=new FileWriter(NameIn);  
			
	
	
	public void SerializeData(SerializableObject objIn,SerStrategy sIn,FileWriter fw)
	{
		
		
		sIn.processInput(objIn,fw);
		
	}
	
	
	public ArrayList<SerializableObject> writetoclass(ArrayList<String> Values)
{
	//	ArrayList<String> ret = new ArrayList<String>(); 
			//CITED CODE https://www.journaldev.com/709/java-read-file-line-by-line
		
		//int i=0;
		/*
		for(String i:Values)
		{
			System.out.println(i);
		}
		*/
		
		//SerializableObject[] ObjArray = new SerializableObject[100];
		ArrayList<SerializableObject> ObjArray= new ArrayList<SerializableObject>();
		
		int count=0;
		
		 int a=0;
		 long b=0;
		 String c="";
		 boolean d=true;
		 int e=0;
		
		double a2=0;
		 float b2=0;
		 char c2='\0';
		short d2=0;
		
		int a3=0;
		 int b3=0;
		 String c3="";
		 String d3="";
		 double e3=0;
		 double f3=0;
		
		
		
		try {
			
			
			for(String i:Values)
				{
				//System.out.println(i);
				
											String one="genericCheckpointing.util.MyAllTypesFirst";
											String two="genericCheckpointing.util.MyAllTypesSecond";
											String special="genericCheckpointing.util.MySpecialTypes";
											if(i.contains(one))
											{
												int pos=Values.indexOf(i);
												
												//System.out.println(Values.get(pos+4));
												//System.out.println(Values.get(pos+6));
												//System.out.println(Values.get(pos+8));
												//System.out.println(Values.get(pos+10));
												for(int j=pos;j<(pos+10);j++)
												{
													//System.out.println("pos"+j);
													
													//if((j%pos)==0)
													//{
														
														//System.out.println("val j"+Values.get(j));
														switch(Values.get(j))
														{
															case " myInt": a=Integer.parseInt(Values.get(j+1));
															break;
															case " myLong": b=Long.parseLong(Values.get(j+1));
															//System.out.println(b);
															break;
															case " myString": c=Values.get(j+1);
															//System.out.println(c);
															break;
															case " myBool": d=Boolean.parseBoolean(Values.get(j+1));
															//System.out.println(d);
															break;
															case " myOtherInt": e=Integer.parseInt(Values.get(j+1));
															//System.out.println(e);
															break;
															
														}
													//}
												}
												//System.out.println("a"+a);
												/*
												a=Integer.parseInt(Values.get(pos+2));
												b=Long.parseLong(Values.get(pos+4));
												c=Values.get(pos+6);
												d=Boolean.parseBoolean(Values.get(pos+8));
												e=Integer.parseInt(Values.get(pos+10));
												*/
											}
											if(i.contains(two))
											{
												int pos=Values.indexOf(i);
												
												for(int j=pos;j<(pos+8);j++)
												{
													//if((j%pos)==0)
													//{
														switch(Values.get(j))
														{
															case " myDoubleT": a2=Double.parseDouble(Values.get(j+1));
															break;
															case " myFloatT": b2=Float.parseFloat(Values.get(j+1));
															break;
															case " myCharT": c2=Values.get(j+1).charAt(0);
															break;
															case " myShortT": d2=Short.parseShort(Values.get(j+1));
															break;
															
															
														}
													//}
												}
												
												
												
												/*
												int pos =Values.indexOf(i);
												a2=Double.parseDouble(Values.get(pos+2));
												b2=Float.parseFloat(Values.get(pos+4));
												c2=Values.get(pos+6).charAt(0);
												d2=Short.parseShort(Values.get(pos+8));
												*/
												
											}
											if(i.contains(special))
											{
												int pos =Values.indexOf(i);
												
												
												for(int j=pos;j<pos+12;j++)
												{
												//	if((j%pos)==0)
													//{
														switch(Values.get(j))
														{
															case " myInt1": a3=Integer.parseInt(Values.get(j+1));
															break;
															case " myInt2": b3=Integer.parseInt(Values.get(j+1));
															break;
															case " myString1": c3=Values.get(j+1);
															break;
															case " myString2": d3=Values.get(j+1);
															break;
															case " myDoubleT1": e3=Double.parseDouble(Values.get(j+1));
															break;
															case " myDoubleT2": f3=Double.parseDouble(Values.get(j+1));
															break;
															
															
														}
													//}
												}
												/*
												a3=Integer.parseInt(Values.get(pos+2));
												b3=Integer.parseInt(Values.get(pos+4));
												c3=Values.get(pos+6);
												d3=Values.get(pos+8);
												e3=Double.parseDouble(Values.get(pos+10));
												f3=Double.parseDouble(Values.get(pos+12));
												*/
												
											}
											
											
				
				}
			
			
				for(String i:Values)
				{
					//System.out.println(i);
					
											Class<?> targetClass;
											Object classInstance;
											//Method meth
											String one="genericCheckpointing.util.MyAllTypesFirst";
											String two="genericCheckpointing.util.MyAllTypesSecond";
											String special="genericCheckpointing.util.MySpecialTypes";
											if(i.contains(one))
											{
												//System.out.println("i1"+i);
												i=i.substring(1,i.length()-1);
												//System.out.println("i"+i);
												targetClass = Class.forName(i);
												classInstance = targetClass.newInstance();
												//System.out.println("targetClass"+targetClass);
												//MyAllTypesFirst temp=new MyAllTypesFirst();
												//reflection_code(temp);
												//MyAllTypesFirst temp=new MyAllTypesFirst(a,b,c,d,e);
												//Class cls = MyAllTypesFirst.class;
												//ObjArray[count++]=(SerializableObject)classInstance;
												ObjArray.add((SerializableObject)classInstance);
												
												Method m = targetClass.getMethod("set_a", int.class);
												//System.out.println("Setting value of n to 10...");
												m.invoke(classInstance,a);
												
												
												
												Method m5 = targetClass.getMethod("get_a");
												//System.out.println("getN() -> " + (int) m5.invoke(classInstance));
			
												Method m1 = targetClass.getMethod("set_b", long.class);
												//System.out.println("Setting value of n to 10...");
												m1.invoke(classInstance,b);
												
												Method m6 = targetClass.getMethod("get_b");
												//System.out.println("getN() -> " + (long) m6.invoke(classInstance));
												
												Method m2 = targetClass.getMethod("set_c", String.class);
												//System.out.println("Setting value of n to 10...");
												m2.invoke(classInstance,c);
												
												Method m7 = targetClass.getMethod("get_c");
												//System.out.println("getN() -> " + (String) m7.invoke(classInstance));
												
												Method m3 = targetClass.getMethod("set_d", boolean.class);
												//System.out.println("Setting value of n to 10...");
												m3.invoke(classInstance,d);
												
												Method m8 = targetClass.getMethod("get_d");
												//System.out.println("getN() -> " + (boolean) m8.invoke(classInstance));
												
												Method m4 = targetClass.getMethod("set_e", int.class);
												//System.out.println("Setting value of n to 10...");
												m4.invoke(classInstance,e);
												
												Method m9 = targetClass.getMethod("get_e");
												//System.out.println("getN() -> " + (int) m9.invoke(classInstance));
												
										   }
											else  if(i.equals(two))
											{
												//MyAllTypesSecond temp=new MyAllTypesSecond(a,b,c,d,e,a2,b2,c2,d2);
												//Class cls = MyAllTypesSecond.class;
												//ObjArray[count++]=temp;
												i=i.substring(1,i.length()-1);
						
												targetClass = Class.forName(i);
												classInstance = targetClass.newInstance();
												//ObjArray[count++]=(SerializableObject)classInstance;
												ObjArray.add((SerializableObject)classInstance);
												Method m = targetClass.getMethod("set_a2", double.class);
												//System.out.println("Setting value of n to 10...");
												m.invoke(classInstance,a2);
												
												Method m4 = targetClass.getMethod("get_a2");
												//System.out.println("getN() -> " + (double) m4.invoke(classInstance));
												
												
												Method m1 = targetClass.getMethod("set_b2", float.class);
												//System.out.println("Setting value of n to 10...");
												m1.invoke(classInstance,b2);
												
												Method m5 = targetClass.getMethod("get_b2");
												//System.out.println("getN() -> " + (float) m5.invoke(classInstance));
												
												Method m2 = targetClass.getMethod("set_c2", char.class);
												//System.out.println("Setting value of n to 10...");
												m2.invoke(classInstance,c2);
												
												Method m6 = targetClass.getMethod("get_c2");
												//System.out.println("getN() -> " + (char) m6.invoke(classInstance));
												
												
												Method m3 = targetClass.getMethod("set_d2", short.class);
												//System.out.println("Setting value of n to 10...");
												m3.invoke(classInstance,d2);
												
												Method m7 = targetClass.getMethod("get_d2");
												//System.out.println("getN() -> " + (short) m7.invoke(classInstance));
												
											
												
												
											}
											else if(i.contains(special))
											{
											i=i.substring(1,i.length()-1);
											//System.out.println("i3"+i);
											targetClass = Class.forName(i);
												classInstance = targetClass.newInstance();
											
											//MySpecialTypes temp=new MySpecialTypes(a3,b3,c3,d3,e3,f3);
												//Class cls = MySpecialTypes.class;
												//ObjArray[count++]=temp;
											
											 //ObjArray[count++]=(SerializableObject)classInstance;										
												ObjArray.add((SerializableObject)classInstance);
												Method m = targetClass.getMethod("set_a3", int.class);
												//System.out.println("Setting value of n to 10...");
												m.invoke(classInstance,a3);
												
												Method m7 = targetClass.getMethod("get_a3");
												//System.out.println("getN() -> " + (int) m7.invoke(classInstance));
												
												
												Method m1 = targetClass.getMethod("set_b3", int.class);
												//System.out.println("Setting value of n to 10...");
												m1.invoke(classInstance,b3);
												
												Method m8 = targetClass.getMethod("get_b3");
												//System.out.println("getN() -> " + (int) m8.invoke(classInstance));
												
												Method m2 = targetClass.getMethod("set_c3", String.class);
												//System.out.println("Setting value of n to 10...");
												m2.invoke(classInstance,c3);
												
												Method m9 = targetClass.getMethod("get_c3");
												//System.out.println("getN() -> " + (String) m9.invoke(classInstance));
												
												Method m3 = targetClass.getMethod("set_d3", String.class);
												//System.out.println("Setting value of n to 10...");
												m3.invoke(classInstance,d3);
												
												Method m10 = targetClass.getMethod("get_d3");
												//System.out.println("getN() -> " + (String) m10.invoke(classInstance));
												
												Method m4 = targetClass.getMethod("set_e3", double.class);
												//System.out.println("Setting value of n to 10...");
												m4.invoke(classInstance,e3);
												
												Method m11 = targetClass.getMethod("get_e3");
												//System.out.println("getN() -> " + (double) m11.invoke(classInstance));
												
												Method m5 = targetClass.getMethod("set_f3", double.class);
												//System.out.println("Setting value of n to 10...");
												m5.invoke(classInstance,f3);
											
												Method m12 = targetClass.getMethod("get_f3");
												//System.out.println("getN() -> " + (double) m12.invoke(classInstance));
											}
					
					
				}
				
				
				
			}
			catch (NoSuchMethodException e4) {
					MyLogger ml=new MyLogger();
					ml.setDebugValue(1);
					ml.writeMessage(" NO SUCH METHOD EXISTS ",MyLogger.DebugLevel.NoSuchMethodException);
			

		   //e4.printStackTrace();
			} catch (IllegalAccessException e2) {
          //e2.printStackTrace();
		  MyLogger ml=new MyLogger();
					ml.setDebugValue(2);
					ml.writeMessage(" ILLEGAL ACTION ",MyLogger.DebugLevel.IllegalAccessException);
					e2.printStackTrace();
			
        }
		catch(InvocationTargetException e4)
		{
	
	 MyLogger ml=new MyLogger();
					ml.setDebugValue(6);
					ml.writeMessage(" InvocationTargetException ",MyLogger.DebugLevel.InvocationTargetException);
			e4.printStackTrace();
		}
		catch(ClassNotFoundException exep)
		{
			MyLogger ml=new MyLogger();
					ml.setDebugValue(7);
					ml.writeMessage(" Class not found ",MyLogger.DebugLevel.ClassNotFoundException);
					exep.printStackTrace();
		}
		catch(InstantiationException execc)
		{
				 MyLogger ml=new MyLogger();
					ml.setDebugValue(8);
					ml.writeMessage(" Instantiation not exits ",MyLogger.DebugLevel.InstantiationException);
					execc.printStackTrace();
					
		}
		finally
		{
			
		}
		
		return ObjArray;
		
		
	}

	

	
	

}