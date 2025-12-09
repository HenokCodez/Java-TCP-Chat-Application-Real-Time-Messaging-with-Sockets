import java.io.*;
import java.net.*;
import java.util.Set;

public class ClientHandler implements Runnable {
    private Socket socket;
    private Set<ClientHandler> clients;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {}
    }

    @Override
    public void run() {
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                broadcast(msg);
            }
        } catch (Exception e) {
        } finally {
            close();
        }
    }

    private void broadcast(String msg) {
        synchronized (clients) {
            for (ClientHandler c : clients) c.writer.println(msg);
        }
    }

    private void close() {
        try {
            clients.remove(this);
            socket.close();
        } catch (Exception e) {}
    }
}
