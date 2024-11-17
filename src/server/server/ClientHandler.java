package server.server;

import shared.commands.AbstractCommand;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Execute commands
            AbstractCommand message = (AbstractCommand) inputStream.readObject();
            Object obj = message.execute();
            outputStream.writeObject(obj);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}