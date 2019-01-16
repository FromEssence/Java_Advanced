package threadAbout;

import java.util.Scanner;

public class ThreadDemo {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while(true) {
					try {
						System.out.println(count);
						count++;
						Thread.sleep(3000);
					}catch (Exception e) {
						 System.out.println("Please don't interupt me !");
					}
				}
			}
		}; //r1
		
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				Boolean exit = false;
				Integer cnt = 1;
				Scanner in = new Scanner(System.in);
				while(!exit) {
					System.out.print("输入一个数字");
					in.nextInt();
					cnt++;
					if(cnt > 9) exit = true;
				}
				in.close();
			}
			
		}; //r2
		
		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r2);
		thr1.start();
		Scanner in2 = new Scanner(System.in);
		in2.next();
		thr2.start();
		
	}

}
 
