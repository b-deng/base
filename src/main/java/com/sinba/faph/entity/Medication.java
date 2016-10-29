package com.sinba.faph.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Medication implements java.io.Serializable {
private String drugName;
private String drugUsage;
private String drugDosage;
private String alarm; 
public String getDrugName() {
	return drugName;
}
public void setDrugName(String drugName) {
	this.drugName = drugName;
}
public String getDrugUsage() {
	return drugUsage;
}
public void setDrugUsage(String drugUsage) {
	this.drugUsage = drugUsage;
}
public String getDrugDosage() {
	return drugDosage;
}
public void setDrugDosage(String drugDosage) {
	this.drugDosage = drugDosage;
}
public String getAlarm() {
	return alarm;
}
public void setAlarm(String alarm) {
	this.alarm = alarm;
}
}