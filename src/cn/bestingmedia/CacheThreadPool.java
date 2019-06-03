package cn.bestingmedia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPool {  //�����޸��ύ�᲻�Ḳ��
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		int b =0; //�������޸ġ�����
		int d =2; //�ڰ˴��޸�
		int f = 1; //��ʮ���޸�
		int g=1; //��ʮһ���޸�
		
		for (int i = 0; i < 100; i++) {
			service.execute(()->{ //lambel���ʽ
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
