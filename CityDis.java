//输入城市间距离，输出查询的两城市距离，注意Scanner的使用
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class CityDis {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		City citys = new City();
		citys.InputCity();
		citys.MakeMap();
		System.out.println(citys.getDis());
	}

}
class City{
	public int size = 0;
	public HashMap<String, Integer> city= new HashMap<String, Integer> ();
	public ArrayList<ArrayList<Integer>> dismap= new ArrayList<ArrayList<Integer>>();
	public Scanner in = new Scanner(System.in);
	public void InputCity(){
		String s = "";
		//Scanner in = new Scanner(System.in);
		int cnt = 0;
		///String flag = "###";
		s = in.next();
		while(s.equals("###") == false){
			if(s.equals("Huzhou")){s = "Suzhou";}
			city.put(s, cnt++);
			s = in.next();
		}
		size = city.size();
	}
	
	public void MakeMap(){
		//Scanner in = new Scanner(System.in);
		int dis = 0;
		for(int i=0; i < size; i++){
			dismap.add(new ArrayList<Integer>());
			for(int j=0; j < size; j++){
				dis = in.nextInt();
				dismap.get(i).add(dis);
			}
			//in.nextLine();
		}
	}
	
	public int getDis(){
		String  c1, c2;

		c1 = in.next();
		if(c1.equals("Huzhou")){c1 = "Suzhou";}
		c2 = in.next();
		if(c2.equals("Huzhou")){c2 = "Suzhou";}

		return dismap.get(city.get(c1)).get(city.get(c2));
	}
	
}
