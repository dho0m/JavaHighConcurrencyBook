package com.blankjor.parallelsearch;

import java.util.concurrent.ExecutionException;

/**
 * @desc 测试任务
 * @author Blankjor
 * @date 2017年9月9日 上午10:13:07
 */
public class TestMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 初始化数据
		ParallelSearch.arr = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			ParallelSearch.arr[i] = i;
		}
		Long l = System.currentTimeMillis();
		int i = ParallelSearch.pSearch(900000);
		System.out.println("搜索到的位置index=" + i);
		Long l1 = System.currentTimeMillis();
		System.out.println("用时：" + (l1 - l));
	}

}
