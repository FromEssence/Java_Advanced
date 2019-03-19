/**
 * 封装对json文件的常用操作
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javafx.util.Pair;
import sun.security.util.PropertyExpander.ExpandException;
public class JsonFileOperation {
	
	private JSONObject jsonObject = null; //store resolved json pairs
	
	JsonFileOperation(String fname) {
		File file = new File(fname);
		try(FileReader reader=new FileReader(file)){
			int fileLen = (int) file.length();
			char[] chars = new char[fileLen];
			reader.read(chars);
			String s = String.valueOf(chars);
			jsonObject = new JSONObject(s);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getAllPairs(ArrayList<Pair<String, String> > pr) {
		
		//start resolute
		try{
			Iterator<String> keys = jsonObject.keys();//得到所有键值
			while(keys.hasNext()) {
			    String key = keys.next();
			    pr.add(new Pair<String, String>(key, jsonObject.get(key).toString()));
//			    System.out.print(key+":");
//			    System.out.println(jsonObject.get(key));
			}//while
			
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}

	}
	
	public int writeToFile(String fPath) {
		
		try{
			FileOutputStream fos= new FileOutputStream(fPath);
			OutputStreamWriter os= new OutputStreamWriter(fos);
			BufferedWriter w= new BufferedWriter(os);
			w.write(jsonObject.toString());
			w.close();
			return 0;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	//测试
	public static void main(String args[]) throws IOException {
		JsonFileOperation jsonOpera = new JsonFileOperation("res.json");
		ArrayList<Pair<String, String> > prs = new ArrayList<>();
		jsonOpera.getAllPairs(prs);
		System.out.println(prs.get(0).getKey()+":"+ prs.get(0).getValue());
		jsonOpera.writeToFile("hhh.json");
	}
}
