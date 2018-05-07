package util;

import java.io.*;
import java.util.Vector;

public class CSV
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
	
	public static void save(String file, String[] data) throws IOException
	{
		OutputStream os = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		for (String s : data)
		{
			bw.write(s);
			//Write separators, except if it is the last element
			if(s != data[data.length])
				bw.write(";");
		}
		bw.close();
	}
	
}
