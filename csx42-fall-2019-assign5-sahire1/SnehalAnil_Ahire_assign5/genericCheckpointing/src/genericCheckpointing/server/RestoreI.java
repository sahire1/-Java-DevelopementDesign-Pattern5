package genericCheckpointing.server;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;


public interface RestoreI extends StoreRestoreI
{

		ArrayList<SerializableObject> readObj(String input);
}