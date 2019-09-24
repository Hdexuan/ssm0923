package com.awsl.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.awsl.dao.BaseDao;
import com.awsl.service.BaseService;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T>{

	@Resource
	private BaseDao<T> baseDao;
	
	@Override
	public void add(T t) {
		baseDao.add(t);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
		
	}

	@Override
	public void deleteById(Class<?> cls, Serializable id) {
		baseDao.deleteById(cls, id);
		
	}

	@Override
	public T queryById(Class<?> cls, Serializable id) {
		// TODO Auto-generated method stub
		return baseDao.queryById(cls, id);
	}

	@Override
	public List<T> queryByPage(Class<?> cls, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("start", (currentPage-1)*pageSize);
		map.put("pageSize", pageSize);//上限
		return baseDao.queryByPage(cls,map);
	}

	@Override
	public int getTotals(Class<?> cls) {
		// TODO Auto-generated method stub
		return baseDao.getTotals(cls);
	}

}
