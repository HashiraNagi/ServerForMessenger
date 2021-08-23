import java.awt.event.ActionListener;
import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    private static Server server;

    static {
        try {
            server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Array that accumulate all threads
    ArrayList<Thread> threadPool = new ArrayList<>();

//    static ArrayList<Lock> lockPool = new ArrayList<>();

    static ServerSocket serverSock;

    static {
        try {
            serverSock = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Constructor of Server
    public Server() throws IOException {
    }

    public static Server getServer(){
        return server;
    }

    public void startServer() throws IOException {

                    while (true) {
                        ConectionFabric.lock.lock();
                        Socket conectedSock = serverSock.accept();
                        threadPool.add(new Thread(new ConectionFabric(conectedSock)));
//                        lockPool.add(new ReentrantLock());
                        threadPool.get(threadPool.size()-1).start();
                        ConectionFabric.conectionCount=ConectionFabric.conectionCount+1;
                        System.out.println(ConectionFabric.conectionCount);
                        ConectionFabric.lock.unlock();
                    }
            }
        }



