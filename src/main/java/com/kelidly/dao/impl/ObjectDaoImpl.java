package com.kelidly.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kelidly.dao.BaseDao;
import com.kelidly.exception.DaoException;
import com.kelidly.model.PageModel;
import com.mysql.jdbc.Messages;


public class ObjectDaoImpl<T> implements Serializable, BaseDao<T> {

	private static final long serialVersionUID = 7433224241393375192L;

	private Logger logger = Logger.getLogger(this.getClass());

	private String databeaseError = Messages
			.getString("BaseDao.databeaseError");

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void batchDelete(Class clazz, long[] id) {
		String strId = "";
		for (int i = 0; i < id.length; i++) {
			if (i > 0)
				strId += ", " + id[i];
			else
				strId = "" + id[i];
		}
		logger.debug("batchDelete(Class, long[])  id[]={" + strId + "}");
		for (int i = 0; i < id.length; i++) {
			this.delete(clazz, id[i]);
		}
	}

	public void create(Object entity) {
		Session session = null;
		Transaction tr = null;
		boolean commitflag = false;
		try {
			session = this.getSession();
			tr = session.beginTransaction();
			session.save(entity);
			tr.commit();
			commitflag = true;
			session.flush();
			session.clear();
			// super.getHibernateTemplate().save(entity);
			logger.debug("保存" + entity.getClass().getName() + " 的实例到数据库成功！");
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.create.saveError");
			logger.debug("保存" + entity.getClass().getName() + " 的实例到数据库 ,"
					+ error, e);
			e.printStackTrace();
			throw new DaoException(error);
		} finally {
			if (!commitflag) {
				try {
					if (tr != null)
						tr.rollback();
				} catch (Exception e1) {
					logger.debug("事务", e1);
				}
			}
			this.closeSession(session);
		}

	}

