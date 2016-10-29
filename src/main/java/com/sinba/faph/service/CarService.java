package com.sinba.faph.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

//import com.sinba.common.util.StringUtils;
import com.sinba.faph.dao.CarDao;
import com.sinba.faph.dao.FAPHDao;

import com.sinba.faph.entity.CarInfo;
import com.sinba.faph.entity.DrugInfo;


public class CarService {
	@Autowired
	private CarDao carDao;
	@Transactional()
	public List findCars(Integer userId) throws HibernateException, SQLException {
		return carDao.GetCarList(userId);
	}
	@Transactional()
	public List GetTopCarList(Integer userId) throws HibernateException, SQLException
	{
		return carDao.GetTopCarList(userId);
	}
	@Transactional()
	public List GetOnlineCarList(Integer userId) throws HibernateException, SQLException
	{
		return carDao.GetOnlineCarList(userId);
	}
	@Transactional()
	public List GetOnlineCarListToSpin(Integer userId) throws HibernateException, SQLException
	{
		return carDao.GetOnlineCarListToSpin(userId);
	}
	@Transactional()
	public List GetCarByCarNumber(Integer carNo) throws HibernateException, SQLException
	{
		return carDao.GetCarByCarNumber(carNo);
	}
	@Transactional()
	public List GetPatInfo(String patNum) throws HibernateException, SQLException
	{	
		return carDao.GetPatInfo(patNum);
	}
	@Transactional()
	public List GetPatPager(Integer start,Integer end,String condition,String sort) throws HibernateException, SQLException
	{
		return carDao.GetPatPager(start,end,condition,sort);
	}
	@Transactional()
	public List GetAlarmPager(Integer start,Integer end,String condition,String sort) throws HibernateException, SQLException
	{
		return carDao.GetAlarmPager(start,end,condition,sort);
	}
	@Transactional()
	public List GetDataPager(Integer start,Integer end,Integer carNumber,String startTime,String endTime,Integer timeSeq) throws HibernateException, SQLException
	{
		return carDao.GetDataPager(start,end,carNumber,startTime,endTime,timeSeq);
	}
}
