package com.sinba.faph.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sinba.common.util.StringUtils;
import com.sinba.faph.dao.CaseInfoDao;
import com.sinba.faph.dao.FAPHDao;
import com.sinba.faph.entity.CaseInformation;
import com.sinba.faph.entity.DrugInfo;
import com.sinba.faph.entity.FirstAidPatientHistory;
import org.apache.commons.*;

@Transactional()
public class FAPHService {

	@Autowired
	private FAPHDao faphDao;
	@Autowired
	private CaseInfoDao caseInfoDao;
	
	@Transactional
	public void merge(FirstAidPatientHistory entity) {
		if (!StringUtils.hasText(entity.getPhNo())) {
			entity.setPhNo(faphDao.dayCount());
		}
		faphDao.merge(entity);
		faphDao.updateTblCar(entity.getPhNo(), entity.getCarNo());
	}
	
	@Transactional()
	public FirstAidPatientHistory get(String phNo) {
		return faphDao.findById(phNo);
	}

	@Transactional()
	public List<Map> findEnums(final Integer enumType) {
		return faphDao.findEnums(enumType);
	}
	
	@Transactional()
	public List<Map> findHospitalEmps(final int pos, final int hospitalId) {
		return faphDao.findHospitalEmps(pos, hospitalId);
	}
	
	@Transactional()
	public List<Map> findHospitals() {
		return faphDao.findHospitals();
	}
	
	@Transactional()
	public List<DrugInfo> findDrugs() {
		return faphDao.findDrugs();
	}
	
	@Transactional()
	public List<CaseInformation> findCaseInfos(final String caseName) {
		return caseInfoDao.findCaseInfos(caseName);
	}
	
	@Transactional()
	public List<String> findCaseNames() {
		return caseInfoDao.findCaseNames();
	}
	
	@Transactional()
	public List<Map> findParentCases() {
		return caseInfoDao.findParentCases();
	}
	
	@Transactional()
	public Map findCaseMap() {
		Map m = new HashMap();
		List<CaseInformation> parents = caseInfoDao.findParentCaseInfos();
		for (CaseInformation c : parents) {
			String caseName = c.getCaseName();
			List<CaseInformation> cases = caseInfoDao.findCaseInfos(caseName);
			m.put(caseName, cases);
		}
		return m;
	}

	
	public Object[] findCarNoByPhoneNo(final String phoneNo) {
		return faphDao.findCarNoByPhoneNo(phoneNo);
	}
	
	public String findCarCurrPatNumByPhoneNo(final String phoneNo) {
	
		return faphDao.findCarCurrPatNumByPhoneNo(phoneNo);
	}
	
	public String findCarCurrPatNumByPhoneNoNew(final String phoneNo) {
		
		return faphDao.findCarCurrPatNumByPhoneNoNew(phoneNo);
	}
}
