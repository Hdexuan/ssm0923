package com.awsl.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	/**
	 * 新增
	 * @param t
	 */
	public void add(T t);
	/**
	 * 修改
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据主键删除
	 * @param cls
	 * @param id
	 */
	public void deleteById(Class<?> cls,Serializable id);
	/**
	 * 根据主键查询
	 * @param cls
	 * @param id
	 * @return
	 */
	public T queryById(Class<?> cls,Serializable id);
	/**
	 * 分页查询
	 * @param cls
	 * @param map
	 * @return
	 */
	public List<T> queryByPage(Class<?> cls, int currentPage,int pageSize);
	/**
	 * 查询总记录数
	 * @param cls
	 * @return
	 */
	public int getTotals(Class<?> cls);

}
