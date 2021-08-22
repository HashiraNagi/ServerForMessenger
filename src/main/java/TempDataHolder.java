import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TempDataHolder {

    static final Lock lock = new ReentrantLock();

    static volatile String inputData = "test\n";
//    static String outputData;

}
