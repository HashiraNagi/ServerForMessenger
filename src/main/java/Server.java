import java.awt.event.ActionListener;
import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    ArrayList<Thread> threadPool = new ArrayList<>();

    static ServerSocket server;

    static {
        try {
            server = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Server() throws IOException {
    }

    public void startServer() throws IOException {

        Thread collectingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Socket conectedSock = server.accept();
                        threadPool.add(new Thread(new ConectionFabric(conectedSock)));
                        threadPool.get(threadPool.size()-1).start();
                        ConectionFabric.conectionCount=ConectionFabric.conectionCount+1;
                        System.out.println(ConectionFabric.conectionCount);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        collectingThread.start();


    }


}
