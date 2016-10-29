package com.sinba.faph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DrugList")
public class DrugInfo implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long drugId;
	private String drugName;
	private String engName;
	private Integer dosage;
	private String dosageUnit;
	private String usage;
	//add---2012-09-24---
	private String type;
	private Integer PNumber;
	private Integer JNumber;
	private String Note;
	public Integer getPNumber() {
		return PNumber;
	}
	public void setPNumber(Integer pNumber) {
		PNumber = pNumber;
	}
	public Integer getJNumber() {
		return JNumber;
	}
	public void setJNumber(Integer jNumber) {
		JNumber = jNumber;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getDrugId() {
		return drugId;
	}
	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public Integer getDosage() {
		return dosage;
	}
	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}
	public String getDosageUnit() {
		return dosageUnit;
	}
	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	
}
