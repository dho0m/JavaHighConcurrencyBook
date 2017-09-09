package com.blankjor.parallelassemblyline;

/**
 * @desc 测试100万次操作
 * @author Blankjor
 * @date 2017年9月9日 上午9:20:12
 */
public class PStreamMain {
	public static void main(String[] args) {
		new Thread(new PlusThread()).start();
		new Thread(new MultiplyThread()).start();
		new Thread(new DivThread()).start();

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
				PlusThread.bq.add(msg);
			}
		}
	}

}
