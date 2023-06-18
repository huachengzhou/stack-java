package org.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/9/24
 **/
public class HouseExample implements Serializable {
    private String realEstateWarrantNo;//房产权证号
    private String location;//所在地
    private String number;//编号
    private String type;//类型
    private String ownerOfTheHouse;//房屋所有权人
    private String commonSituation;//共有情况
    private double buildArea;//建筑面积
    private String houseLocated;//房屋坐落
    private String streetNumber;//街道号
    private String attachedNumber;//附号
    private String buildingNumber;//栋号
    private String unit;//单元
    private String floor;//楼层
    private String houseNumber;//房号
    private Date registrationTime;//登记时间
    private String nature;//性质
    private String purpose;//规划用途
    private long totalNumber;//总层数
    private double evidenceArea;//证载面积
    private double innerArea;//套内面积
    private String other;//其它
    private String landNumber;//土地证号
    private String landObtain;//土地取得方式
    private Date landUseStart;//土地使用年限起
    private Date landUseEnd;//土地使用年限止
    public double publicArea;//公摊面积
    private String otherNotes;//附记其它
    private String registrationAuthority;//登记机关
    private Date registrationDate;//登记日期

    public String getRealEstateWarrantNo() {
        return realEstateWarrantNo;
    }

    public void setRealEstateWarrantNo(String realEstateWarrantNo) {
        this.realEstateWarrantNo = realEstateWarrantNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerOfTheHouse() {
        return ownerOfTheHouse;
    }

    public void setOwnerOfTheHouse(String ownerOfTheHouse) {
        this.ownerOfTheHouse = ownerOfTheHouse;
    }

    public String getCommonSituation() {
        return commonSituation;
    }

    public void setCommonSituation(String commonSituation) {
        this.commonSituation = commonSituation;
    }

    public double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(double buildArea) {
        this.buildArea = buildArea;
    }

    public String getHouseLocated() {
        return houseLocated;
    }

    public void setHouseLocated(String houseLocated) {
        this.houseLocated = houseLocated;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAttachedNumber() {
        return attachedNumber;
    }

    public void setAttachedNumber(String attachedNumber) {
        this.attachedNumber = attachedNumber;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public double getEvidenceArea() {
        return evidenceArea;
    }

    public void setEvidenceArea(double evidenceArea) {
        this.evidenceArea = evidenceArea;
    }

    public double getInnerArea() {
        return innerArea;
    }

    public void setInnerArea(double innerArea) {
        this.innerArea = innerArea;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    public String getLandObtain() {
        return landObtain;
    }

    public void setLandObtain(String landObtain) {
        this.landObtain = landObtain;
    }

    public Date getLandUseStart() {
        return landUseStart;
    }

    public void setLandUseStart(Date landUseStart) {
        this.landUseStart = landUseStart;
    }

    public Date getLandUseEnd() {
        return landUseEnd;
    }

    public void setLandUseEnd(Date landUseEnd) {
        this.landUseEnd = landUseEnd;
    }

    public double getPublicArea() {
        return publicArea;
    }

    public void setPublicArea(double publicArea) {
        this.publicArea = publicArea;
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "HouseExample{" +
                "realEstateWarrantNo='" + realEstateWarrantNo + '\'' +
                ", location='" + location + '\'' +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", ownerOfTheHouse='" + ownerOfTheHouse + '\'' +
                ", commonSituation='" + commonSituation + '\'' +
                ", buildArea=" + buildArea +
                ", houseLocated='" + houseLocated + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", attachedNumber='" + attachedNumber + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", unit='" + unit + '\'' +
                ", floor='" + floor + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", registrationTime=" + registrationTime +
                ", nature='" + nature + '\'' +
                ", purpose='" + purpose + '\'' +
                ", totalNumber=" + totalNumber +
                ", evidenceArea=" + evidenceArea +
                ", innerArea=" + innerArea +
                ", other='" + other + '\'' +
                ", landNumber='" + landNumber + '\'' +
                ", landObtain='" + landObtain + '\'' +
                ", landUseStart=" + landUseStart +
                ", landUseEnd=" + landUseEnd +
                ", publicArea=" + publicArea +
                ", otherNotes='" + otherNotes + '\'' +
                ", registrationAuthority='" + registrationAuthority + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
