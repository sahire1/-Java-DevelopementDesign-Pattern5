package genericCheckpointing.util;
 
import java.lang.reflect.Field;
import java.io.IOException;
import java.io.FileWriter;

public class XMLSerialization implements SerStrategy {
    
	
			
	
	
     public void processInput(SerializableObject sObject,FileWriter fwIn) 
	 {

      // all the code to create the output file with XML snippets for
      // an object
	 // if(sObject is)
		 //System.out.println("hi");
	 
			
			try{
			  Class<?> clasName=sObject.getClass();
			  
			  Field[] fieldList=clasName.getDeclaredFields();
			    
			  
				//System.out.println(NameIn);
				//FileWriter fw=new FileWriter(NameIn);   
				fwIn.write("<DPSerialization>");
				//clasName=clasName.replace("class ","");
				fwIn.write("<complexType xsi:type="+clasName+"\n");
				
				for(int j=0;j<fieldList.length;j++)
			  {
				  Class<?> fieldClass=fieldList[j].getType();
				  //System.out.println("fieldClass	"+fieldClass);
				  String fieldName=fieldList[j].getName();
				  //System.out.println("fieldName	"+fieldName);

				  Object fieldObject=fieldList[j].get(sObject);
				  //System.out.println("fieldObject	"+fieldObject);
				  
											String one="class genericCheckpointing.util.MyAllTypesFirst";
											String two="class genericCheckpointing.util.MyAllTypesSecond";
											String special="class genericCheckpointing.util.MySpecialTypes";
											//if(clasName.equals(one))
											//{
												switch(fieldName)
														{
															case "a": fwIn.write("<myInt xsi:type="+"xsd:int"+">"+fieldObject+"</myInt>"+"\n");
															break;
															case "b": fwIn.write("<myLong xsi:type="+"xsd:long"+">"+fieldObject+"</myLong>"+"\n");
															//System.out.println(b);
															break;
															case "c": fwIn.write("<myString xsi:type="+"xsd:string"+">"+fieldObject+"</myString>"+"\n");
															//System.out.println(c);
															break;
															case "d": fwIn.write("<myBool xsi:type="+"xsd:boolean"+">"+fieldObject+"</myBool>"+"\n");
															//System.out.println(d);
															break;
															case "e": fwIn.write("<myOtherInt xsi:type="+"xsd:int"+">"+fieldObject+"</myOtherInt>"+"\n");
															//System.out.println(e);
															break;
															
														//}
											//}
											//if(clasName.equals(two))
											//{
												//switch(fieldName)
													//	{
															case "a2":fwIn.write("<myDoubleT xsi:type="+"xsd:double"+">"+fieldObject+"</myDoubleT>"+"\n");
															break;
															case "b2":fwIn.write("<myFloatT xsi:type="+"xsd:float"+">"+fieldObject+"</myFloatT>"+"\n");
															break;
															case "d2":fwIn.write("<myShortT xsi:type="+"xsd:short"+">"+fieldObject+"</myShortT>"+"\n");
															break;
															case "c2":fwIn.write("<myCharT xsi:type="+"xsd:char"+">"+fieldObject+"</myCharT>"+"\n");
															break;
															
															
														//}
											//}
											//if(clasName.equals(special))
											//{
												//switch(fieldName)
													//	{
															case "a3":fwIn.write("<myInt1 xsi:type="+"xsd:int"+">"+fieldObject+"</myInt1>"+"\n");
															break;
															case "b3":fwIn.write("<myInt2 xsi:type="+"xsd:int"+">"+fieldObject+"</myInt2>"+"\n");
															break;
															case "c3":fwIn.write("<myString1 xsi:type="+"xsd:string"+">"+fieldObject+"</myString1>"+"\n");
															break;
															case "d3":fwIn.write("<myString2 xsi:type="+"xsd:string"+">"+fieldObject+"</myString2>"+"\n");
															break;
															case "e3":fwIn.write("<myDoubleT1 xsi:type="+"xsd:double"+">"+fieldObject+"</myDoubleT1>"+"\n");
															break;
															case "f3":fwIn.write("<myDoubleT2 xsi:type="+"xsd:double"+">"+fieldObject+"</myDoubleT2>"+"\n"); 
															break;
															
															
														//}
											}
			  }  
				
				fwIn.write("</DPSerialization>");
			
				fwIn.close();    
		    }catch(IllegalAccessException | IOException exec)
			{
				   MyLogger ml=new MyLogger();
					ml.setDebugValue(1);
					ml.writeMessage(" NO SUCH METHOD EXISTS ",MyLogger.DebugLevel.IllegalAccessException);
				exec.printStackTrace();
			}

   }
}
