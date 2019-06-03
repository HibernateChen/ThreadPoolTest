package cn.bestingmedia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {  //试试修改提交会不会覆盖
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		int b =0; //第六次修改。。。
		int d =2; //第八次修改
		int f = 1; //第十次修改
		int g=1; //第十一次修改
		
		for (int i = 0; i < 100; i++) {
			service.execute(()->{ //lambel表达式
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
