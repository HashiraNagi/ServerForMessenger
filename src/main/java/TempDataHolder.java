import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TempDataHolder {

    static Lock lock = new ReentrantLock();

    static volatile String inputData = "test";
//    static String outputData;

}
