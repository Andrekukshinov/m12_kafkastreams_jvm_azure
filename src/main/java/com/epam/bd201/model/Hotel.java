package com.epam.bd201.model;

import java.util.Objects;

public class Hotel {
    private long id;
    private String dateTime;
    private Integer siteName;
    private Integer posaContainer;
    private Integer userLocationCountry;
    private Integer userLocationRegion;
    private Integer userLocationCity;
    private Double origDestinationDistance;
    private Integer userId;
    private Integer isMobile;
    private Integer isPackage;
    private Integer channel;
    private String srchCi;
    private String srchCo;
    private Integer srchAdultsCnt;
    private Integer srchChildrenCnt;
    private Integer srchRmCnt;
    private Integer srchDestinationId;
    private Integer srchDestinationTypeId;
    private Long hotelId;

    private StayType stayType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getSiteName() {
        return siteName;
    }

    public void setSiteName(Integer siteName) {
        this.siteName = siteName;
    }

    public Integer getPosaContainer() {
        return posaContainer;
    }

    public void setPosaContainer(Integer posaContainer) {
        this.posaContainer = posaContainer;
    }

    public Integer getUserLocationCountry() {
        return userLocationCountry;
    }

    public void setUserLocationCountry(Integer userLocationCountry) {
        this.userLocationCountry = userLocationCountry;
    }

    public Integer getUserLocationRegion() {
        return userLocationRegion;
    }

    public void setUserLocationRegion(Integer userLocationRegion) {
        this.userLocationRegion = userLocationRegion;
    }

    public Integer getUserLocationCity() {
        return userLocationCity;
    }

    public void setUserLocationCity(Integer userLocationCity) {
        this.userLocationCity = userLocationCity;
    }

    public Double getOrigDestinationDistance() {
        return origDestinationDistance;
    }

    public void setOrigDestinationDistance(Double origDestinationDistance) {
        this.origDestinationDistance = origDestinationDistance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Integer isMobile) {
        this.isMobile = isMobile;
    }

    public Integer getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Integer isPackage) {
        this.isPackage = isPackage;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getSrchCi() {
        return srchCi;
    }

    public void setSrchCi(String srchCi) {
        this.srchCi = srchCi;
    }

    public String getSrchCo() {
        return srchCo;
    }

    public void setSrchCo(String srchCo) {
        this.srchCo = srchCo;
    }

    public Integer getSrchAdultsCnt() {
        return srchAdultsCnt;
    }

    public void setSrchAdultsCcnt(Integer srchAdultsCnt) {
        this.srchAdultsCnt = srchAdultsCnt;
    }

    public Integer getSrchChildrenCnt() {
        return srchChildrenCnt;
    }

    public void setSrchChildrenCnt(Integer srchChildrenCnt) {
        this.srchChildrenCnt = srchChildrenCnt;
    }

    public Integer getSrchRmCnt() {
        return srchRmCnt;
    }

    public void setSrchRmCnt(Integer srchRmCnt) {
        this.srchRmCnt = srchRmCnt;
    }

    public Integer getSrchDestinationId() {
        return srchDestinationId;
    }

    public void setSrchDestinationId(Integer srchDestinationId) {
        this.srchDestinationId = srchDestinationId;
    }

    public Integer getSrchDestinationTypeId() {
        return srchDestinationTypeId;
    }

    public void setSrchDestinationTypeId(Integer srchDestinationTypeId) {
        this.srchDestinationTypeId = srchDestinationTypeId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public StayType getStayType() {
        return stayType;
    }

    public void setStayType(StayType stayType) {
        this.stayType = stayType;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", siteName=" + siteName +
                ", posaContainer=" + posaContainer +
                ", userLocationCountry=" + userLocationCountry +
                ", userLocationRegion=" + userLocationRegion +
                ", userLocationCity=" + userLocationCity +
                ", origDestinationDistance=" + origDestinationDistance +
                ", userId=" + userId +
                ", isMobile=" + isMobile +
                ", isPackage=" + isPackage +
                ", channel=" + channel +
                ", srchCi='" + srchCi + '\'' +
                ", srchCo='" + srchCo + '\'' +
                ", srchAdultsCnt=" + srchAdultsCnt +
                ", srchChildrenCnt=" + srchChildrenCnt +
                ", srchRmCnt=" + srchRmCnt +
                ", srchDestinationId=" + srchDestinationId +
                ", srchDestinationTypeId=" + srchDestinationTypeId +
                ", hotelId=" + hotelId +
                ", stayType=" + stayType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return getId() == hotel.getId() && Objects.equals(getDateTime(), hotel.getDateTime()) && Objects.equals(getSiteName(), hotel.getSiteName()) && Objects.equals(getPosaContainer(), hotel.getPosaContainer()) && Objects.equals(getUserLocationCountry(), hotel.getUserLocationCountry()) && Objects.equals(getUserLocationRegion(), hotel.getUserLocationRegion()) && Objects.equals(getUserLocationCity(), hotel.getUserLocationCity()) && Objects.equals(getOrigDestinationDistance(), hotel.getOrigDestinationDistance()) && Objects.equals(getUserId(), hotel.getUserId()) && Objects.equals(getIsMobile(), hotel.getIsMobile()) && Objects.equals(getIsPackage(), hotel.getIsPackage()) && Objects.equals(getChannel(), hotel.getChannel()) && Objects.equals(getSrchCi(), hotel.getSrchCi()) && Objects.equals(getSrchCo(), hotel.getSrchCo()) && Objects.equals(getSrchAdultsCnt(), hotel.getSrchAdultsCnt()) && Objects.equals(getSrchChildrenCnt(), hotel.getSrchChildrenCnt()) && Objects.equals(getSrchRmCnt(), hotel.getSrchRmCnt()) && Objects.equals(getSrchDestinationId(), hotel.getSrchDestinationId()) && Objects.equals(getSrchDestinationTypeId(), hotel.getSrchDestinationTypeId()) && Objects.equals(getHotelId(), hotel.getHotelId()) && getStayType() == hotel.getStayType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateTime(), getSiteName(), getPosaContainer(), getUserLocationCountry(), getUserLocationRegion(), getUserLocationCity(), getOrigDestinationDistance(), getUserId(), getIsMobile(), getIsPackage(), getChannel(), getSrchCi(), getSrchCo(), getSrchAdultsCnt(), getSrchChildrenCnt(), getSrchRmCnt(), getSrchDestinationId(), getSrchDestinationTypeId(), getHotelId(), getStayType());
    }
}
