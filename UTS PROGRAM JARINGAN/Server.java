import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<ServerThread> clientThreads = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Chat Server is running on port 12345...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerThread clientThread = new ServerThread(clientSocket, clientThreads);
                clientThreads.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ServerThread> getClientThreads() {
        return clientThreads;
    }
}