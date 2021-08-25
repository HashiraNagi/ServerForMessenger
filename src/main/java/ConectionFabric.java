import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConectionFabric implements Runnable{

    static int conectionCount = 0;
    Socket socket;
    boolean isOnline;


    ConectionFabric(Socket sock) {

        socket = sock;

    }

    boolean isOnlineChek(Input input){
        isOnline = input.isOnline;
        return isOnline;
    }

    @Override
    public void run(){

        try {
            Output newOutput = new Output(socket);
            Thread outputThread = new Thread(newOutput);
            outputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Input newInput = new Input(socket);
            Thread inputThread = new Thread(newInput);
            inputThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
