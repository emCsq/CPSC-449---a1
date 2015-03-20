package a2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LoadJarClass {
	
	private Class<?> loadedClass;
	
	/**
	 * Loads .jar file so that classes can be accessed from it
	 * Loads classes that exist in the .jar file
	 * Loaded class can be used to access the methods within that class
	 * 
	 * @param fileName name of the jar file
	 * @param className name of the class within the jar file
	 * @throws MalformedURLException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void loadJC(String fileName, String className) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String fileStrName = fileName;
		File file = new File(fileStrName);   
		  
		URL jarFilePath = new URL("jar", "","file:" + file.getAbsolutePath()+"!/");    

		String classStrName = className; 
		
		URLClassLoader cLoader = URLClassLoader.newInstance(new URL[] { jarFilePath });   
		loadedClass = cLoader.loadClass(classStrName);	
	}
	
	/**
	 * Provides access to the loadedClass instance. 
	 * Purpose is to get the methods from the loaded class
	 * @return methods from the loaded class
	 */
	public Class<?> getLoadedClass() {
		return loadedClass;
	}

}
