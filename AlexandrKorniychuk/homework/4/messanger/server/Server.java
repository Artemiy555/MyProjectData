package server;

import java.io.IOException;
        import java.net.InetSocketAddress;
        import java.nio.ByteBuffer;
        import java.nio.channels.ServerSocketChannel;
        import java.nio.channels.SocketChannel;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.ScheduledExecutorService;
        import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        System.setProperty("console.encoding","utf-8");
        final String[] messageFromSer = {""};

        ServerSocketChannel sc= ServerSocketChannel.open();
        sc.bind((new InetSocketAddress(25_000)));

        List<Runnable> task = new ArrayList<>();
        List<SocketChannel> clientList = new ArrayList<>();

        System.out.println("wait connect...");

        ExecutorService clients = Executors.newFixedThreadPool(20);
        ScheduledExecutorService clientListener= Executors.newSingleThreadScheduledExecutor();

        clientListener.scheduleAtFixedRate(() -> {
            try {
                SocketChannel client = sc.accept();
                clientList.add(client);
                task.add(() -> {
                    /*
                     * Runnable threadOut send message to all users
                     */
                    Runnable threadOut = (() -> {
                        for (SocketChannel s : clientList) {
                            if(s != client) {
                                try {
                                    ByteBuffer bufferO = ByteBuffer.allocate(128);
                                    bufferO.put(messageFromSer[0].getBytes());
                                    bufferO.flip();
                                    s.write(bufferO);
                                    bufferO.clear();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    String message ;

                    int bytes;
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    System.out.println("add user " + ":" + task.size() + " | " + client.socket());

                    try {
                        while ((bytes = client.read(buffer)) > 0) {
                            buffer.flip();
                            message = new String(buffer.array(),0,bytes);
                            System.out.println(" -> " + message);

                            messageFromSer[0] = message;
                            buffer.clear();

                            clients.submit(threadOut);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                clients.submit(task.get(task.size()-1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }
}