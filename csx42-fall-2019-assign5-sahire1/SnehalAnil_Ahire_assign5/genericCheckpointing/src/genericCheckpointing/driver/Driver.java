
package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyLogger;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import genericCheckpointing.util.FwCreator;
// import the other types used in this file

public class Driver {
    
   public static void main(String[] args) {
	
	// FIXME: read the value of checkpointFile from the command line
	
	
	
	if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}")  ) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 1 argumnets.");
			System.exit(0);
		}
	try
	{
		if(args[0].equals("deserser"))
		{
			
			
		}
		else
			throw new Exception();
	}
	catch (Exception excep) 
				{
					//excep.printStackTrace(); 
				//	System.out.println("deserser in mode is absent");
					//System.exit(0);
					
					MyLogger ml=new MyLogger();
					ml.setDebugValue(9);
					ml.writeMessage(" deserser in mode is absent ",MyLogger.DebugLevel.DesererMode);
				}
				finally
				{
					
				}
				
	ProxyCreator pc = new ProxyCreator();
	
	List<String> ValuesIn= new ArrayList<String>();
	
				FileProcessor f=new FileProcessor();
				//FileProcessor fp=new FileProcessor();
				f.set_input_file(args[1]);
				
				//trying
				//f.readfile_lines(args[0]);
		
				ValuesIn=f.readfile1();
				
				/*
				for(String i:ValuesIn)
				{
					System.out.println(i);
				}
				*/
				
				//int countIn=
				//f.writetoclass(ValuesIn);
					
	// create an instance of StoreRestoreHandler (which implements the InvocationHandler
	
	// create a proxy
	
	try{
			FileWriter fw=new FileWriter(args[2]);
			
	
	StoreRestoreHandler h=new StoreRestoreHandler();
			h.GetOutput(args[2]);
	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 h
								 );
		
		
		
	// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

	
	MyAllTypesFirst myFirst;
	MyAllTypesSecond  mySecond;
	MySpecialTypes  mySpecialT;
	
	
	//SerializableObject[] myRecordRet=new SerializableObject[100];

	List<SerializableObject> myRecordRet=null;
		//trying to fix in fileprocessor
		

	// read in a loop till the end of file is indicated
//do not comment this     

	myRecordRet = ((RestoreI) cpointRef).readObj("XML");
	//FwCreator fw=new FwCreator();
	//FileWriter fw1=fw.fwwriter(args[2]);

	//h.invoke();
	// FIXME: store myRecordRet in a data structure

	
	// NUM_OF_OBJECTS is the size of the data strucutre in which the objects have been saved
	
	//FileWriter fw1=fwwriter();
	
	
	for (int i=0; i<myRecordRet.size(); i++) {

	    // use "instance of" to determine which of these methods should be called
	    // use this method for MyAllTypesFirst and MyAllTypesSecond.
		
		if(myRecordRet.get(i) instanceof MyAllTypesFirst)
		{
			  ((StoreI) cpointRef).writeObj((MyAllTypesFirst)myRecordRet.get(i),"XML",args[2],fw);
		}
	  else{
	    // use this method for MySpecialTypes
	    ((StoreI) cpointRef).writeObj((MySpecialTypes)(myRecordRet.get(i)), "XML",args[2],fw);
	  }
	}


	// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

    
    }
			catch(IOException i)
			{
				i.printStackTrace();
			}
   }
	
}
