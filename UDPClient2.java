import java.net.*;
import java.io.*;
import java.lang.*;
public class UDPClient2{
		public static void main(String args[]){
				DatagramSocket aSocket = null;
				try {
						String s1;
						String words[];
						aSocket = new DatagramSocket(); 							//Datagramsocket initialization
						InetAddress aHost = InetAddress.getByName(args[0]);			//commandline argument for hostname,In my program it is localhost
						int serverPort = 6789;
						BufferedReader userInput =new BufferedReader(new InputStreamReader(System.in));	//Getting Input from user using standard input
						s1=userInput.readLine();							//Read the data entered by the user
						words = s1.split(" ");								//Using split function dividing the sentence into words and sending individual word to server
						for(int i=0;i<words.length;i++){					//Loop for words to send to server and receive from server.
								byte[] m =words[i].getBytes();
								DatagramPacket request = new DatagramPacket(m,m.length,aHost,serverPort);
								aSocket.send(request);
								byte[] buffer = new byte[1000];
								DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
								aSocket.receive(reply);
								System.out.println("Reply: " + new String(reply.getData()));
						}
				} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
				} catch (IOException e){System.out.println("IO: " + e.getMessage());
				} finally { if(aSocket != null) aSocket.close();}
	}
}
