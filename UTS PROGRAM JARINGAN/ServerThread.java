import java.io.*;
import java.net.*;
import java.util.List;

public class ServerThread extends Thread {
    private String username;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private List<ServerThread> clientThreads;

    public ServerThread(Socket clientSocket, List<ServerThread> clientThreads) {
        this.clientSocket = clientSocket;
        this.clientThreads = clientThreads;

        try {
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Read username from client
            this.username = in.readLine();
            System.out.println("User '" + username + "' connected.");

            // Broadcast user joined message
            broadcastMessage("User '" + username + "' joined the chat.");

            // Read and broadcast messages from the client
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                if
                (clientMessage.equalsIgnoreCase("EXIT"))
                {
                    break;
                }
                System.out.println( "menerima pesan dari" + this.username + "; " + clientMessage);
                String formattedMessage = "[" + this.username + "]: " + clientMessage;
                broadcastMessage(formattedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Handle client disconnect
            System.out.println("User '" + username + "' disconnected.");
            clientThreads.remove(this);
            broadcastMessage("User '" + username + "' left the chat.");
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcastMessage(String message) {
        for (ServerThread clientThread : clientThreads) {
            clientThread.sendMessage(message);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}