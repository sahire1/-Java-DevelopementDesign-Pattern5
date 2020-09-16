
// FIXME: replace XYZ with the package name for the assignment
package genericCheckpointing.util;

public class MyLogger{

    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { IllegalAccessException,DesererMode,InstantiationException,FILE_PROCESSOR ,EMPTY_INPUT,NoSuchMethodException,InvocationTargetException,ClassNotFoundException,Results, Boundary, FileDoesNotExists
                                   };

    private static DebugLevel debugLevel;


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 2: debugLevel = DebugLevel.IllegalAccessException; break;
	case 4: debugLevel = DebugLevel.FILE_PROCESSOR; break;
	case 3: debugLevel = DebugLevel.EMPTY_INPUT;break;
	case 1: debugLevel = DebugLevel.NoSuchMethodException;break;
	case 5: debugLevel = DebugLevel.FileDoesNotExists;break;
	case 6: debugLevel = DebugLevel.InvocationTargetException;break;
	case 7: debugLevel = DebugLevel.ClassNotFoundException;break;
	case 8: debugLevel = DebugLevel.InstantiationException;break;
	case 9: debugLevel = DebugLevel.DesererMode;break;

	//default: debugLevel = DebugLevel.NONE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}