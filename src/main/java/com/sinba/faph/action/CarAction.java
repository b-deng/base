package com.sinba.faph.action;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.compass.core.util.CollectionUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sinba.faph.entity.CarInfo;
import com.sinba.faph.service.CarService;


public class CarAction extends ActionSupport {
	@Autowired
	private CarService carService;
	private List<CarInfo> cars;
	
	private Integer userId;
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	private Integer carNo;

	public Integer getCarNo() {
		return carNo;
	}

	public void setCarNo(Integer carNo) {
		this.carNo = carNo;
	}
private Integer start;
public Integer getStart() {
	return start;
}

public void setStart(Integer start) {
	this.start = start;
}

public Integer getEnd() {
	return end;
}

public void setEnd(Integer end) {
	this.end = end;
}

public String getCondition() {
	return condition;
}

public void setCondition(String condition) {
	this.condition = condition;
}

public String getSort() {
	return sort;
}

public void setSort(String sort) {
	this.sort = sort;
}

private Integer end;
private String condition;
private String sort;
private String patNum;
public String getPatNum() {
	return patNum;
}

public void setPatNum(String patNum) {
	this.patNum = patNum;
}

private Integer carNumber;
public Integer getCarNumber() {
	return carNumber;
}

public void setCarNumber(Integer carNumber) {
	this.carNumber = carNumber;
}

public Integer getTimeSeq() {
	return timeSeq;
}

public void setTimeSeq(Integer timeSeq) {
	this.timeSeq = timeSeq;
}

private String startTime;
public String getStartTime() {
	return startTime;
}

public void setStartTime(String startTime) {
	this.startTime = startTime;
}

public String getEndTime() {
	return endTime;
}

public void setEndTime(String endTime) {
	this.endTime = endTime;
}

private String endTime;

private Integer timeSeq;
	public String findCars() {
		try {
			cars = carService.findCars(userId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
	
	public String findTopCars() {
		try {
			cars = carService.GetTopCarList(userId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
	
	public String findCarByCarNumber()
	{
		try {
			cars = carService.GetCarByCarNumber(carNo);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
	
	public String GetPatInfo() throws HibernateException, SQLException
	{	
		cars = carService.GetPatInfo(patNum);
		return "cars";
	}
	
	public String findOnlineCars() {
		try {
			cars = carService.GetOnlineCarList(userId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
	public String GetOnlineCarToSpin()
	{
		try {
			try {
				cars = carService.GetOnlineCarListToSpin(userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
public String GetPatPager()
	{
		try {
			try {
				try {
					condition = new String(condition.getBytes("iso-8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				cars = carService.GetPatPager(start,end,condition,sort);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cars";
	}
public String GetAlarmPager()
{
	try {
		cars = carService.GetAlarmPager(start,end,condition,sort);
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "cars";
}
public String GetDataPager()
{
	try {
		cars = carService.GetDataPager(start,end,carNumber,startTime,endTime,timeSeq);
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "cars";
}
	public List<CarInfo> getCars() {
		return cars;
	}

	public void setCars(List<CarInfo> cars) {
		this.cars = cars;
	}
}
