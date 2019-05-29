package cn.bestingmedia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 案例：分别使用单线程和多线程找出1-200000中的所有质数
 * 
 * */
public class FixedThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Long strat1 = System.currentTimeMillis();
        getPrime(1,200000);
        Long end1 = System.currentTimeMillis();
        System.out.println(end1-strat1);

        final int cpuCoreNum = 4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        
        Future<List<Integer>> task1 = service.submit(new myTask(0,80000));
        Future<List<Integer>> task2 = service.submit(new myTask(80001,130000));
        Future<List<Integer>> task3 = service.submit(new myTask(130001,180000));
        Future<List<Integer>> task4 = service.submit(new myTask(180001,200000));
        
        Long strat2 = System.currentTimeMillis();
        task1.get();
        task2.get();
        task3.get();
        task4.get();
        Long end2 = System.currentTimeMillis();
        System.out.println(end2-strat2);

        service.shutdown();
    }
    
    static class myTask implements Callable<List<Integer>>{
    	int start2;
    	int end2;
    	
    	
		public myTask(int start2, int end2) {
			super();
			this.start2 = start2;
			this.end2 = end2;
		}


		@Override
		public List<Integer> call() {
			return getPrime(start2,end2);
		}
    	
    }

    static boolean isPrime(int num){  //判断数是否为质数，由于需要多次测试，所以单独封装
        for (int i = 2; i < num/2; i++) {  //num/2是为了减少判断次数，可以极大提高程序效率
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start,int end){  //将质数获取出来装到List中
        List<Integer> primeList = new ArrayList<>();
        for (int i = start; i <= end ; i++) {
            if(isPrime(i)){
                primeList.add(i);
            }
        }
        return primeList;
    }

}
