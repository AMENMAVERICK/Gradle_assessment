import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Ques7{

    public static void main(String[] args) throws InterruptedException {
        List<Callable<Integer>> runnableList = new ArrayList<>();

        runnableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        runnableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        runnableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        });
        runnableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 4;
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Future<Integer>> futureList = executorService.invokeAll(runnableList);
        futureList.forEach((e)->{
            if(e.isDone()){
                try {
                    System.out.println(e.get());
                }
                catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                catch (ExecutionException e1) {
                e1.printStackTrace();
                }
            }
        });
           executorService.shutdown();
           executorService.awaitTermination(1000l, TimeUnit.MILLISECONDS);
           if(executorService.isTerminated())
           {
               System.out.println("terminated");
           }
           else
           {
               System.out.println("task still running");
           }
    }
}
