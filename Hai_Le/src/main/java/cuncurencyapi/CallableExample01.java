package cuncurencyapi;

import java.util.concurrent.*;

public class CallableExample01 {

    public static void main(String[] args) {
        /* Callable - интерфейс который доступен
        *  в Concurrency API, позволяет нам вернуть
        *  результат работы фоновой задачи для
        *  дальнейшей обработки */
        Callable<String> strCallable = () -> {
            System.out.println("Проводим работу strCallable");
            TimeUnit.SECONDS.sleep(1);
            return "Результат";
        };

        /*newFixedThreadPool(<количество активных потоков>) */
        ExecutorService es = Executors.newFixedThreadPool(2);

         /*Future<тип ожидаемого результата>*/
        Future<String> strResult = es.submit(strCallable);


        try {
            System.out.println("Проверка результата...");
            /* isDone() - позволяет проверить завершена ли задача
            *  true  - завершено
            *  false - в работе*/
            System.out.println("Завершение задачи: " + strResult.isDone());
            if(strResult.isDone()) {
                String result = strResult.get(5, TimeUnit.SECONDS);
                System.out.println(result);
            } else {
                System.out.println(strResult.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }

}
