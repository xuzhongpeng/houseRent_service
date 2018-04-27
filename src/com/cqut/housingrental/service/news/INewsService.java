package com.cqut.housingrental.service.news;

import java.util.Map;

import com.cqut.housingrental.entity.news.News;

public interface INewsService {

	Map<String, Object> getWithPaging(int limit, int offset, String order,
			String sort, String searchText);
	
}
