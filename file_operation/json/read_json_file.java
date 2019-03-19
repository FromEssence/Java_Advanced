/**
 * read from test.json, then get all <key, value> pairs
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.json.*;
public class JsonFileOperation {
	
	//测试
	public static void main(String args[]) throws IOException {
		File file = new File("test.json");
		String modified = "";
		try(FileReader reader=new FileReader(file)){
			int fileLen = (int) file.length();
			char[] chars = new char[fileLen];
			reader.read(chars);
			String s = String.valueOf(chars);
			JSONObject jsonObject = new JSONObject(s);
			modified = jsonObject.toString();
			//start resolute
			JSONArray infos = jsonObject.getJSONArray("other");

			Iterator<String> keys = jsonObject.keys();//get all keys
			while(keys.hasNext()) { //get all values
			    String key = keys.next();
			    System.out.print(key+":");
			    System.out.println(jsonObject.get(key));
			}//while
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//write to another json file
		String Path="hhh.json";
		FileOutputStream fos= new FileOutputStream(Path);
		OutputStreamWriter os= new OutputStreamWriter(fos);
		BufferedWriter w= new BufferedWriter(os);
		w.write(modified);
		w.close();
		return;
	}
}
