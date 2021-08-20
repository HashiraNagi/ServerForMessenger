import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Output implements Runnable{

    OutputStream Sout;
    DataOutputStream out;
    Lock lock = new ReentrantLock();

    String temp="";

    Output(Socket sock) throws IOException {

         Sout = sock.getOutputStream();
         out = new DataOutputStream(Sout);

    }

    private void output() throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);


//                synchronized (TempDataHolder.lock) {
                    out.writeUTF(TempDataHolder.inputData);
//                    System.out.println("BROOOOOOO");
                    temp = TempDataHolder.inputData;
//                    TempDataHolder.lock.notify();
//                }
//        temp != TempDataHolder.inputData


    }

    @Override
    public void run() {

        try {
            System.out.println("eee");
            while (true) {
//                TempDataHolder.lock.lock();

                output();
//                System.out.println("eee");

//                TempDataHolder.lock.unlock();

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
