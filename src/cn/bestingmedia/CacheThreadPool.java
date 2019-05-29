package cn.bestingmedia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		 
		for (int i = 0; i < 100; i++) {
			service.execute(()->{ //lambel±Ì¥Ô Ω
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
	}
}
