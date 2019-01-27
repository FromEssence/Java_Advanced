package sockets;

import java.net.*;

public class PortScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "localhost";
//		if(args.length>0) {
//			host = args[0];
//		}
		for(int i=1; i<10; i++) {
			try {
				Socket s= new Socket(host, i);
				System.out.println("port"+i+"可用");
			}
			catch(Exception e){
				System.out.println("port"+i+"不可用");
			}
		}
	}

}
