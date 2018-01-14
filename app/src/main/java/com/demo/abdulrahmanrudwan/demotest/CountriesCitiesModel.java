package com.demo.abdulrahmanrudwan.demotest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abdulrahman Rudwan on 14/12/2017.
 */

public class CountriesCitiesModel {
    @SerializedName("Country")
    private Country Country;
    @SerializedName("EnglishName")
    private String CityEnglishName;
    @SerializedName("ArabicName")
    private String CityArabicName;
    @SerializedName("Id")
    private int Id;
    @SerializedName("CountryId")
    private int CountryId;

    public Country getCountry() {
        return Country;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }

    public String getCityEnglishName() {
        return CityEnglishName;
    }

    public void setCityEnglishName(String EnglishName) {
        this.CityEnglishName = EnglishName;
    }

    public String getCityArabicName() {
        return CityArabicName;
    }

    public void setCityArabicName(String ArabicName) {
        this.CityArabicName = ArabicName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int CountryId) {
        this.CountryId = CountryId;
    }

    public static class Country {
        @SerializedName("Id")
        private int Id;
        @SerializedName("ArabicName")
        private String ArabicName;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("CurrancyEnglishName")
        private String CurrancyEnglishName;
        @SerializedName("CurrancyArabicName")
        private String CurrancyArabicName;
        @SerializedName("DateTimeOffset")
        private int DateTimeOffset;
        @SerializedName("PhoneCode")
        private String PhoneCode;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getArabicName() {
            return ArabicName;
        }

        public void setArabicName(String ArabicName) {
            this.ArabicName = ArabicName;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getCurrancyEnglishName() {
            return CurrancyEnglishName;
        }

        public void setCurrancyEnglishName(String CurrancyEnglishName) {
            this.CurrancyEnglishName = CurrancyEnglishName;
        }

        public String getCurrancyArabicName() {
            return CurrancyArabicName;
        }

        public void setCurrancyArabicName(String CurrancyArabicName) {
            this.CurrancyArabicName = CurrancyArabicName;
        }

        public int getDateTimeOffset() {
            return DateTimeOffset;
        }

        public void setDateTimeOffset(int DateTimeOffset) {
            this.DateTimeOffset = DateTimeOffset;
        }

        public String getPhoneCode() {
            return PhoneCode;
        }

        public void setPhoneCode(String PhoneCode) {
            this.PhoneCode = PhoneCode;
        }
    }
}
