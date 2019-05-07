

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

// Two ways to define a subclass of a thread
// Way one: extends Thread
// Way Two: implements Runnable
public class HandleAClientInfo extends Thread {
	private Socket socket;
	
	
	// construct a thred
	public HandleAClientInfo(Socket socket) {
		this.socket = socket;
		
		
	}

	@Override
	public void run() {
		
		try {
			// create object input and data output streams
			ObjectInputStream inputFromClient = 
					new ObjectInputStream(socket.getInputStream());				
			DataOutputStream outputToClient = 
				new DataOutputStream(socket.getOutputStream());
			// this method will block if no input is given
			UserInfo userinfo = (UserInfo)inputFromClient.readObject();
			
			int height = userinfo.getHeight();
			int weight = userinfo.getWeight();
			
			// modify the following line to get correct calculation of BMI
			double BMI = 0.0;
			
			System.out.println("Client's BMI is " + BMI);
			// send back to the client
			outputToClient.writeUTF("Your BMI is " + BMI);

		
		} catch (ClassNotFoundException e) {
			// output the exception e
			e.printStackTrace();
		}
		catch (Exception e) {
			// output the exception e
			e.printStackTrace();
		}
	}
}
