import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your username: ");
            String username = input.readLine();
            writer.println(username);

            Thread listener = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception ignored) {}
            });
            listener.start();

            String text;
            while ((text = input.readLine()) != null) {
                writer.println(text);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
