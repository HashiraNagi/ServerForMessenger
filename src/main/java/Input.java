import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Input implements Runnable{
    InputStream Sin;
    DataInputStream in;

    Input(Socket sock) throws IOException {

        Sin = sock.getInputStream();
        in = new DataInputStream(Sin);

    }

    private void input() throws IOException, InterruptedException {

            TempDataHolder.inputData = in.readUTF();
            System.out.println(TempDataHolder.inputData);
    }

    @Override
    public void run() {

        try {

//            Lock lock = Server.lockPool.get(ConectionFabric.conectionCount-1);

            while (true) {
//                synchronized (lock) {
                    input();
//                    lock.wait();
//                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
