package threadAbout;
import java.util.Scanner;
public class ThreadDemo_2 {

	public static void main(String[] args) {
		final Mydata d1 = new Mydata();
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("Hurry");
					try {
						Thread.sleep(2000);
						d1.add();
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
		};//r1
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("请设置：");
					Scanner in = new Scanner(System.in);
					int p = in.nextInt();
					
					d1.setData(p);
				}
				
			}
		};//r2
		
		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r2);
		thr1.start();
		thr2.start();
	}
	
	

}

class Mydata{
	private int j = 0;
	public synchronized void add() {
		j++;
		System.out.println("线程"+Thread.currentThread().getName()+"j为"+j);
	}
	
	public synchronized void setData(int num) {
		j = num;
		System.out.println("线程"+Thread.currentThread().getName()+"j设置为"+j);
	}
}
