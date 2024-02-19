import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String args[]) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        clientSocket.close();
    }
}
