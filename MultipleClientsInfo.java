

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultipleClientsInfo {
	public static void main(String[] args) {
		// Define the port number
		int port = 8000;		
		//Define a host
		String host = "127.0.0.1";
		Scanner sc = new Scanner(System.in); 	
		try {
			while (true) {
				// repeatedly get User Information 
			
				System.out.print("Height: ");				
				// get user's first name	 
				int height = sc.nextInt(); 
				
				System.out.print("Weight: ");				
				// get user's last name
				int weight = sc.nextInt(); 
							
				// Define a socket
				Socket socket = new Socket(host, port);	
				// define an ObjectOutputStream
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());				
				// send the object (UserInfo) to the server
				out.writeObject(new UserInfo(height, weight));
				// get the response from the server
				DataInputStream in = new DataInputStream(socket.getInputStream());
				// Show server's response
				System.out.println("server's response for the information is: " + in.readUTF());
				
			}
						
		} catch (IOException e) {
			// output the exception
			e.printStackTrace();
		}
		finally {			
			sc.close();
		}
		
		
	}

}
