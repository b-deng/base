package com.sinba.faph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblCar")
public class CarInfo  implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer CarID;	
	public Integer getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(Integer carNumber) {
		CarNumber = carNumber;
	}
	public String getCarMonitorSim() {
		return CarMonitorSim;
	}
	public void setCarMonitorSim(String carMonitorSim) {
		CarMonitorSim = carMonitorSim;
	}
	public String getCarVideoSim() {
		return CarVideoSim;
	}
	public void setCarVideoSim(String carVideoSim) {
		CarVideoSim = carVideoSim;
	}
	public String getCarPadSim() {
		return CarPadSim;
	}
	public void setCarPadSim(String carPadSim) {
		CarPadSim = carPadSim;
	}
	public String getCarLic() {
		return CarLic;
	}
	public void setCarLic(String carLic) {
		CarLic = carLic;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public Integer getCarColor() {
		return CarColor;
	}
	public void setCarColor(Integer carColor) {
		CarColor = carColor;
	}
	public String getCarHospital() {
		return CarHospital;
	}
	public void setCarHospital(String carHospital) {
		CarHospital = carHospital;
	}
	public Integer getOnline() {
		return Online;
	}
	public void setOnline(Integer online) {
		Online = online;
	}
	public Integer getCarVideoCom1() {
		return CarVideoCom1;
	}
	public void setCarVideoCom1(Integer carVideoCom1) {
		CarVideoCom1 = carVideoCom1;
	}
	public Integer getCarVideoCom2() {
		return CarVideoCom2;
	}
	public void setCarVideoCom2(Integer carVideoCom2) {
		CarVideoCom2 = carVideoCom2;
	}
	public Integer getCurrPatNumber() {
		return CurrPatNumber;
	}
	public void setCurrPatNumber(Integer currPatNumber) {
		CurrPatNumber = currPatNumber;
	}
	public Integer getCarVideoCom3() {
		return CarVideoCom3;
	}
	public void setCarVideoCom3(Integer carVideoCom3) {
		CarVideoCom3 = carVideoCom3;
	}
	public Integer getCarID() {
		return CarID;
	}
	public void setCarID(Integer carID) {
		CarID = carID;
	}
	private Integer CarNumber;	
	private String CarMonitorSim;
	private String CarVideoSim;
	private String CarPadSim;
	private String CarLic;
	private String CarType;
	private Integer CarColor;
	private String CarHospital;
	private Integer Online;
	private Integer CarVideoCom1;
	private Integer CarVideoCom2;
	private Integer CurrPatNumber;
	private Integer CarVideoCom3;

}
