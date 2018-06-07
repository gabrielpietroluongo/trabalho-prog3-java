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
	
	public static Vector<String[]> loadData(String file) throws IOException
	{
		Vector<String[]> lines = new Vector<String[]>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		// Pula a 1ª linha do csv
		br.readLine();
		while((line = br.readLine()) != null)
		{
			String [] line_data;
			line_data = CSV.parse(line, ";");
			for(int i = 0; i < line_data.length; i++)
			{
				if(line_data[i].equals(" "))
					continue;
				line_data[i] = line_data[i].trim();
			}
			lines.addElement(line_data);
		}
		br.close();
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
