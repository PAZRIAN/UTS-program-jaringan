import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            try {
                Socket socket = new Socket("localhost", 12345);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send username to server
                out.println(username);

                // Read and send messages to the server
                System.out.println("Start chatting (type 'exit' to quit):");
                String message;
                while (true) {
                    System.out.print("> ");
                    message = scanner.nextLine();
                    System.out.println( " Mengirim pesan:" + message);
                       out.println(message);

                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}