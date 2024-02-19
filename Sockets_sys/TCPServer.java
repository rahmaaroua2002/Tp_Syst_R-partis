import java.io.*;
import java.net.*;

class TCPServer {
    public static void main(String args[]) throws Exception {
        String clientSentence;
        String capitalizedSentence = "";
        ServerSocket welcomeSocket = new ServerSocket(3248);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + "\\n";
            outToClient.writeBytes(capitalizedSentence + "enter the message or command: ");

            System.out.println("passed");
            welcomeSocket.close();
            System.out.println("connection terminated");
        }
    }
}
