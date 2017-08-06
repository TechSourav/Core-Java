package com.sourav.mock.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author sthom7
 * 
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadPool pool = new ThreadPool(3);
		Task task = new Task();
		for(int i=0;i<3;i++){
			pool.executeTask(task);
		}
		pool.shutDown();
	}

}

class ThreadPool {
	private BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
	//List<MyThreads> threads = new ArrayList<>();
	private volatile boolean shutDown = false;

	ThreadPool(int threadCount) {
		for (int i = 0; i < threadCount; i++) {
			MyThreads thread = new MyThreads(taskQueue, this);
			thread.setName("Thread-" + i);
			//threads.add(thread);
			thread.start();
		}
	}

	public void executeTask(Runnable task) throws InterruptedException {
		if (!this.shutDown)
			taskQueue.put(task);
	}

	public void shutDown() {
		this.shutDown = true;
	}

	public boolean getShutdownStatus() {
		return this.shutDown;
	}
}

class MyThreads extends Thread {
	private BlockingQueue<Runnable> taskQueue;
	private ThreadPool pool;

	MyThreads(BlockingQueue<Runnable> taskQueue, ThreadPool pool) {
		this.taskQueue = taskQueue;
		this.pool = pool;
	}

	public void run() {
		while (!(this.taskQueue.size() == 0 && pool.getShutdownStatus())) {
			try {
				Runnable runnable = taskQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()
					+ "executing the task");
		 }catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
