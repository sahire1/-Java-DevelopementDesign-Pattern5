package genericCheckpointing.util;
import java.io.FileWriter;

public interface SerStrategy {
	
   public void processInput(SerializableObject sObject,FileWriter NameIn);

}
