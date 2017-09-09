package com.blankjor.parallelassemblyline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @desc 除法线程
 * @author Blankjor
 * @date 2017年9月9日 上午9:17:26
 */
public class DivThread implements Runnable {
	// 阻塞队列，存放多个操作
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<Msg>();

	@Override
	public void run() {
		while (true) {
			try {
				Msg msg = bq.take();
				msg.i = msg.i / 2;
				System.out.println(msg.orgStr + "=" + msg.i);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
