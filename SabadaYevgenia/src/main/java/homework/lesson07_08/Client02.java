package java.homework.lesson07_08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client02 {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.1.179", 20000));
        Runnable read = new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(128);
                String message = null;
                int bytes = 0;
                try {
                    do {
                        while ((bytes = channel.read(buffer)) > 0) {
                            buffer.flip();
                            message = new String(buffer.array(), 0, bytes);
                            System.out.println(message);
                            buffer.clear();
                            break;
                        }
                    } while ((!message.equals("EXIT"))||(!message.equals("Exit"))||(!message.equals("exit")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable write = new Runnable() {
            @Override
            public void run() {
                ByteBuffer buffer = ByteBuffer.allocate(128);
                String message = null;
                Scanner scan = new Scanner(System.in);
                do {
                    try {
                        System.out.print("Client01 : ");
                        message = scan.nextLine();
                        buffer.put(message.getBytes());
                        buffer.flip();
                        channel.write(buffer);
                        buffer.clear();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } while ((!message.equals("exit"))||(!message.equals("EXIT"))||(!message.equals("Exit")));
            }
        };

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(read);
        es.execute(write);

        if (!es.isTerminated()) {
            try {
                es.awaitTermination(3, TimeUnit.SECONDS);
                es.shutdownNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();

    }
}
