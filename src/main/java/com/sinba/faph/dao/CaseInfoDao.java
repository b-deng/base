package com.sinba.faph.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

//import com.sinba.common.dao.BaseDAOImplHibernate;
import com.sinba.faph.entity.CaseInformation;

public class CaseInfoDao extends BaseDAOImplHibernate<CaseInformation> {

	public List<CaseInformation> findCaseInfos(final String caseName) {
		String hql = "from CaseInformation c where c.parent is not null and c.parent.caseName = ?";
		return getHibernateTemplate().find(hql, caseName);
	}

	public List<String> findCaseNames() {
		String hql = "select c.caseName from CaseInformation c where c.parent is null";
		return getHibernateTemplate().find(hql);
	}
	public List<String> findCaseNames(final String caseName) {
		String hql = "select c.caseName from CaseInformation c where c.parent is not null and c.parent.caseName = ?";
		return getHibernateTemplate().find(hql, caseName);
	}

	public List<CaseInformation> findParentCaseInfos() {
		String hql = "from CaseInformation c where c.parent is null";
		return getHibernateTemplate().find(hql);
	}
	
	public List<Map> findParentCases() {
		final String sql = "SELECT ID ,caseName FROM CaseInformation where parentId is null";
		List<Map> data = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				SQLQuery q = s.createSQLQuery(sql);
				List<Map> data = new ArrayList();
				List<Object[]> list = q.list();
				for (Object[] row : list)  {
					Map m = new HashMap();
					m.put("value", row[0]);
					m.put("label", row[1]);
					data.add(m);
				}
				return data;
			}
		});
		return data;
	}
}
