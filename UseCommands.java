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
	
	/**
	 * Calculations done with two integer inputs. 
	 * The method used is loaded from the jar file indicated from the {@link LoadJarClass} file.
	 * @param cmd the command desired to be used
	 * @param arg1 first integer argument
	 * @param arg2 second integer argument
	 * @return resulting integer argument
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	
	/**
	 * Calculations done with one integer input
	 * The method used is loaded from the jar file indicated from the {@link LoadJarClass} file
	 * @param cmd the command desired to be used
	 * @param arg1 integer argument
	 * @return resulting integer argument
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	
	/**
	 * Calculations done with two float inputs
	 * The method used is loaded from the jar file indicated from the {@link LoadJarClass} file
	 * @param cmd the command desired to be used
	 * @param arg1 first float argument
	 * @param arg2 second float argument
	 * @return resulting float argument
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	
	/**
	 * Calculations done with one float input.
	 * The method used is loaded from the jar file indicated from the {@link LoadJarClass} file
	 * @param cmd the command desired to be used
	 * @param arg1 float argument
	 * @return resulting float argument
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	
	/**
	 * Calculations done with two string inputs.
	 * The method used is loaded from the jar file indicated from the {@link LoadJarClass} file
	 * @param cmd the command desired to be used
	 * @param arg1 first string argument
	 * @param arg2 second string argument
	 * @return resulting string argument
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	
	/**
	 * String count method that will be loaded from the jar file indicated from the {@link LoadJarClass} file
	 * @param cmd probably the length command
	 * @param arg1 the string of which we wish to retrieve the length of
	 * @return the length of the string
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
