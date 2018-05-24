package util;

import java.io.*;
import java.util.Vector;

public abstract class CSV
{	
	private static Writer wr;
	
	private static boolean allowStreamOpening = true;
	
	public static void setOutputFile(String path) throws IOException
	{
		if(!allowStreamOpening) return;
		wr = new FileWriter(path);
	}
	
	public static void closeOutputFile() throws IOException
	{
		wr.flush();
		wr.close();
		return;
	}
	
	public static String[] parse(String data,String separator)
	{
		String[] parsedData;
		parsedData = data.split(separator);
		return parsedData;
	}
	
	public static Vector<String[]> load_data(String file)
	{
		Vector<String[]> lines = new Vector<String[]>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			// Pula a 1ª linha do csv
			br.readLine();
			while((line = br.readLine()) != null)
			{
				String [] line_data;
				line_data = CSV.parse(line, ";");
				lines.addElement(line_data);
			}
			br.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void save(String[] data) throws IOException
	{
		for (String s : data)
		{
			wr.write(s);
			//Write separators, except if it is the last element
			if(s != data[data.length-1])
				wr.write(";");
			else
				wr.write("\n");
		}
	}
	
}
