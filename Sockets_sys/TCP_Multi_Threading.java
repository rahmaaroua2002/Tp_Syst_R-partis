import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class TCPServer {
    private static final int MAX_CLIENTS = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_CLIENTS);
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.submit(() -> handleClient(clientSocket));
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
            String clientSentence = inFromClient.readLine();
            String reversedSentence = new StringBuilder(clientSentence).reverse().toString();

            Thread.sleep(1000); // Simulate processing delay

            outToClient.println(reversedSentence);
            clientSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
