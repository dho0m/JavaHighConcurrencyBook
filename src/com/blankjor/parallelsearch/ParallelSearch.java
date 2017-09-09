package com.blankjor.parallelsearch;
/**
 *@desc 并行搜索
 *@author Blankjor 
 *@date 2017年9月9日 上午9:48:27
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelSearch {

	static int[] arr;
	static ExecutorService pool = Executors.newCachedThreadPool();
	static final int Thread_Num = 3;
	static AtomicInteger result = new AtomicInteger(-1);

	public static int search(int searchValue, int beginPos, int endPos) {
		int i = 0;
		for (i = beginPos; i < endPos; i++) {
			if (result.get() >= 0) {
				return result.get();
			}
			if (arr[i] == searchValue) {
				// 如果设置失败，已经被其他线程设置成功了 compareAndSet(当前值，需要更新的值)
				// 如果当前值都不是-1 了那么执行会是false，说明其余的线程已经完成
				if (!result.compareAndSet(-1, i)) {
					return result.get();
				}
				return i;
			}
		}
		// 最终还是没找到
		return -1;
	}

	// 开始搜索入口
	public static int pSearch(int searchValue) throws InterruptedException, ExecutionException {
		int subArrSize = arr.length / Thread_Num;
		List<Future<Integer>> re = new ArrayList<Future<Integer>>();
		for (int i = 0; i < arr.length; i += subArrSize) {
			int end = i + subArrSize;
			if (end >= arr.length)
				end = arr.length;
			re.add(pool.submit(new SearchTask(searchValue, i, end)));
		}
		for (Future<Integer> future : re) {
			if (future.get() >= 0) {
				return future.get();
			}
		}
		return -1;
	}
}
