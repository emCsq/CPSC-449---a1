package a2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * Purpose of class:
 * Gets the specific method that is in the loaded class instance
 * Executes the specific method called by the instance with the particular parameters needed
 * This is used in ProcessMethods()
 */

public class UseCommands {
	
	public static LoadJarClass loadedJC;
	
	public UseCommands() {
		loadedJC = new LoadJarClass();
	}
	
	public int useTwoIntCommand(String cmd, int arg1, int arg2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method intMethod = loadedClass.getMethod(cmd, new Class[]{ Integer.TYPE, Integer.TYPE });
		//Parameters for the method
		int[] intParams = {arg1, arg2};
		//Static method -> first argument is always null
		Object intResult = intMethod.invoke(null, intParams);
		
		return (int) intResult;
		
	}
	
	public int useOneIntCommand(String cmd, int arg1) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method intMethod = loadedClass.getMethod(cmd, new Class[]{ Integer.TYPE });
		//Parameters for the method
		int[] intParams = {arg1};
		//Static method -> first argument is always null
		Object intResult = intMethod.invoke(null, intParams);
		
		return (int) intResult;
		
	}
	
	public float useTwoFltCommand(String cmd, float arg1, float arg2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method fltMethod = loadedClass.getMethod(cmd, new Class[]{ Float.TYPE, Float.TYPE });
		//Parameters for the method
		float[] fltParams = {arg1, arg2};
		//Static method -> first argument is always null
		Object fltResult = fltMethod.invoke(null, fltParams);
		
		return (float) fltResult;
		
	}
	
	public float useOneFltCommand(String cmd, float arg1) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method fltMethod = loadedClass.getMethod(cmd, new Class[]{ Float.TYPE });
		//Parameters for the method
		float[] fltParams = {arg1};
		//Static method -> first argument is always null
		Object fltResult = fltMethod.invoke(null, fltParams);
		
		return (float) fltResult;
		
	}
	
	public String useStrCommand(String cmd, String arg1, String arg2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method strMethod = loadedClass.getMethod(cmd, new Class[]{ String.class, String.class });
		//Parameters for the method
		String[] strParams = {arg1, arg2};
		//Static method -> first argument is always null
		Object strResult = strMethod.invoke(null, (Object) strParams);
		
		return (String) strResult;
		
	}
	
	public int useLenCommand(String cmd, String arg1) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<?> loadedClass = loadedJC.getLoadedClass();
		
		//Access to the method
		Method lenMethod = loadedClass.getMethod(cmd, new Class[]{ String.class });
		//Parameters for the method
		String[] lenParams = {arg1};
		//Static method -> first argument is always null
		Object lenResult = lenMethod.invoke(null, (Object) lenParams);
		
		return (int) lenResult;
		
	}
}
