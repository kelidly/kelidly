package com.kelidly.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import com.kelidly.model.PageModel;


public interface BaseDao<T> {
	/** 
     * 功能：获得数据库连接的Session 
     *  
     * @return Session 
     */  
    public Session getSession();  
    
  
    /** 
     * 功能：根据hql语句得到记录总数 
     *  
     * @param strhql 
     * @return int 
     */  
    public int getTotalCount(String strhql);  
  
    /** 
     * 功能：根据sql语句得到记录总数 
     *  
     * @param strsql 
     * @return int 
     */  
    public int getTotalCountBySql(String strsql);  
  
    /** 
     * 功能：根据hql语句得到记录总数 
     *  
     * @param strhql 
     * @param obj 
     * @return int 
     */  
    public int getTotalCount(String strhql, Object obj);  
      
       
    /** 
     * 功能：根据hql语句得到记录总数 
     * @param strhql 
     * @param params 
     * @return int 
     */  
    public int getTotalCount(String strhql, List params);  
      
    /** 
     * 功能：根据sql语句得到记录总数 
     * @param strsql 
     * @param param 
     * @return 
     */  
    public int getTotalCountBySql(String strsql, List params);  
      
       
       
    /** 
     * 功能：增加记录 
     *  
     * @param entity 
     */  
    public void create(Object entity);  
  
    /** 
     * 功能：修改记录 
     *  
     * @param entity 
     */  
    public void update(Object entity);  
  
    /** 
     * 功能：删除记录 
     *  
     * @param entity 
     */  
    public void delete(Object entity);  
    /** 
     * 功能：删除数据 
     *  
     * @param clazz 
     * @param id 
     */  
	void delete(Class clazz, int id);
    /** 
     * 功能：删除数据 
     *  
     * @param clazz 
     * @param id 
     */  
    public void delete(Class clazz, long id);  
  
    /** 
     * 功能：批量删除数据 
     *  
     * @param clazz 
     * @param id 
     */  
    public void batchDelete(Class clazz, long[] id);  
  
    /** 
     * 功能：删除表中的所有的记录 
     *  
     * @param clazz 
     */  
    public void deleteAll(Class clazz);  
  
    /** 
     * 功能：删除记录集中的所有的记录 
     *  
     * @param entities 
     */  
    public void deleteAll(Collection entities);;  
  
    /** 
     * 功能：通过主键查询记录 
     *  
     * @param clazz 
     * @param id 
     * @return Object 
     */  
  
    public Object getByPk(Class clazz, int id);  
  
    /** 
     * 功能：通过主键查询记录 
     *  
     * @param clazz 
     * @param id 
     * @return Object 
     */  
    public Object getByPk(Class clazz, long id);  
  
    /** 
     * 功能：通过主键查询记录 
     *  
     * @param clazz 
     * @param id 
     * @return Object 
     */  
    public Object getByPk(Class clazz, String id);  
  
    /** 
     * 功能：通过关键字和值来进行查询 
     *  
     * @param clazz 
     * @param keyName 
     * @param keyValue 
     * @return 得到的Object是List 
     */  
    public Object loadByPk(Class clazz, String keyName, Object keyValue);  
  
    /** 
     * 功能：根据hql查询记录 
     *  
     * @param strhql 
     * @return List 
     */  
    public List find(String strhql);  
  
    /** 
     * 功能：根据hql查询记录 
     *  
     * @param strhql 
     * @param param 
     * @return List 
     */  
    public List find(String strhql, Object param);  
  
    /** 
     * 功能：根据hql查询记录 
     *   
     * @param strhql 
     * @param name 
     * @param param 
     * @return List 
     */  
    public List findByNamedParam(String strhql, String name, Object param);  
  
      
    /** 
     * 功能：SQL查询 
     * @param strsql 
     * @return 
     */  
    public List findBySql(String strsql);  
      
    /** 
     * 功能：查询符合条件的记录。 
     * @param strsql 
     * @param params 
     * @return 
     */  
    public List findBySql(String strsql,List params);    
    
    /** 
     * 功能：分页查询 
     *  
     * @param pageNo 
     * @param pageSize 
     * @param strhql 
     * @return List 
     */  
    public List query(int pageNo, int pageSize, String strhql);  
  
    /** 
     * 功能：分页查询 
     *  
     * @param pageNo 
     * @param pageSize 
     * @param queryString 
     * @param obj 
     * @return List 
     */  
    public List query(int pageNo, int pageSize, String strhql, Object obj);  
      
      
    /** 
     * 功能：分页查询 
     * @param pageNo 
     * @param pageSize 
     * @param strhql 
     * @param params 
     * @return 
     */  
    public List query(int pageNo, int pageSize, String strhql, List params );  
  
   
      
    /** 
     * 功能：分页查询 
     *  
     * @param pageNo 
     * @param pageSize 
     * @param strsql 
     * @return List 
     */  
    public List queryBySql(int pageNo, int pageSize, String strsql);   
  
    /** 
     * 功能：分页查询 
     * @param pageNo 
     * @param pageSize 
     * @param strsql 
     * @param params 
     * @return 
     */  
    public List queryBySql(int pageNo, int pageSize, String strsql, List params) ;  
      
       
    /** 
     * 功能：执行SQL语句，主要是更新与删除记录的SQL语句，不需要返回值的 
     *  
     * @param strsql 
     */  
    public void excuteSql(String strsql);  
      
    public PageModel queryPageModel(int pageNo, int pageSize,StringBuffer queryHql, String whereSql, StringBuffer countSql);




}
