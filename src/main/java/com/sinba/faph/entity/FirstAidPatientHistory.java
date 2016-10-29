package com.sinba.faph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="tblPat")
public class FirstAidPatientHistory implements java.io.Serializable {
//--------������Ϣ--------------

public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public Long getVersion() {
	return version;
}
public void setVersion(Long version) {
	this.version = version;
}
public String getPhNo() {
	return phNo;
}
public void setPhNo(String phNo) {
	this.phNo = phNo;
}
public String getFirstAidStationName() {
	return firstAidStationName;
}
public void setFirstAidStationName(String firstAidStationName) {
	this.firstAidStationName = firstAidStationName;
}
public String getTaskType() {
	return taskType;
}
public void setTaskType(String taskType) {
	this.taskType = taskType;
}
public Boolean getImportantEvent() {
	return importantEvent;
}
public void setImportantEvent(Boolean importantEvent) {
	this.importantEvent = importantEvent;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public Integer getPatientAge() {
	return patientAge;
}
public void setPatientAge(Integer patientAge) {
	this.patientAge = patientAge;
}
public String getPatientGender() {
	return patientGender;
}
public void setPatientGender(String patientGender) {
	this.patientGender = patientGender;
}
public String getSceneAddress() {
	return sceneAddress;
}
public void setSceneAddress(String sceneAddress) {
	this.sceneAddress = sceneAddress;
}
public String getScenePhone() {
	return scenePhone;
}
public void setScenePhone(String scenePhone) {
	this.scenePhone = scenePhone;
}
public String getFirstAidEffect() {
	return firstAidEffect;
}
public void setFirstAidEffect(String firstAidEffect) {
	this.firstAidEffect = firstAidEffect;
}
public String getDestHospital() {
	return destHospital;
}
public void setDestHospital(String destHospital) {
	this.destHospital = destHospital;
}
public String getCarNo() {
	return carNo;
}
public void setCarNo(String carNo) {
	this.carNo = carNo;
}
public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
public String getNurseName() {
	return nurseName;
}
public void setNurseName(String nurseName) {
	this.nurseName = nurseName;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public Date getCarOutTime() {
	return carOutTime;
}
public void setCarOutTime(Date carOutTime) {
	this.carOutTime = carOutTime;
}
public Date getCarBackTime() {
	return carBackTime;
}
public void setCarBackTime(Date carBackTime) {
	this.carBackTime = carBackTime;
}
public Date getArriveSceneTime() {
	return arriveSceneTime;
}
public void setArriveSceneTime(Date arriveSceneTime) {
	this.arriveSceneTime = arriveSceneTime;
}
public Date getArriveDestTime() {
	return arriveDestTime;
}
public void setArriveDestTime(Date arriveDestTime) {
	this.arriveDestTime = arriveDestTime;
}
public String getChiefComplaint() {
	return chiefComplaint;
}
public void setChiefComplaint(String chiefComplaint) {
	this.chiefComplaint = chiefComplaint;
}
public String getPresentHistory() {
	return presentHistory;
}
public void setPresentHistory(String presentHistory) {
	this.presentHistory = presentHistory;
}
public String getPastHistory() {
	return pastHistory;
}
public void setPastHistory(String pastHistory) {
	this.pastHistory = pastHistory;
}
public String getAllergyHistory() {
	return allergyHistory;
}
public void setAllergyHistory(String allergyHistory) {
	this.allergyHistory = allergyHistory;
}
public Float getTemperature() {
	return temperature;
}
public void setTemperature(Float temperature) {
	this.temperature = temperature;
}
public Integer getPulse() {
	return pulse;
}
public void setPulse(Integer pulse) {
	this.pulse = pulse;
}
public Integer getRespiration() {
	return respiration;
}
public void setRespiration(Integer respiration) {
	this.respiration = respiration;
}
public Integer getMaxBloodPressure() {
	return maxBloodPressure;
}
public void setMaxBloodPressure(Integer maxBloodPressure) {
	this.maxBloodPressure = maxBloodPressure;
}
public Integer getMinBloodPressure() {
	return minBloodPressure;
}
public void setMinBloodPressure(Integer minBloodPressure) {
	this.minBloodPressure = minBloodPressure;
}
public String getMind() {
	return mind;
}
public void setMind(String mind) {
	this.mind = mind;
}
public Float getLeftPupil() {
	return leftPupil;
}
public void setLeftPupil(Float leftPupil) {
	this.leftPupil = leftPupil;
}
public Float getRightPupil() {
	return rightPupil;
}
public void setRightPupil(Float rightPupil) {
	this.rightPupil = rightPupil;
}
public String getPupilRemark() {
	return pupilRemark;
}
public void setPupilRemark(String pupilRemark) {
	this.pupilRemark = pupilRemark;
}
public String getLightReflex() {
	return lightReflex;
}
public void setLightReflex(String lightReflex) {
	this.lightReflex = lightReflex;
}
public String getHeadAndNeck() {
	return headAndNeck;
}
public void setHeadAndNeck(String headAndNeck) {
	this.headAndNeck = headAndNeck;
}
public String getHeart() {
	return heart;
}
public void setHeart(String heart) {
	this.heart = heart;
}
public String getLung() {
	return lung;
}
public void setLung(String lung) {
	this.lung = lung;
}
public String getChest() {
	return chest;
}
public void setChest(String chest) {
	this.chest = chest;
}
public String getAbdmon() {
	return abdmon;
}
public void setAbdmon(String abdmon) {
	this.abdmon = abdmon;
}
public String getExtremitiesAndSpine() {
	return extremitiesAndSpine;
}
public void setExtremitiesAndSpine(String extremitiesAndSpine) {
	this.extremitiesAndSpine = extremitiesAndSpine;
}
public String getCardiogram() {
	return cardiogram;
}
public void setCardiogram(String cardiogram) {
	this.cardiogram = cardiogram;
}
public String getGlu() {
	return glu;
}
public void setGlu(String glu) {
	this.glu = glu;
}
public String getSpo2() {
	return spo2;
}
public void setSpo2(String spo2) {
	this.spo2 = spo2;
}
public String getPhyChkOther() {
	return phyChkOther;
}
public void setPhyChkOther(String phyChkOther) {
	this.phyChkOther = phyChkOther;
}
public String getPrimaryDiagnosis() {
	return primaryDiagnosis;
}
public void setPrimaryDiagnosis(String primaryDiagnosis) {
	this.primaryDiagnosis = primaryDiagnosis;
}
public String getIllnessJudgement() {
	return illnessJudgement;
}
public void setIllnessJudgement(String illnessJudgement) {
	this.illnessJudgement = illnessJudgement;
}
public List<Medication> getMedications() {
	return medications;
}
public void setMedications(List<Medication> medications) {
	this.medications = medications; 
}
public String getPatientConditionChange() {
	return patientConditionChange;
}
public void setPatientConditionChange(String patientConditionChange) {
	this.patientConditionChange = patientConditionChange;
}
public Boolean getOxgenUptake() {
	return oxgenUptake;
}
public void setOxgenUptake(Boolean oxgenUptake) {
	this.oxgenUptake = oxgenUptake;
}
public Boolean getBindup() {
	return bindup;
}
public void setBindup(Boolean bindup) {
	this.bindup = bindup;
}
public Boolean getFixup() {
	return fixup;
}
public void setFixup(Boolean fixup) {
	this.fixup = fixup;
}
public Boolean getNeckCollar() {
	return neckCollar;
}
public void setNeckCollar(Boolean neckCollar) {
	this.neckCollar = neckCollar;
}
public Boolean getCardiopulmonaryResuscitation() {
	return cardiopulmonaryResuscitation;
}
public void setCardiopulmonaryResuscitation(Boolean cardiopulmonaryResuscitation) {
	this.cardiopulmonaryResuscitation = cardiopulmonaryResuscitation;
}
public Boolean getWithLiquid() {
	return withLiquid;
}
public void setWithLiquid(Boolean withLiquid) {
	this.withLiquid = withLiquid;
}
public Boolean getAccounche() {
	return accounche;
}
public void setAccounche(Boolean accounche) {
	this.accounche = accounche;
}
public Boolean getPhysicalCool() {
	return physicalCool;
}
public void setPhysicalCool(Boolean physicalCool) {
	this.physicalCool = physicalCool;
}
public Boolean getRhinalWad() {
	return rhinalWad;
}
public void setRhinalWad(Boolean rhinalWad) {
	this.rhinalWad = rhinalWad;
}
public Boolean getSpray() {
	return spray;
}
public void setSpray(Boolean spray) {
	this.spray = spray;
}
public Boolean getShovelStretcher() {
	return shovelStretcher;
}
public void setShovelStretcher(Boolean shovelStretcher) {
	this.shovelStretcher = shovelStretcher;
}
public Boolean getDoCardiogram() {
	return doCardiogram;
}
public void setDoCardiogram(Boolean doCardiogram) {
	this.doCardiogram = doCardiogram;
}
public Boolean getDefibrillation() {
	return defibrillation;
}
public void setDefibrillation(Boolean defibrillation) {
	this.defibrillation = defibrillation;
}
public Boolean getAspirationOfSputum() {
	return aspirationOfSputum;
}
public void setAspirationOfSputum(Boolean aspirationOfSputum) {
	this.aspirationOfSputum = aspirationOfSputum;
}
public Boolean getAirBed() {
	return airBed;
}
public void setAirBed(Boolean airBed) {
	this.airBed = airBed;
}
public Boolean getRespirator() {
	return respirator;
}
public void setRespirator(Boolean respirator) {
	this.respirator = respirator;
}
public Boolean getIntubatton() {
	return intubatton;
}
public void setIntubatton(Boolean intubatton) {
	this.intubatton = intubatton;
}
public Boolean getSacculus() {
	return sacculus;
}
public void setSacculus(Boolean sacculus) {
	this.sacculus = sacculus;
}
public Float getPreHospitalFee() {
	return preHospitalFee;
}
public void setPreHospitalFee(Float preHospitalFee) {
	this.preHospitalFee = preHospitalFee;
}
public Float getCardiopulmonaryFee() {
	return cardiopulmonaryFee;
}
public void setCardiopulmonaryFee(Float cardiopulmonaryFee) {
	this.cardiopulmonaryFee = cardiopulmonaryFee;
}
public Float getHemorrhoeaFee() {
	return hemorrhoeaFee;
}
public void setHemorrhoeaFee(Float hemorrhoeaFee) {
	this.hemorrhoeaFee = hemorrhoeaFee;
}
public Float getDrugFee() {
	return drugFee;
}
public void setDrugFee(Float drugFee) {
	this.drugFee = drugFee;
}
public Float getAmbulanceFee() {
	return ambulanceFee;
}
public void setAmbulanceFee(Float ambulanceFee) {
	this.ambulanceFee = ambulanceFee;
}
public Float getReceivableFee() {
	return receivableFee;
}
public void setReceivableFee(Float receivableFee) {
	this.receivableFee = receivableFee;
}
public Float getPaidUp() {
	return paidUp;
}
public void setPaidUp(Float paidUp) {
	this.paidUp = paidUp;
}
public String getInvoiceNo() {
	return invoiceNo;
}
public void setInvoiceNo(String invoiceNo) {
	this.invoiceNo = invoiceNo;
}
public String getOtherRemark() {
	return otherRemark;
}
public void setOtherRemark(String otherRemark) {
	this.otherRemark = otherRemark;
}
@Id
@Column(name="PatNumber")
private String phNo;//���
private String phoneNo; //�绰����
@Column(name="c_version")
private Long version;
private String firstAidStationName;//վ��
private String taskType;//�������
private Boolean importantEvent;//��Ҫ�¼�
@Column(name="PatName")
private String patientName;//����
@Column(name="PatAge")
private Integer patientAge;//����
@Column(name="PatSex")
private String patientGender;//�Ա�
private String sceneAddress;//�ֳ���ַ
private String scenePhone;//�绰
private String firstAidEffect;//����Ч��
private String destHospital;//Ŀ�ĵ�
private Integer destHospitalId;//Ŀ�ĵ�
@Column(name="CarNumber")
private String carNo;//����
private String driverName;//˾����
private String nurseName;//��ʿ��
@Column(name="PatDoctor")
private String doctorName;//ҽ����
private Date carOutTime;//����ʱ��
private Date carBackTime;//������ʱ��
private Date arriveSceneTime;//���ֳ�ʱ��
private Date arriveDestTime;//��Ŀ�ĵ�ʱ��
//----------��ʷ------------------
private String chiefComplaint;//����
private String presentHistory;//�ֲ�ʷ
private String pastHistory;//��ȥʷ
private String allergyHistory;//����ʷ
//----------���------------------
private Float temperature;//����
private Integer pulse;//����
private Integer respiration;//����
private Integer maxBloodPressure;//���Ѫѹ
private Integer minBloodPressure;//��СѪѹ
private String mind;//��־
private Float leftPupil;//��ͫ��
private Float rightPupil;//��ͫ��
private String pupilRemark;//ͫ�ױ�ע
private String lightReflex;//�Թⷴ��
private String headAndNeck;//ͷ����
private String heart;//����
private String lung;//˫��
private String chest;//�ز�
private String abdmon;//����
private String extremitiesAndSpine;//��֫������
private String cardiogram;//�ĵ�ͼ
private String glu;//Ѫ��
private String spo2;//Ѫ��
private String phyChkOther;//�������
//----------���------------------
private String primaryDiagnosis;//�������
private String parentCaseName; //�������
private String illnessJudgement;//�����ж�
//----------��ҩ------------------
@CollectionOfElements(fetch=FetchType.EAGER)
private List<Medication> medications;
private String patientConditionChange;//����仯
//----------��ѡ��----------------
private Boolean oxgenUptake;//����
private Boolean bindup;//����
private Boolean fixup;//�̶�
private Boolean neckCollar;//����
private Boolean cardiopulmonaryResuscitation;//�ķθ���
private Boolean withLiquid;//;�д�Һ
private Boolean accounche;//����
private Boolean physicalCool;//������
private Boolean rhinalWad;//��ǻ����
private Boolean spray;//��������
private Boolean shovelStretcher;//����
private Boolean doCardiogram;//���ĵ�ͼ
private Boolean defibrillation;//����
private Boolean aspirationOfSputum;//��̵
private Boolean airBed;//���洲
private Boolean respirator;//������
private Boolean intubatton;//���
private Boolean sacculus;//����
//---------���ü�����--------------
private Float preHospitalFee;//Ժǰ���ȷ�
private Float cardiopulmonaryFee;//�ķθ������ȷ�
private Float hemorrhoeaFee;//���Ѫ���÷�
private Float drugFee;//ҩ��
private Float ambulanceFee;//�Ȼ�����
private Float receivableFee;//Ӧ�շѺϼ�
private Float paidUp;//ʵ�շѺϼ�
private String invoiceNo;//��Ʊ���
private String otherRemark;//����

//--------add 2011-6-23------
@Column(updatable=false)
private Float patHeight; //���
@Column(updatable=false)
private String patJob; 	//ְҵ
@Column(updatable=false)
private String patBlood; //Ѫ��
@Column(updatable=false)
private Float patWeight; //	����
@Column(updatable=false)
private String patAddress; //סַ
@Lob
@Column(updatable=false)
private byte[] patPhoto; //ͼ��
@Column(updatable=false)
private String patContact; //��ϵ��ʽ
//--------add 2011-7-02------
@Column(updatable=false)
private String patHeal;//������������
private Date patAddTime = new Date(); //������ʱ�䣩��
private Date patSendTime; //������ʱ�䣩��
private Date patEndTime; //�����Ƚ���ʱ�䣩��
private Long gpsStartDataID;//��GPS�������ӱ�־����
private Long monitorStartDataID; //���໤���������ӱ�־��
//--------add 2011-7-03-------
@Column(updatable=false)
private Float destinaLat; //Ŀ�ĵ�γ��
@Column(updatable=false)
private Float destinaLng; //Ŀ�ĵؾ��� 
//--------add 2011-7-07-------
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(updatable=false,insertable=false)
private Long patId;
//--------add 2011-8-07-------
private String stretcher;	//����Ա
@Column(length=500)
private String patVideoFile1; //¼��1
@Column(length=500)
private String patVideoFile2; //¼��2
//add---2012-09-24---
private String emptyReason;//�ܿճ�ԭ��
private Integer patNeutral;//������Ա
//add---2012-12-20---
private String AlterNumber;//������	varchar(50)	Checked
public String getAlterNumber() {
	return AlterNumber;
}
public void setAlterNumber(String alterNumber) {
	this.AlterNumber = alterNumber;
}
public String getEmptyReason() {
	return emptyReason;
}
private String TaskNumber;
public String getTaskNumber() {
	return TaskNumber;
}
public void setTaskNumber(String taskNumber) {
	TaskNumber = taskNumber;
}
public void setEmptyReason(String emptyReason) {
	this.emptyReason = emptyReason;
}
public Integer getPatNeutral() {
	return patNeutral;
}
public void setPatNeutral(Integer patNeutral) {
	this.patNeutral = patNeutral;
}
public String getStretcher() {
	return stretcher;
}
public void setStretcher(String stretcher) {
	this.stretcher = stretcher;
}
public String getPatVideoFile1() {
	return patVideoFile1;
}
public void setPatVideoFile1(String patVideoFile1) {
	this.patVideoFile1 = patVideoFile1;
}
public String getPatVideoFile2() {
	return patVideoFile2;
}
public void setPatVideoFile2(String patVideoFile2) {
	this.patVideoFile2 = patVideoFile2;
}
public Integer getDestHospitalId() {
	return destHospitalId;
}
public void setDestHospitalId(Integer destHospitalId) {
	this.destHospitalId = destHospitalId;
}
public String getParentCaseName() {
	return parentCaseName;
}
public void setParentCaseName(String parentCaseName) {
	this.parentCaseName = parentCaseName;
}
public Float getDestinaLat() {
	return destinaLat;
}
public void setDestinaLat(Float destinaLat) {
	this.destinaLat = destinaLat;
}
public Float getDestinaLng() {
	return destinaLng;
}
public void setDestinaLng(Float destinaLng) {
	this.destinaLng = destinaLng;
}
public Long getPatId() {
	return patId;
}
public void setPatId(Long patId) {
	this.patId = patId;
}
public String getPatHeal() {
	return patHeal;
}
public void setPatHeal(String patHeal) {
	this.patHeal = patHeal;
}
public Date getPatAddTime() {
	return patAddTime;
}
public void setPatAddTime(Date patAddTime) {
	this.patAddTime = patAddTime;
}
public Date getPatSendTime() {
	return patSendTime;
}
public void setPatSendTime(Date patSendTime) {
	this.patSendTime = patSendTime;
}
public Date getPatEndTime() {
	return patEndTime;
}
public void setPatEndTime(Date patEndTime) {
	this.patEndTime = patEndTime;
}
public Long getGpsStartDataID() {
	return gpsStartDataID;
}
public void setGpsStartDataID(Long gpsStartDataID) {
	this.gpsStartDataID = gpsStartDataID;
}
public Long getMonitorStartDataID() {
	return monitorStartDataID;
}
public void setMonitorStartDataID(Long monitorStartDataID) {
	this.monitorStartDataID = monitorStartDataID;
}
public Float getPatHeight() {
	return patHeight;
}
public void setPatHeight(Float patHeight) {
	this.patHeight = patHeight;
}
public String getPatJob() {
	return patJob;
}
public void setPatJob(String patJob) {
	this.patJob = patJob;
}
public String getPatBlood() {
	return patBlood;
}
public void setPatBlood(String patBlood) {
	this.patBlood = patBlood;
}
public Float getPatWeight() {
	return patWeight;
}
public void setPatWeight(Float patWeight) {
	this.patWeight = patWeight;
}
public String getPatAddress() {
	return patAddress;
}
public void setPatAddress(String patAddress) {
	this.patAddress = patAddress;
}
public byte[] getPatPhoto() {
	return patPhoto;
}
public void setPatPhoto(byte[] patPhoto) {
	this.patPhoto = patPhoto;
}
public String getPatContact() {
	return patContact;
}
public void setPatContact(String patContact) {
	this.patContact = patContact;
}

}
