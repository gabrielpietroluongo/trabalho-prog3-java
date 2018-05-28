package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Serialization 
{	
	public static void saveData(String file, Object o) throws IOException
	{
		FileOutputStream fout = new FileOutputStream(file, true);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(o);
		oos.close();
	}
	
	public static Object loadData(String file) throws IOException, ClassNotFoundException
	{
		FileInputStream streamIn = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(streamIn);
		Object ret = ois.readObject();
		ois.close();
		return ret;
	}
	
}
