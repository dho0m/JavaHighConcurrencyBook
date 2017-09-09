package com.blankjor.parallelassemblyline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @desc 加法线程
 * @author Blankjor
 * @date 2017年9月9日 上午9:12:52
 */
public class PlusThread implements Runnable {
	// 阻塞队列，存放多个操作
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();

	@Override
	public void run() {
		while (true) {
			try {
				Msg msg = bq.take();
				msg.j = msg.i + msg.j;
				MultiplyThread.bq.add(msg);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
