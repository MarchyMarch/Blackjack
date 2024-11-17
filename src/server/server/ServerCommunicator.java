package server.server;

import shared.misc.ServerInfo;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerCommunicator {
    private static ServerCommunicator instance = null;
    private static ExecutorService pool = Executors.newCachedThreadPool();
    private ServerSocket server;

    private ServerCommunicator() {
        try {
            server = new ServerSocket(ServerInfo.SERVER_PORT);
        } catch (IOException e) {
            System.err.println("Failed to initialize server!");
            System.err.println(e.getMessage());
        }
    }

    public void start() {
        System.out.println("Server started on: http://" + getLocalIPAddress() + ":" + ServerInfo.SERVER_PORT);
        try {
            while (true) {
                Socket socket = server.accept();
                pool.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ServerCommunicator getInstance() {
        if (instance == null) {
            return new ServerCommunicator();
        }

        return instance;
    }

    private static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    // Check if the address is not loopback and is an IPv4 address
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "127.0.0.1"; // Fallback to localhost if no valid address is found
    }
}
