package common.classUtil.thread.normal;

public class TextThread {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		TxtThread tt = new TxtThread();
		new Thread(tt,"a").start();
		new Thread(tt,"b").start();
		new Thread(tt,"c").start();
		new Thread(tt,"d").start();
	}
}

class TxtThread implements Runnable {
	int num = 10;
	String str = new String();

	public void run() {
		while (true) {
			synchronized (str) {
				if (num > 0) {
					try {
						if("c".equals(Thread.currentThread().getName()))
						Thread.sleep(10000);
					} catch (Exception e) {
						e.getMessage();
					}
					System.out.println(Thread.currentThread().getName()
							+ "=" + num--);
				}
			}
			System.out.println(num);
		}
	}
}