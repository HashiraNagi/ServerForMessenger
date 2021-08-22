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


                    if(TempDataHolder.inputData != temp) {
                        out.writeUTF(TempDataHolder.inputData);
                        temp = TempDataHolder.inputData;
                    }

    }

    @Override
    public void run() {

        try {

//            Lock lock = Server.lockPool.get(ConectionFabric.conectionCount-1);

            while (true) {
//                synchronized (lock) {
                    output();
//                    lock.notify();
//                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
