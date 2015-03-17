package a2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/*
 * Purpose of class:
 * Loads .jar file so that classes can be accessed from it
 */

public class LoadJarClass {

	
	public static void load(String fileName, String className) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String fileStrName = fileName;
		File file = new File(fileStrName);   
		String classStrName = className;   
		URL jarFilePath = new URL("jar", "","file:" + file.getAbsolutePath()+"!/");    
		URLClassLoader cl = URLClassLoader.newInstance(new URL[] { jarFilePath });   
		Class<?> loadedClass = cl.loadClass(classStrName);  
		//see the class you have loaded
		//System.out.println(loadedClass.toString());

		//ACCESS TO ADDITION METHODS
		//Access to string add method
		Method strAddMethod = loadedClass.getMethod("add", new Class[]{ String.class, String.class });
		//System.out.println(strAddMethod.toString());
		//Example string numbers to load
		String[] strAddParams = new String[]{ new String("2"), new String("2") };
		//since it's a static method, the first argument is null
		Object strAddResult = strAddMethod.invoke(null, strAddParams);
		System.out.println(strAddResult);
	
		
		//Access to float add method
		Method fltAddMethod = loadedClass.getMethod("add", new Class[]{ Float.TYPE, Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltAddParams = new Float[]{ new Float(2.0), new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltAddResult = fltAddMethod.invoke(null, fltAddParams);
		System.out.println(fltAddResult); 
		
		//Access to integer add method
		Method intAddMethod = loadedClass.getMethod("add", new Class[]{ Integer.TYPE, Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intAddParams = new Integer[]{ new Integer(2), new Integer(2) };
		//since it's a static method, the first argument is null
		Object intAddResult = intAddMethod.invoke(null, intAddParams);
		System.out.println(intAddResult);
		
		
		//ACCESS TO SUBTRACTION METHODS
		//Access to float sub method
		Method fltSubMethod = loadedClass.getMethod("sub", new Class[]{ Float.TYPE, Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltSubParams = new Float[]{ new Float(2.0), new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltSubResult = fltSubMethod.invoke(null, fltSubParams);
		System.out.println(fltSubResult); 
		
		//Access to integer sub method
		Method intSubMethod = loadedClass.getMethod("sub", new Class[]{ Integer.TYPE, Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intSubParams = new Integer[]{ new Integer(2), new Integer(2) };
		//since it's a static method, the first argument is null
		Object intSubResult = intSubMethod.invoke(null, intSubParams);
		System.out.println(intSubResult);
		
		
		//ACCESS TO DIVISION METHODS
		//Access to float div method
		Method fltDivMethod = loadedClass.getMethod("div", new Class[]{ Float.TYPE, Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltDivParams = new Float[]{ new Float(2.0), new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltDivResult = fltDivMethod.invoke(null, fltDivParams);
		System.out.println(fltDivResult); 
		
		//Access to integer div method
		Method intDivMethod = loadedClass.getMethod("div", new Class[]{ Integer.TYPE, Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intDivParams = new Integer[]{ new Integer(2), new Integer(2) };
		//since it's a static method, the first argument is null
		Object intDivResult = intDivMethod.invoke(null, intDivParams);
		System.out.println(intDivResult);
		
		
		//ACCESS TO MULTIPLICATION METHODS
		//Access to float mul method
		Method fltMulMethod = loadedClass.getMethod("mul", new Class[]{ Float.TYPE, Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltMulParams = new Float[]{ new Float(2.0), new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltMulResult = fltMulMethod.invoke(null, fltMulParams);
		System.out.println(fltMulResult); 
		
		//Access to integer mul method
		Method intMulMethod = loadedClass.getMethod("mul", new Class[]{ Integer.TYPE, Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intMulParams = new Integer[]{ new Integer(2), new Integer(2) };
		//since it's a static method, the first argument is null
		Object intMulResult = intMulMethod.invoke(null, intMulParams);
		System.out.println(intMulResult);
		
		
		//ACCESS TO INCREMENT METHODS
		//Access to float inc method
		Method fltIncMethod = loadedClass.getMethod("inc", new Class[]{ Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltIncParams = new Float[]{ new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltIncResult = fltIncMethod.invoke(null, fltIncParams);
		System.out.println(fltIncResult); 
		
		//Access to integer inc method
		Method intIncMethod = loadedClass.getMethod("inc", new Class[]{ Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intIncParams = new Integer[]{ new Integer(2) };
		//since it's a static method, the first argument is null
		Object intIncResult = intIncMethod.invoke(null, intIncParams);
		System.out.println(intIncResult);
		
		
		//ACCESS TO DECREMENT METHODS
		//Access to float dec method
		Method fltDecMethod = loadedClass.getMethod("dec", new Class[]{ Float.TYPE });
		//System.out.println(method_mul.toString());
		//Example float numbers to load
		Float[] fltDecParams = new Float[]{ new Float(2.0) };
		//since it's a static method, the first argument is null
		Object fltDecResult = fltDecMethod.invoke(null, fltDecParams);
		System.out.println(fltDecResult); 
		
		//Access to integer inc method
		Method intDecMethod = loadedClass.getMethod("dec", new Class[]{ Integer.TYPE });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		Integer[] intDecParams = new Integer[]{ new Integer(2) };
		//since it's a static method, the first argument is null
		Object intDecResult = intDecMethod.invoke(null, intDecParams);
		System.out.println(intDecResult);
		
		
		//ACCESS TO LENGTH OF STRING METHOD
		Method strLenMethod = loadedClass.getMethod("len", new Class[]{ String.class });
		//System.out.println(method_mul.toString());
		//Example integer numbers to load
		String[] strLenParams = new String[]{ new String("testing") };
		//since it's a static method, the first argument is null
		Object strLenResult = strLenMethod.invoke(null, strLenParams);
		System.out.println(strLenResult);
	
	}
}
