package com.sinba.faph.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;

//import org.apache.commons.lang.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.*;

//import com.sinba.common.dao.BaseDAOImplHibernate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sinba.faph.entity.CarInfo;

public class CarDao extends HibernateDaoSupport {

	public List<CarInfo> GetCarList(Integer userId) throws HibernateException,
			SQLException {
		String hql = "SELECT CarID ,tc.CarNumber ,CarMonitorSim ,CarVideoSim ,CarPadSim, Online ,CarLic, CurrPatNumber,CarVideoCom1, tp.PatId, tp.PatName,tp.PatSex,tp.PatAge FROM tblCar tc  inner join (SELECT OBJECTID as HosId FROM EP_QX_OBJECT_CONTROLLIST501 A WHERE  A.ORGID = -1  AND roleid in (select roleid from EP_QX_USER_TO_ROLE where userid="
				+ userId
				+ ") AND A.CLASSID = 501) hos on tc.CarHospital = hos.HosId LEFT JOIN tblPat tp ON tc.CurrPatNumber = tp.PatNumber WHERE CarMonitorSim IS NOT NULL ORDER BY tc.CarNumber asc";
		return excuteSqlQueryKeepColumnName(hql);
	}

	public List GetTopCarList(Integer userId) throws HibernateException,
			SQLException {
		String hql = "SELECT top 4 CarID ,tc.CarNumber ,CarMonitorSim ,CarVideoSim ,CarPadSim, Online ,CarLic, CurrPatNumber,CarVideoCom1, tp.PatId, tp.PatName,tp.PatSex,tp.PatAge FROM tblCar tc  inner join (SELECT OBJECTID as HosId FROM EP_QX_OBJECT_CONTROLLIST501 A WHERE  A.ORGID = -1  AND roleid in (select roleid from EP_QX_USER_TO_ROLE where userid="
				+ userId
				+ ") AND A.CLASSID = 501) hos on tc.CarHospital = hos.HosId LEFT JOIN tblPat tp ON tc.CurrPatNumber = tp.PatNumber WHERE CarMonitorSim IS NOT NULL ORDER BY tc.CarNumber asc";
		return excuteSqlQueryKeepColumnName(hql);
	}

	public List GetOnlineCarList(Integer userId) throws HibernateException,
			SQLException {
		String hql = "SELECT CarID ,tc.CarNumber ,CarMonitorSim ,CarVideoSim ,CarPadSim, Online ,CarLic, CurrPatNumber,CarVideoCom1, tp.PatId, tp.PatName,tp.PatSex,tp.PatAge FROM tblCar tc  inner join (SELECT OBJECTID as HosId FROM EP_QX_OBJECT_CONTROLLIST501 A WHERE  A.ORGID = -1  AND roleid in (select roleid from EP_QX_USER_TO_ROLE where userid="
				+ userId
				+ ") AND A.CLASSID = 501) hos on tc.CarHospital = hos.HosId LEFT JOIN tblPat tp ON tc.CurrPatNumber = tp.PatNumber WHERE CarMonitorSim IS NOT NULL and online = 1 ORDER BY tc.CarNumber asc";
		return excuteSqlQueryKeepColumnName(hql);

	}

	public List GetOnlineCarListToSpin(Integer userId)
			throws HibernateException, SQLException {
		String hql = "SELECT tc.CarNumber,CarLic,CarMonitorSim,CarLic, CurrPatNumber,CarVideoCom1, tp.PatId, tp.PatName,tp.PatSex,tp.PatAge FROM tblCar tc  inner join (SELECT OBJECTID as HosId FROM EP_QX_OBJECT_CONTROLLIST501 A WHERE  A.ORGID = -1  AND roleid in (select roleid from EP_QX_USER_TO_ROLE where userid="
				+ userId
				+ ") AND A.CLASSID = 501) hos on tc.CarHospital = hos.HosId LEFT JOIN tblPat tp ON tc.CurrPatNumber = tp.PatNumber WHERE CarMonitorSim IS NOT NULL ORDER BY tc.CarNumber asc";
		return excuteSqlQueryKeepColumnName(hql);
	}

	public List GetCarByCarNumber(Integer carNo) throws HibernateException,
			SQLException {
		String hql = "SELECT CarID ,tc.CarNumber ,CarMonitorSim ,CarVideoSim ,CarPadSim, Online ,CarLic, CurrPatNumber,CarVideoCom1, tp.PatId, tp.PatName,tp.PatSex,tp.PatAge FROM tblCar tc  LEFT JOIN tblPat tp ON tc.CurrPatNumber = tp.PatNumber where tc.CarNumber ="
				+ carNo.toString();
		return excuteSqlQueryKeepColumnName(hql);
	}

	public List GetPatInfo(String patNum) throws HibernateException,
			SQLException {
		String hql = "SELECT patNumber,PatName,PatSex,PatAge,patHeight, patBlood, patJob, patContact, scenePhone,sceneAddress FROM tblpat WHERE PatNumber='"
				+ patNum + "'";
		return excuteSqlQueryKeepColumnName(hql);
	}

	public List GetPatPager(Integer start, Integer end, String condition,
			String sort) throws HibernateException, SQLException {
		String hql = "{call SP_tblPat_Pagination(?,?,?,?)}";
		return excuteProcedureKeepColumnName(hql, start, end, condition, sort);
	}

