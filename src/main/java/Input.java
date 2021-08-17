import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Input implements Runnable{
    InputStream Sin;
    DataInputStream in;
    Lock lock = new ReentrantLock();

    Input(Socket sock) throws IOException {

        Sin = sock.getInputStream();
        in = new DataInputStream(Sin);


    }

    private void input() throws IOException {
        while (true) {

            TempDataHolder.inputData = in.readUTF();
            System.out.println(TempDataHolder.inputData);

        }
    }

    @Override
    public void run() {

        try {
            lock.lock();
            input();
            lock.unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
