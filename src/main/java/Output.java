import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Output implements Runnable{

    OutputStream Sout;
    DataOutputStream out;

    String temp="";

    Output(Socket sock) throws IOException {

         Sout = sock.getOutputStream();
         out = new DataOutputStream(Sout);

    }

    private void output() throws IOException {

        Scanner scan = new Scanner(System.in);

//        out.writeUTF("qqqww");

            if (TempDataHolder.inputData != null && temp != TempDataHolder.inputData) {
                out.writeUTF(TempDataHolder.inputData);
            }

        temp = TempDataHolder.inputData;

    }

    @Override
    public void run() {

        try {
            while (true) {
                output();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
