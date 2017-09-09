package com.blankjor.parallelsearch;

import java.util.concurrent.Callable;

/**
 * @desc 搜索任务
 * @author Blankjor
 * @date 2017年9月9日 上午9:56:43
 */
public class SearchTask implements Callable<Integer> {

	int begin, end, searchValue;

	public SearchTask(int searchValue, int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.searchValue = searchValue;
	}

	@Override
	public Integer call() throws Exception {
		int re = ParallelSearch.search(searchValue, begin, end);
		return re;
	}

}
