//Program for server for problem two in question 3.Modified the content from the code given in the class
import java.net.*;
import java.io.*;
public class UDPServer3{
	public static void main(String args[]){
			DatagramSocket aSocket = null;
			try{
							aSocket = new DatagramSocket(6789);       //Assigned port number
							byte[] buffer = new byte[1000];
							System.out.println("Waiting for client request...");
							DatagramPacket request = new DatagramPacket(buffer, buffer.length);		//Request from client which is file name
							aSocket.receive(request);
							System.out.println("Receive: " + new String(request.getData()));
							String filename = new String(request.getData());					//getting the filename into the string
							BufferedReader in = new BufferedReader(new FileReader(filename));	//fileReader class created for flename
							tring fileData=null;
							while ((fileData=in.readLine()) != null){							//Reading the content from file 
									System.out.println(fileData);
									DatagramPacket reply = new DatagramPacket(fileData.getBytes(), fileData.length(),
                                                              request.getAddress(), request.getPort());
									aSocket.send(reply);										//Replying the content to client
							}
			} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			} catch (IOException e) {System.out.println("IO: " + e.getMessage());
			} finally {if (aSocket != null) aSocket.close();}
	}
}
