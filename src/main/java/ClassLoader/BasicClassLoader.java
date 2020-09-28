package ClassLoader;

import java.util.ArrayList;
import java.util.logging.Logger;

public class BasicClassLoader {

	public static void main(String[] args) {
		System.out.println("ClassLoader of this class : "+BasicClassLoader.class.getClassLoader());
		System.out.println("ClassLoader of sun.javafx.binding.Logging class : "+Logger.class.getClassLoader());
		System.out.println("ClassLoader of ArrayList class : "+ArrayList.class.getClassLoader());

	}

}
