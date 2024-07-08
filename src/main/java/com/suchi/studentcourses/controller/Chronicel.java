import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChronicleExample {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("data.dat", "rw");
             FileChannel channel = file.getChannel()) {

            // Map a region of the file into memory
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

            // Write data to the memory-mapped file
            buffer.put(0, (byte) 1);
            buffer.putInt(1, 1234);

            // Read data from the memory-mapped file
            byte flag = buffer.get(0);
            int number = buffer.getInt(1);

            System.out.println("Flag: " + flag);
            System.out.println("Number: " + number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}