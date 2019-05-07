

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OneServerInfo {
		// Create a server socket	
		// port numbers from 0 to 65536, but port numbers 0 to 1024 are reserved
		// for privileged services
		public static int port = 8000;
		
		/*
		 * Windows - SystemRoot > system32 > drivers > etc > hosts
			By default the system root is C:\Windows, so if you are using Windows, your hosts file is most probably: C:\Windows\System32\drivers\etc\hosts)
			Linux - /etc/hosts
			Mac OS X - /private/etc/hosts
		 * */		
		//public static String serverName = "127.0.0.1";
		public static String serverName = "127.0.0.1";
		
		public static void main(String[] args) {
			try {
				// define a ServerSocket
				ServerSocket server = new ServerSocket(port);
				System.out.println("Waiting for clients ... ");
				while (true) {
					// Define a socket for each client
					Socket socket = server.accept();
					// create a tread for the connection
					HandleAClientInfo oneclienthandle = new HandleAClientInfo(socket);
					// start a new thread
					new Thread(oneclienthandle).start();
														
				}
			}
			catch (Exception e) {
				// output the exception
				e.printStackTrace();
			}
			
		}
	
}
