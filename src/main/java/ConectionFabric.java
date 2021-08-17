import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConectionFabric implements Runnable{

    static int conectionCount = 0;
    Socket socket;

    ConectionFabric(Socket sock) throws IOException {

        socket = sock;

    }

    @Override
    public void run(){

        try {
            Input newInput = new Input(socket);
            Thread inputThread = new Thread(newInput);
            inputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Output newOutput = new Output(socket);
            Thread outputThread = new Thread(newOutput);
            outputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
