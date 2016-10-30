package com.sinba.faph.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.*;

//import com.sinba.common.dao.BaseDAOImplHibernate;
import com.sinba.faph.entity.DrugInfo;
import com.sinba.faph.entity.FirstAidPatientHistory;
import org.springframework.orm.hibernate3.HibernateCallback;


public class FAPHDao extends BaseDAOImplHibernate<FirstAidPatientHistory> {

	public void updateTblCar(final String phNo, final String carNo) {
		final String sql = "UPDATE tblCar SET CurrPatNumber= ? WHERE CarNumber = ?";		
		getHibernateTemplate().execute( new HibernateCallback() {
			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				SQLQuery q = s.createSQLQuery(sql);
				q.setString(0, phNo);
				q.setString(1, carNo);
				q.executeUpdate();
				return null;
			}
		});
	}
	
    /**
     * ����������
     * @return String
     */
    public String dayCount(){
    	Calendar c1 = Calendar.getInstance();
    	c1.set(Calendar.HOUR_OF_DAY, 0);
    	c1.set(Calendar.MINUTE, 0);
    	c1.set(Calendar.SECOND, 0);
    	Date start = c1.getTime();
    	
    	Calendar c2 = Calendar.getInstance();
    	c2.set(Calendar.HOUR_OF_DAY, 23);
    	c2.set(Calendar.MINUTE, 59);
    	c2.set(Calendar.SECOND, 59);
    	Date end = c2.getTime();
 
    	String hql="select count(f) from FirstAidPatientHistory f where f.patAddTime between ? and ? ";
    	Integer count= ((Number)getHibernateTemplate().find(hql,
    			start, end).get(0)).intValue()+1;
    	String counts=String.format("%04d",count);
    	
    	SimpleDateFormat fmt=new SimpleDateFormat("yyyyMMdd");
		String todays = fmt.format(start);
    	return todays+counts;
    }

	public List<Map> findEnums(final Integer enumType) {
		final String sql = "SELECT EnumID ,EnumName FROM SysEnum where isStop =0 and EnumType = ?";
		List<Map> data = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				SQLQuery q = s.createSQLQuery(sql);
				q.setInteger(0, enumType);
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
	
	public List<Map> findHospitalEmps(final int pos, final int hospitalId) {
		final String sql = "select ID,Name from HospitalEmpInfo where Pos = ? and hospitalId = ?";
		List<Map> data = getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				SQLQuery q = s.createSQLQuery(sql);
				q.setInteger(0, pos);
				q.setInteger(1, hospitalId);
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
	
	public List<Map> findHospitals() {
		final String sql = "select HospitalId,HospitalName from HospitalMgr";
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
	
	public List<DrugInfo> findDrugs() {
		final String hql = "from DrugInfo";
		return getHibernateTemplate().find(hql);
	}
	
	public Object[] findCarNoByPhoneNo(final String phoneNo) {
		final String sql = "select CarNumber,CarHospital,CarLic from tblCar where CarPadSim=?";

		Object[] carNo = getHibernateTemplate().execute(new HibernateCallback<Object[]>(){
			public Object[] doInHibernate(Session s)
					throws HibernateException, SQLException {
				Object[] carNo = null;
				SQLQuery q = s.createSQLQuery(sql);
				q.setString(0, phoneNo);
				List<Object[]> data = q.list();
				
				if (data.size()>0)
					carNo = data.get(0);
				return carNo;
			}
		});
		return carNo;
	}

	public String findCarCurrPatNumByPhoneNo(final String phoneNo) {
		final String sql = "select CurrPatNumber from tblCar where CarPadSim=?";

		String patNumber = getHibernateTemplate().execute(new HibernateCallback<String>(){
			public String doInHibernate(Session s)
					throws HibernateException, SQLException {
				String carNo = null;
				SQLQuery q = s.createSQLQuery(sql);
				q.setString(0, phoneNo);
				List<String> data = q.list();
				
				if (data.size()>0)
					carNo = data.get(0);
				return carNo;
			}
		});
		return patNumber;
	}
	
	public String findCarCurrPatNumByPhoneNoNew(final String phoneNo) {
		final String sql = "select tblPat.PatNumber from tblCar inner join tblPat on tblCar.CurrPatNumber = tblPat.taskNumber where tblCar.CarPadSim=?";

		String patNumber = getHibernateTemplate().execute(new HibernateCallback<String>(){
			public String doInHibernate(Session s)
					throws HibernateException, SQLException {
				String carNo = null;
				SQLQuery q = s.createSQLQuery(sql);
				q.setString(0, phoneNo);
				List<String> data = q.list();
				
				if (data.size()>0)
					carNo = data.get(0);
				return carNo;
			}
		});
		return patNumber;
	}
}
