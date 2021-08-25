import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Input  implements Runnable{

    InputStream Sin;
    DataInputStream in;
    boolean isOnline;

    int serialNumber;

    Input(Socket sock) throws IOException {

        Sin = sock.getInputStream();
        in = new DataInputStream(Sin);
        isOnline = true;
        serialNumber = ConectionFabric.conectionCount;

    }

    private void input() throws InterruptedException {
            try {
                TempDataHolder.inputData = in.readUTF();
            }
            catch (IOException e){
                System.out.println("Client disconnected");
                TempDataHolder.disconnectNumber = "disconnected"+serialNumber;
                isOnline = false;

            }
            System.out.println(TempDataHolder.inputData);
    }

    boolean getOnlineStatus(){
        return isOnline;
    }

    @Override
    public void run() {

        try {


            while (true) {

                if(!isOnline){
                    break;
                }
                    input();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
