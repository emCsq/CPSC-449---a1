package a2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/*
 * Purpose of class:
 * Loads .jar file so that classes can be accessed from it
 * Loads classes that exist in the .jar file
 * 	Loaded class can be used to access the methods within that class
 */

public class LoadJarClass {
	
	private Class<?> loadedClass;
	
	public void loadJC(String fileName, String className) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String fileStrName = fileName;
		File file = new File(fileStrName);   
		  
		URL jarFilePath = new URL("jar", "","file:" + file.getAbsolutePath()+"!/");    

		String classStrName = className; 
		
		URLClassLoader cLoader = URLClassLoader.newInstance(new URL[] { jarFilePath });   
		loadedClass = cLoader.loadClass(classStrName);	
	}
	
	//Access to the loadedClass instance
	//Used to get the methods from the loaded class
	public Class<?> getLoadedClass() {
		return loadedClass;
	}

}