	public List GetDataPager(Integer start, Integer end, Integer carNumber,
			String startTime, String endTime, Integer timeSeq)
			throws HibernateException, SQLException {
		/*
		 * @StartRow = #StartRow#,
		 * 
		 * @EndRow = #EndRow#,
		 * 
		 * @CarNumber = #CarNumber#,
		 * 
		 * @BeginTime = #BeginTime#,
		 * 
		 * @EndTime = #EndTime#,
		 * 
		 * @TimeSeq = #TimeSeq#
		 */
		String hql = "{call SP_History_bak_CreateTrendPage(?,?,?,?,?,?)}";
		if ("null".equals(endTime) || "".equals(endTime) || endTime == null) {
			
			SimpleDateFormat bartDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			endTime = bartDateFormat.format(new Date());
			hql = "{call SP_History_CreateTrendPage(?,?,?,?,?,?)}";
		}

		return excuteProcedureKeepColumnName(hql, start, end, carNumber,
				startTime, endTime, timeSeq);
	}

	public List excuteProcedureKeepColumnName(String sql, Integer start,
			Integer end, Integer carNumber, String startTime, String endTime,
			Integer timeSeq) throws HibernateException, SQLException {
		//logger.debug("querySql:" + sql + " start: " + start + " end: " + end
		//		+ " carNumber: " + carNumber + " timeSeq: " + timeSeq
		//		+ " StartTime" + startTime + " EndTime:" + endTime);
		List rows = null;
		Session session = getSession();
		@SuppressWarnings("deprecation")
		//Connection conn = session.connection();
		Connection conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ps.setInt(3, carNumber);
		ps.setString(4, startTime);
		ps.setString(5, endTime);
		ps.setInt(6, timeSeq);
		sql = sql.toLowerCase();
		ResultSet rs = null;
		rs = ps.executeQuery();

		rows = getTableRowsFromRs(rs);
		ps.close();
		return rows;
	}

	public List GetAlarmPager(Integer start, Integer end, String condition,
			String sort) throws HibernateException, SQLException {
		/*
		 * @startrow=#startrow#,
		 * 
		 * @endrow =#endrow#,
		 * 
		 * @condition=#condition#,
		 * 
		 * @sort=#sort#
		 */
		String hql = "{call SP_tblAlarm_Pagination(?,?,?,?)}";

		return excuteProcedureKeepColumnName(hql, start, end, condition, sort);
	}

	public List excuteSqlQueryKeepColumnName(String sql)
			throws HibernateException, SQLException {
		//logger.debug("querySql:" + sql);
		List rows = null;
		Session session = getSession();
		@SuppressWarnings("deprecation")
		//Connection conn = session.connection();
		Connection conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		sql = sql.toLowerCase();
		ResultSet rs = null;
		rs = ps.executeQuery();

		rows = getTableRowsFromRs(rs);
		ps.close();
		return rows;
	}

	public List excuteProcedureKeepColumnName(String sql, Integer start,
			Integer end, String condition, String sort)
			throws HibernateException, SQLException {
		//logger.debug("querySql:" + sql + " start: " + start + " end: " + end
		//		+ " condition: " + condition + " sort: " + sort);
		List rows = null;
		Session session = getSession();
		@SuppressWarnings("deprecation")
		//Connection conn = session.connection();
		Connection conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ps.setString(3, condition);
		ps.setString(4, sort);
		sql = sql.toLowerCase();
		ResultSet rs = null;
		rs = ps.executeQuery();

		rows = getTableRowsFromRs(rs);
		ps.close();
		return rows;
	}

	private List getTableRowsFromRs(ResultSet rs) throws SQLException {
		ColNamesAndTypes columnNamesAndTypes = getResultSetColumnNamesAndTypes(rs);
		List columnTypes = columnNamesAndTypes.getColumnTypes();
		List columnNames = columnNamesAndTypes.getColumnNames();
		List rows = new ArrayList();

		while (rs.next()) {
			HashMap row = new HashMap();
			int colcount = columnNames.size();
			for (int i = 0; i < colcount; i++) {
				String colname = columnNames.get(i).toString();
				String coltype = columnTypes.get(i).toString();

//				if (coltype.toLowerCase().indexOf("date") >= 0) {
//					row.put(colname, rs.getTimestamp(colname));
//				} else {
					row.put(colname, rs.getString(colname));
//				}
			}
			rows.add(row);
		}

		return rows;
	}

	private ColNamesAndTypes getResultSetColumnNamesAndTypes(ResultSet rs)
			throws SQLException {
		ColNamesAndTypes columnNamesAndTypes = new ColNamesAndTypes();
		List<String> columnTypes = new ArrayList<String>();
		List<String> columnNames = new ArrayList<String>();

		// get a reference to the ResultSet's meta data
		ResultSetMetaData md = rs.getMetaData();

		int count = md.getColumnCount();

		for (int x = 0; x < count; x++) {
			columnTypes.add(md.getColumnTypeName(x + 1));
			columnNames.add(md.getColumnName(x + 1));
		}

		columnNamesAndTypes.setColumnNames(columnNames);
		columnNamesAndTypes.setColumnTypes(columnTypes);
		return columnNamesAndTypes;
	}

	@SuppressWarnings("unchecked")
	private class ColNamesAndTypes {
		private List columnTypes;

		private List columnNames;

		public void setColumnTypes(List columnTypes) {
			this.columnTypes = columnTypes;
		}

		public List getColumnTypes() {
			return this.columnTypes;
		}

		public void setColumnNames(List columnNames) {
			this.columnNames = columnNames;
		}

		public List getColumnNames() {
			return this.columnNames;
		}
	}

}
