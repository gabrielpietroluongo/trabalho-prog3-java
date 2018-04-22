package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class CSVLoader
{
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
			while((line = br.readLine()) != null)
			{
				String [] line_data;
				line_data = CSVLoader.parse(line, ";");
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
	
}
