package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MySpecialTypes;
import java.io.FileWriter;

public interface StoreI extends StoreRestoreI
{
	 void writeObj(MyAllTypesFirst aRecord, String wireFormat,String name,FileWriter fw);
      void writeObj(MySpecialTypes sRecord, String wireFormat,String name,FileWriter fw);



}