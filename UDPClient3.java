//Client program for problem two in question three.No modification done from the class code.
import java.net.*;
import java.io.*;
public class UDPClient3{
	public static void main(String args[]){
			DatagramSocket aSocket = null;
			try {
					aSocket = new DatagramSocket();									//socket creation
					byte [] m = args[0].getBytes();									//args[0] contains file name
					InetAddress aHost = InetAddress.getByName(args[1]);				//args[1] contains hostname
					int serverPort = 6789;
					DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);	//create datgrampacket
					aSocket.send(request);											//send data to server
					byte[] buffer = new byte[1000];
				    DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
					aSocket.receive(reply);											//receive data from server
					System.out.println("Reply: " + new String(reply.getData()));
			} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			} catch (IOException e){System.out.println("IO: " + e.getMessage());
			} finally { if(aSocket != null) aSocket.close();}
	}
}
