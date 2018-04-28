package homework;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class server {public static void main(String[] args) throws IOException {
    String finish1 = "exit";
    String finish2 = "EXIT";
    String finish3 = "Exit";
    ServerSocketChannel sc = ServerSocketChannel.open();
    sc.bind(new InetSocketAddress(20000));

    System.out.println("Ожидаем подключения...");
    ExecutorService clients = Executors.newFixedThreadPool(20);

    ScheduledExecutorService clientListener =
            Executors.newSingleThreadScheduledExecutor();
    clientListener.scheduleAtFixedRate(() -> {
        try {
            SocketChannel client = sc.accept();
            clients.submit(() -> {
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    int bytes;
                    while ((bytes = client.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println("Входящее сообщение: "
                                + new String(buffer.array(), 0, bytes));
                        buffer.clear();
                    }
                    do {
                        System.out.print("Сообщение для отправки : ");
                        buffer.flip();
                        client.write(buffer);
                        buffer.clear();

                    } while (!(new String(buffer.array(), 0, bytes)).equals("exit"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }, 0, 100, TimeUnit.MILLISECONDS);
}
}