	public void delete(Object entity) {
		logger.debug("delete(Object) entity.class="
				+ entity.getClass().getName());
		Session session = null;
		Transaction tr = null;
		boolean commitflag = false;
		try {
			session = this.getSession();
			tr = session.getTransaction();
			tr.begin();
			session.delete(entity);
			tr.commit();
			commitflag = true;
			session.flush();
			session.clear();
		} catch (Exception e) {
			if (tr != null)
				tr.rollback();
			String Error = Messages.getString("BaseDao.delete.Error");
			logger.debug(Error + " Class=" + entity.getClass().getName(), e);
			throw new DaoException(Error);
		} finally {
			if (!commitflag) {
				try {
					if (tr != null)
						tr.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.closeSession(session);
		}

	}

	@Override
	public void delete(Class clazz, int id) {
		logger.debug("ClassName=" + clazz.getName() + "  ,id=" + id);
		try {
			Object entity = this.getByPk(clazz, id);
			if (entity != null)
				this.delete(entity);
			else
				logger.debug(clazz.getName() + " 的关键字为 " + id + "  的对象不存在 ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("  delete(Class, int)  excute is error  . Error="
					+ e.toString());
			throw new DaoException(Messages.getString("BaseDao.delete.Error"));
		}
	}
	public void delete(Class clazz, long id) {
		logger.debug("ClassName=" + clazz.getName() + "  ,id=" + id);
		try {
			Object entity = this.getByPk(clazz, id);
			if (entity != null)
				this.delete(entity);
			else
				logger.debug(clazz.getName() + " 的关键字为 " + id + "  的对象不存在 ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("  delete(Class, long)  excute is error  . Error="
					+ e.toString());
			throw new DaoException(Messages.getString("BaseDao.delete.Error"));
		}
	}

	public void deleteAll(Class clazz) {
		logger.debug("deleteAll(Class) ClassName=" + clazz.getName());
		Session session = null;
		Transaction tr = null;
		boolean commitflag = false;
		try {
			session = this.getSession();
			tr = session.beginTransaction();
			Query query = session.createQuery(" delete   from "
					+ clazz.getName());
			query.executeUpdate();
			tr.commit();
			commitflag = true;
			session.flush();
		} catch (Exception e) {
			String Error = Messages.getString("BaseDao.delete.Error");
			
			String s= "从数据库中删除所有实例失败！实例:"+clazz.getName();
			logger.debug(s, e);
			throw new DaoException(Error);
		} finally {
			if (!commitflag) {
				try {
					if (tr != null)
						tr.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.closeSession(session);
		}
	}

	public void deleteAll(Collection entities) {
		Session session = null;
		Transaction tr = null;
		boolean commitflag = false;
		try {
			session = this.getSession();
			tr = session.beginTransaction();
			Iterator ite = entities.iterator();
			while (ite.hasNext())
				session.delete(ite.next());
			// super.getHibernateTemplate().deleteAll(entities);
			tr.commit();
			commitflag = true;
			session.flush();
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.deleteAll.Error");
			logger.debug(error, e);
			throw new DaoException(error);
		} finally {
			if (!commitflag) {
				try {
					if (tr != null)
						tr.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.closeSession(session);
		}
	}

	public void excuteSql(String strsql) {
		logger.debug("excuteSql(String) strsql=" + strsql);
		Session session = null;
		Transaction tr = null;
		boolean commitflag = false;
		try {
			session = this.getSession();
			tr = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(strsql);
			query.executeUpdate();
			tr.commit();
			commitflag = true;
			session.flush();
			// super.getHibernateTemplate().update(entity);
		} catch (Exception e) {
			String Error = Messages.getString("BaseDao.excuteSql.Error");
			logger.debug(Error, e);
			throw new DaoException(Error);
		} finally {
			if (!commitflag) {
				try {
					if (tr != null)
						tr.rollback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.closeSession(session);
		}

	}

	public List find(String strhql) {
		List result = null;
		logger.debug("find(String) queryString=" + strhql);
		Session session = null;
		try {
			// result = super.getHibernateTemplate().find(queryString);
			session = this.getSession();
			Query query = session.createQuery(strhql);
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("执行数据库中查询时失败,语句为：" + strhql, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List find(String strhql, Object param) {
		logger.debug("find(String, Object) queryString=" + strhql + " ,param="
				+ param);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			Query query = session.createQuery(strhql);
			query.setParameter(0, param);
			result = query.list();
			// result = super.getHibernateTemplate().find(queryString, param);
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List findByNamedParam(String strhql, String name, Object param) {
		logger.debug("findByNamedParam(String, String, Object) strhql="
				+ strhql + "name=" + name + " ,param=" + param);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			Query query = session.createQuery(strhql);
			query.setParameter(name, param);
			result = query.list();
			// result =
			// super.getHibernateTemplate().findByNamedParam(queryString,
			// name, param);
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List findBySql(String strsql) {
		logger.debug("exceuteSQL(String) strsql=" + strsql);
		System.out.println(strsql);
		Session session = null;
		List result = null;
		try {
			session = this.getSession();
			SQLQuery query = session.createSQLQuery(strsql);
			result = query.list();
			// super.getHibernateTemplate().update(entity);
		} catch (Exception e) {
			String Error = Messages.getString("BaseDao.exceuteSQL.Error");
			logger.debug(Error, e);
			throw new DaoException(Error);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List findBySql(String strsql, List params) {
		String paramnameArray = "";
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0)
					paramnameArray += " , " + params.get(i);
				else
					paramnameArray = "" + params.get(i);
			}
		}
		logger.debug("excuteSql(String, List) strsql=" + strsql + " , List="
				+ paramnameArray);
		System.out.println(strsql);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			SQLQuery query = session.createSQLQuery(strsql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
			}
			result = query.list();
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.findBySql.Error");
			logger.debug(error, e);
			e.printStackTrace();
			throw new DaoException(error);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public Object getByPk(Class clazz, int id) {
		logger.debug("getByPk(Class, Integer) class=" + clazz.getName()
				+ " , ID=" + id);
		Object result = null;
		Session session = null;
		try {
			session = this.getSession();
			result = session.get(clazz, new Integer(id));
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public Object getByPk(Class clazz, long id) {
		logger.debug("getByPk(Class, Long) Class=" + clazz.getName() + ",id="
				+ id);
		Object result = null;
		Session session = null;
		try {
			session = this.getSession();
			result = session.get(clazz, new Long(id));
			// (Object) super.getHibernateTemplate().get(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public Object getByPk(Class clazz, String id) {
		logger.debug("getByPk(Class, String) Class=" + clazz.getName() + ",id="
				+ id);
		Object result = null;
		Session session = null;
		try {
			session = this.getSession();
			result = session.get(clazz, id);
			// result = (Object) super.getHibernateTemplate().get(clazz, id);
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	// public Session getSession() {
	// return HibernateSessionFactory.getSession();
	// }

	public int getTotalCount(String strhql) {
		logger.debug("getTotalCount() strhql=" + strhql);
		int result = 0;
		Session session = null;
		try {
			String strsql = this.getQueryTotalCountString(strhql);
			session = this.getSession();
			Query query = session.createQuery(strsql);
			List list = query.list();
			result = this.getNum(list);
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public int getTotalCount(String strhql, Object obj) {
		logger.debug("getTotalCount(String,Object)  strhql=" + strhql + ""
				+ obj.getClass().getName());
		int result = 0;
		Session session = null;
		try {
			String strsql = this.getQueryTotalCountString(strhql);
			// System.out.println(strsql);
			logger.debug("strsql=" + strsql);
			session = this.getSession();
			Query query = session.createQuery(strsql);
			List list = query.setProperties(obj).list();
			result = this.getNum(list);
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.getTotalCount.Error");
			logger.debug(error, e);
			e.printStackTrace();
			throw new DaoException(error);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public int getTotalCount(String strhql, List params) {
		String paramnameArray = "";
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0)
					paramnameArray += " , " + params.get(i);
				else
					paramnameArray = "" + params.get(i);
			}
		}
		logger.debug("getTotalCount(String, List) strhql=" + strhql
				+ " , List=" + paramnameArray);
		int result = 0;
		Session session = null;
		try {
			String strquery = this.getQueryTotalCountString(strhql);
			// System.out.println(strsql);
			session = this.getSession();
			logger.debug("strquery==" + strquery);
			Query query = session.createQuery(strquery);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
			}
			List list = query.list();
			result = this.getNum(list);
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.getTotalCount.Error");
			logger.debug(error, e);
			e.printStackTrace();
			throw new DaoException(error);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public int getTotalCountBySql(String strsql) {
		logger.debug("getTotalCountBySql(String) strsql=" + strsql);
		int result = 0;
		Session session = null;
		try {
			strsql = this.getQueryTotalCountString(strsql);
			session = this.getSession();
			logger.debug("strsql==" + strsql);
			List list = session.createSQLQuery(strsql).list();
			result = this.getNum(list);
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public int getTotalCountBySql(String strsql, List params) {
		String paramnameArray = "";
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0)
					paramnameArray += " , " + params.get(i);
				else
					paramnameArray = "" + params.get(i);
			}
		}
		logger.debug("getTotalCountBySql(String, List) strsql=" + strsql
				+ " , List=" + paramnameArray);
		int result = 0;
		Session session = null;
		try {
			strsql = this.getQueryTotalCountString(strsql);
			logger.debug("strsql==" + strsql);
			session = this.getSession();
			SQLQuery query = session.createSQLQuery(strsql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
			}
			List list = query.list();
			result = this.getNum(list);
		} catch (Exception e) {
			String error = Messages.getString("BaseDao.getTotalCount.Error");
			logger.debug(error, e);
			e.printStackTrace();
			throw new DaoException(error);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List loadAll(String strhql) {
		return this.find(strhql);
	}

	public Object loadByPk(Class clazz, String keyName, Object keyValue) {
		Object result = null;
		String query = "from " + clazz.getName() + "  where " + keyName + "=? ";
		logger.debug("loadByPk(Class, String, Object) queryString=" + query
				+ "  ,keyValue=" + keyValue);
		Session session = null;
		try {
			session = this.getSession();
			result = session.createCriteria(clazz)
					.add(Restrictions.eq(keyName, keyValue)).list();
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List query(int pageNo, int pageSize, String strhql) {
		logger.debug("query(int, int, String) pageNo=" + pageNo + ",pageSize="
				+ pageSize + " ,strhql=" + strhql);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			Query query = session.createQuery(strhql);
			// System.out.println(queryString);
			if (pageNo > 0 && pageSize > 0) {
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List query(int pageNo, int pageSize, String strhql, Object obj) {
		logger.debug("query(int, int, String, Object) pageNo=" + pageNo
				+ ",pageSize=" + pageSize + "strhql=" + strhql + "  ,obj"
				+ obj.getClass().getName());
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			Query query = session.createQuery(strhql);
			query.setProperties(obj);
			if (pageNo > 0 && pageSize > 0) {
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List query(int pageNo, int pageSize, String strhql, List params) {
		logger.debug("query(int, int, String, Object) pageNo=" + pageNo
				+ ",pageSize=" + pageSize + ",strhql=" + strhql);
		String paramnameArray = "";
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0)
					paramnameArray += " , " + params.get(i);
				else
					paramnameArray = "" + params.get(i);
			}
		}
		logger.debug("params=" + params);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			Query query = session.createQuery(strhql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
			}
			if (pageNo > 0 && pageSize > 0) {
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List queryBySql(int pageNo, int pageSize, String strsql) {
		logger.debug("query(int, int, String) pageNo=" + pageNo + ",pageSize="
				+ pageSize + " ,strsql=" + strsql);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			SQLQuery query = session.createSQLQuery(strsql);
			if (pageNo > 0 && pageSize > 0) {
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public List queryBySql(int pageNo, int pageSize, String strsql, List params) {
		logger.debug("query(int, int, String, Object) pageNo=" + pageNo
				+ ",pageSize=" + pageSize + " , strsql=" + strsql);
		String paramnameArray = "";
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0)
					paramnameArray += " , " + params.get(i);
				else
					paramnameArray = "" + params.get(i);
			}
		}
		logger.debug("params=" + params);
		List result = null;
		Session session = null;
		try {
			session = this.getSession();
			SQLQuery query = session.createSQLQuery(strsql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					query.setParameter(i, params.get(i));
				}
			}
			if (pageNo > 0 && pageSize > 0) {
				query.setFirstResult((pageNo - 1) * pageSize);
				query.setMaxResults(pageSize);
			}
			result = query.list();
		} catch (Exception e) {
			logger.debug(databeaseError, e);
			throw new DaoException(databeaseError);
		} finally {
			this.closeSession(session);
		}
		return result;
	}

	public void update(Object entity) {
		logger.debug("update(Object) entity.class="
				+ entity.getClass().getName());
		Session session = null;
		Transaction tr = null;
		try {
			session = this.getSession();
			tr = session.beginTransaction();
			session.update(entity);
			tr.commit();
			session.flush();
			session.clear();
			// super.getHibernateTemplate().update(entity);
		} catch (Exception e) {
			if (tr != null)
				tr.rollback();
			String Error = Messages.getString("BaseDao.update.Error");
			logger.debug(Error, e);
			throw new DaoException(Error);
		} finally {
			this.closeSession(session);
		}
	}

	/**
	 * 功能：关闭session
	 * 
	 * @param session
	 */
	protected void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
		session = null;
	}

	/**
	 * 功能：得到查询记录总数的语句（包含sql与hql）
	 * 
	 * @param queryString
	 * @return
	 */
	private String getQueryTotalCountString(String queryString) {
		int form_index = queryString.indexOf("from ");
		int orderby_index = queryString.indexOf(" order by ");
		if (form_index < 0) {
			throw new DaoException(
					Messages.getString("BaseDao.getTotalCount.notFromkeyword"));
		}
		String strsql = " select count(*) ";
		if (orderby_index > -1) {
			strsql = strsql + queryString.substring(form_index, orderby_index);
		} else {
			strsql = strsql + queryString.substring(form_index);
		}
		return strsql;
	}

	/**
	 * 功能：得到记录数的方法
	 * 
	 * @param list
	 * @return
	 */
	protected int getNum(List list) {
		int result = 0;
		if (list != null || list.size() > 0)
			result = list.size();
		return result;
	}

	
	// MSQL分页查询
	public PageModel queryPageModel(int pageNo, int pageSize,
			StringBuffer queryHql, String whereSql, StringBuffer countSql) {

		// 计算总记录数
		// select count(*) from t_mc t where 1=1 and t.nmaxid=?
		countSql.append(whereSql);
		int allCount = 0;
		
		allCount = getNum(findBySql(countSql.toString()));	

		queryHql.append(whereSql);// 没有分页的半完整包含查询条件的SQL语句

		List result = query(pageNo, pageSize, queryHql.toString());		

		PageModel model = new PageModel();
		model.setAllCount(allCount);
		model.setResult(result);
		model.setCurrentPage(pageNo);
		model.setPageSize(pageSize);
		return model;
	}
}
