package com.sinba.faph.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.compass.core.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sinba.faph.entity.CaseInformation;
import com.sinba.faph.entity.DrugInfo;
import com.sinba.faph.entity.FirstAidPatientHistory;
import com.sinba.faph.service.FAPHService;

public class FAPHAction extends ActionSupport {
	@Autowired
	private FAPHService faphService;
	private String phNo;
	private String phoneNo;
	private Integer pos;
	private Integer hospitalId;
	private Integer enumType;
	private List<Map> options;
	private List<DrugInfo> drugs;
	private String caseName;
	private List<String> caseNames;
	private List<CaseInformation> caseInfos;
	private Map caseMap;
	private String carNo;
	
	private String carLic;

	public String getCarLic() {
		return carLic;
	}

	public void setCarLic(String carLic) {
		this.carLic = carLic;
	}

	private Map variables = new HashMap();

	public Map getVariables() {
		return variables;
	}

	public void setVariables(Map variables) {
		this.variables = variables;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Map getCaseMap() {
		return caseMap;
	}

	public void setCaseMap(Map caseMap) {
		this.caseMap = caseMap;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public List<String> getCaseNames() {
		return caseNames;
	}

	public void setCaseNames(List<String> caseNames) {
		this.caseNames = caseNames;
	}

	public List<CaseInformation> getCaseInfos() {
		return caseInfos;
	}

	public void setCaseInfos(List<CaseInformation> caseInfos) {
		this.caseInfos = caseInfos;
	}

	public Integer getEnumType() {
		return enumType;
	}

	public void setEnumType(Integer enumType) {
		this.enumType = enumType;
	}

	public List<DrugInfo> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<DrugInfo> drugs) {
		this.drugs = drugs;
	}

	public List<Map> getOptions() {
		return options;
	}

	public void setOptions(List<Map> options) {
		this.options = options;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	private FirstAidPatientHistory faph;

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public FirstAidPatientHistory getFaph() {
		return faph;
	}

	public void setFaph(FirstAidPatientHistory faph) {
		this.faph = faph;
	}

	public String save() {
		faphService.merge(faph);
		// System.out.println("phNo: "+faph.getPhNo());
		ActionContext.getContext().getApplication()
				.put(faph.getPhoneNo(), faph);
		phNo = faph.getPhNo();
		return "saveSuccess";
	}

	public String get() {
		faph = faphService.get(phNo);
		return SUCCESS;
	}

	public String findByPhone() {
		Map<String, Object> app = ActionContext.getContext().getApplication();
		if (app.containsKey(phoneNo)) {
			faph = (FirstAidPatientHistory) app.get(phoneNo);
			faph = faphService.get(faph.getPhNo());
		}
		return SUCCESS;
	}

	public String RefreshByPhone() {

		if (faphService.findCarCurrPatNumByPhoneNoNew(phoneNo)!=null) {

			faph = faphService.get(faphService
					.findCarCurrPatNumByPhoneNoNew(phoneNo));			
		}

		return SUCCESS;
	}

	public String findEnums() {
		options = faphService.findEnums(enumType);
		return "options";
	}

	public String findHospitals() {
		options = faphService.findHospitals();
		return "options";
	}

	public String findHospitalEmps() {
		options = faphService.findHospitalEmps(pos, hospitalId);
		return "options";
	}

	public String findDrugs() {
		drugs = faphService.findDrugs();
		return "drugs";
	}

	public String findParentCases() {
		options = faphService.findParentCases();
		return "options";
	}

	public String findCaseInfos() {
		caseInfos = faphService.findCaseInfos(caseName);
		return "caseInfos";
	}

	public String findCaseMap() {
		caseMap = faphService.findCaseMap();
		return "caseMap";
	}

	public String findCarNo() {
		Object[] data = faphService.findCarNoByPhoneNo(phoneNo);
		if (data != null) {
			carNo = ((Number) data[0]).toString();
			if (data[1] != null)
				hospitalId = Integer.valueOf((String) data[1]);
			if(data[2]!=null)
				carLic = data[2].toString();
		}
		return "carNo";
	}

	public String findAllOptions() {
		variables.put("stationName", faphService.findEnums(4));
		variables.put("taskType", faphService.findEnums(5));
		variables.put("firstAidEffect", faphService.findEnums(6));
		variables.put("allergyHistory", faphService.findEnums(7));
		variables.put("mind", faphService.findEnums(8));
		variables.put("primaryDiagnosis", faphService.findEnums(9));

		List<Map> hos = faphService.findHospitals();
		if (!CollectionUtils.isEmpty(hos)) {
			variables.put("hospitals", hos);
			// Integer hospitalId = (Integer) ((Map)hos.get(0)).get("value");
			// variables.put("driver", faphService.findHospitalEmps(100001,
			// hospitalId));
			// variables.put("doctor", faphService.findHospitalEmps(100002,
			// hospitalId));
			// variables.put("nurse", faphService.findHospitalEmps(100003,
			// hospitalId));
		}
		variables.put("drugs", faphService.findDrugs());
		variables.put("parentCases", faphService.findParentCases());
		variables.put("caseMap", faphService.findCaseMap());
		if (phoneNo != null) {
			variables.put("drugs", faphService.findCarNoByPhoneNo(phoneNo));
		}

		return "allOptions";
	}

	public String findAllEmps() {

		variables.put("driver",
				faphService.findHospitalEmps(100001, hospitalId));
		variables.put("doctor",
				faphService.findHospitalEmps(100002, hospitalId));
		variables
				.put("nurse", faphService.findHospitalEmps(100003, hospitalId));
		variables.put("stretcher",
				faphService.findHospitalEmps(100004, hospitalId));

		return "allOptions";
	}
}
