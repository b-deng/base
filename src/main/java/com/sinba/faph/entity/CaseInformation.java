package com.sinba.faph.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.struts2.json.annotations.JSON;

@Entity
public class CaseInformation {
@Id
@Column(name="ID")
@GeneratedValue(strategy=GenerationType.AUTO)
private Long caseNo;
@ManyToOne()
@JoinColumn(name="parentId")
private CaseInformation parent;
@OneToMany()
@JoinColumn(name="parentId")
private List<CaseInformation> children;
private String caseName;
@Lob
private String caseContent;

@JSON(serialize=false)
public List<CaseInformation> getChildren() {
	return children;
}
public void setChildren(List<CaseInformation> children) {
	this.children = children;
}
private String otherDo;
public Long getCaseNo() {
	return caseNo;
}
public void setCaseNo(Long caseNo) {
	this.caseNo = caseNo;
}

@JSON(serialize=false)
public CaseInformation getParent() {
	return parent;
}
public void setParent(CaseInformation parent) {
	this.parent = parent;
}
public String getCaseName() {
	return caseName;
}
public void setCaseName(String caseName) {
	this.caseName = caseName;
}
@JSON(serialize=false)
public String getCaseContent() {
	return caseContent;
}
public void setCaseContent(String caseContent) {
	this.caseContent = caseContent;
}
public String getOtherDo() {
	return otherDo;
}
public void setOtherDo(String otherDo) {
	this.otherDo = otherDo;
}

}
