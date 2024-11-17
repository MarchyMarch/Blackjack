package client.network_comm;

import shared.commands.AbstractCommand;
import shared.misc.ServerInfo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkCommunication {
    private static final String SERVER_ADDRESS_DEFAULT = "192.168.0.246";

    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private static NetworkCommunication instance = null;

    private NetworkCommunication() {
        startConnection();
    }

    private void startConnection() {
        Scanner sc = new Scanner(System.in);
        System.out.print(String.format("Enter Host Override or d for Default(%s):  ", SERVER_ADDRESS_DEFAULT));
        String hostIn = sc.next();
        String host = hostIn.equals("d") ? SERVER_ADDRESS_DEFAULT : hostIn;

        try {
            Socket socket = new Socket(host, ServerInfo.SERVER_PORT);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Object sendCommand(AbstractCommand command) {
        try {
            outputStream.writeObject(command);
            outputStream.flush();
            return inputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static NetworkCommunication getInstance() {
        if (instance == null) {
            instance = new NetworkCommunication();
        }

        return instance;
    }
}
