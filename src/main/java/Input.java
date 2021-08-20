import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Input implements Runnable{
    InputStream Sin;
    DataInputStream in;

    static boolean xx;


    Input(Socket sock) throws IOException {

        Sin = sock.getInputStream();
        in = new DataInputStream(Sin);


    }

    private void input() throws IOException, InterruptedException {

//            synchronized (TempDataHolder.lock) {
//                TempDataHolder.lock.wait();
//                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                TempDataHolder.inputData = in.readUTF();
                System.out.println(TempDataHolder.inputData);
//                TempDataHolder.lock.notify();
//            }


    }

    @Override
    public void run() {

        try {
            while (true) {
//                TempDataHolder.lock.lock();
                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                input();
                System.out.println(TempDataHolder.inputData);
//                TempDataHolder.lock.unlock();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
