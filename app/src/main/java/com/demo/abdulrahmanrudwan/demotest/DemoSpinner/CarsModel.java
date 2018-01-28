package com.demo.abdulrahmanrudwan.demotest.DemoSpinner;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abdulrahman Rudwan on 14/12/2017.
 */

public class CarsModel {
    @SerializedName("CarModel")
    private CarModel CarModel;
    @SerializedName("Company")
    private Company Company;
    @SerializedName("Country")
    private Country Country;
    @SerializedName("ExteriorColor")
    private ExteriorColor ExteriorColor;
    @SerializedName("doubleeriorColor")
    private doubleeriorColor doubleeriorColor;
    @SerializedName("VehicleType")
    private VehicleType VehicleType;
    @SerializedName("CompanyId")
    private double CompanyId;
    @SerializedName("PlatNumber")
    private String PlatNumber;
    @SerializedName("VehicleTypeId")
    private double VehicleTypeId;
    @SerializedName("CarModelId")
    private double CarModelId;
    @SerializedName("ExteriorColorId")
    private double ExteriorColorId;
    @SerializedName("doubleeriorColorId")
    private double doubleeriorColorId;
    @SerializedName("InsuranceNumber")
    private String InsuranceNumber;
    @SerializedName("InsuranceExpirationDate")
    private String InsuranceExpirationDate;
    @SerializedName("HasImage")
    private boolean HasImage;
    @SerializedName("InsuranceImage")
    private String InsuranceImage;
    @SerializedName("Id")
    private double Id;
    @SerializedName("CountryId")
    private double CountryId;

    public CarModel getCarModel() {
        return CarModel;
    }

    public void setCarModel(CarModel CarModel) {
        this.CarModel = CarModel;
    }

    public Company getCompany() {
        return Company;
    }

    public void setCompany(Company Company) {
        this.Company = Company;
    }

    public Country getCountry() {
        return Country;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }

    public ExteriorColor getExteriorColor() {
        return ExteriorColor;
    }

    public void setExteriorColor(ExteriorColor ExteriorColor) {
        this.ExteriorColor = ExteriorColor;
    }

    public doubleeriorColor getdoubleeriorColor() {
        return doubleeriorColor;
    }

    public void setdoubleeriorColor(doubleeriorColor doubleeriorColor) {
        this.doubleeriorColor = doubleeriorColor;
    }

    public VehicleType getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(VehicleType VehicleType) {
        this.VehicleType = VehicleType;
    }

    public double getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(double CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getPlatNumber() {
        return PlatNumber;
    }

    public void setPlatNumber(String PlatNumber) {
        this.PlatNumber = PlatNumber;
    }

    public double getVehicleTypeId() {
        return VehicleTypeId;
    }

    public void setVehicleTypeId(double VehicleTypeId) {
        this.VehicleTypeId = VehicleTypeId;
    }

    public double getCarModelId() {
        return CarModelId;
    }

    public void setCarModelId(double CarModelId) {
        this.CarModelId = CarModelId;
    }

    public double getExteriorColorId() {
        return ExteriorColorId;
    }

    public void setExteriorColorId(double ExteriorColorId) {
        this.ExteriorColorId = ExteriorColorId;
    }

    public double getdoubleeriorColorId() {
        return doubleeriorColorId;
    }

    public void setdoubleeriorColorId(double doubleeriorColorId) {
        this.doubleeriorColorId = doubleeriorColorId;
    }

    public String getInsuranceNumber() {
        return InsuranceNumber;
    }

    public void setInsuranceNumber(String InsuranceNumber) {
        this.InsuranceNumber = InsuranceNumber;
    }

    public String getInsuranceExpirationDate() {
        return InsuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(String InsuranceExpirationDate) {
        this.InsuranceExpirationDate = InsuranceExpirationDate;
    }

    public boolean getHasImage() {
        return HasImage;
    }

    public void setHasImage(boolean HasImage) {
        this.HasImage = HasImage;
    }

    public String getInsuranceImage() {
        return InsuranceImage;
    }

    public void setInsuranceImage(String InsuranceImage) {
        this.InsuranceImage = InsuranceImage;
    }

    public double getId() {
        return Id;
    }

    public void setId(double Id) {
        this.Id = Id;
    }

    public double getCountryId() {
        return CountryId;
    }

    public void setCountryId(double CountryId) {
        this.CountryId = CountryId;
    }

    public static class Country {
        @SerializedName("Id")
        private double Id;
        @SerializedName("ArabicName")
        private String ArabicName;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("CurrancyEnglishName")
        private String CurrancyEnglishName;
        @SerializedName("CurrancyArabicName")
        private String CurrancyArabicName;
        @SerializedName("DateTimeOffset")
        private double DateTimeOffset;
        @SerializedName("PhoneCode")
        private String PhoneCode;

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
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

        public double getDateTimeOffset() {
            return DateTimeOffset;
        }

        public void setDateTimeOffset(double DateTimeOffset) {
            this.DateTimeOffset = DateTimeOffset;
        }

        public String getPhoneCode() {
            return PhoneCode;
        }

        public void setPhoneCode(String PhoneCode) {
            this.PhoneCode = PhoneCode;
        }
    }

    public static class CarModel {
        @SerializedName("Country")
        private Country Country;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("ArabicName")
        private String ArabicName;
        @SerializedName("Id")
        private double Id;
        @SerializedName("CountryId")
        private double CountryId;

        public Country getCountry() {
            return Country;
        }

        public void setCountry(Country Country) {
            this.Country = Country;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getArabicName() {
            return ArabicName;
        }

        public void setArabicName(String ArabicName) {
            this.ArabicName = ArabicName;
        }

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
            this.Id = Id;
        }

        public double getCountryId() {
            return CountryId;
        }

        public void setCountryId(double CountryId) {
            this.CountryId = CountryId;
        }
    }


    public static class Company {
        @SerializedName("Country")
        private Country Country;
        @SerializedName("Name")
        private String Name;
        @SerializedName("UserName")
        private String UserName;
        @SerializedName("Password")
        private String Password;
        @SerializedName("Address")
        private String Address;
        @SerializedName("Email")
        private String Email;
        @SerializedName("Website")
        private String Website;
        @SerializedName("PhoneNumber")
        private String PhoneNumber;
        @SerializedName("FaxNumber")
        private String FaxNumber;
        @SerializedName("HasImage")
        private boolean HasImage;
        @SerializedName("CreationDate")
        private String CreationDate;
        @SerializedName("Image1")
        private String Image1;
        @SerializedName("Image2")
        private String Image2;
        @SerializedName("Image3")
        private String Image3;
        @SerializedName("Image4")
        private String Image4;
        @SerializedName("Id")
        private double Id;
        @SerializedName("CountryId")
        private double CountryId;

        public Country getCountry() {
            return Country;
        }

        public void setCountry(Country Country) {
            this.Country = Country;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getWebsite() {
            return Website;
        }

        public void setWebsite(String Website) {
            this.Website = Website;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }

        public String getFaxNumber() {
            return FaxNumber;
        }

        public void setFaxNumber(String FaxNumber) {
            this.FaxNumber = FaxNumber;
        }

        public boolean getHasImage() {
            return HasImage;
        }

        public void setHasImage(boolean HasImage) {
            this.HasImage = HasImage;
        }

        public String getCreationDate() {
            return CreationDate;
        }

        public void setCreationDate(String CreationDate) {
            this.CreationDate = CreationDate;
        }

        public String getImage1() {
            return Image1;
        }

        public void setImage1(String Image1) {
            this.Image1 = Image1;
        }

        public String getImage2() {
            return Image2;
        }

        public void setImage2(String Image2) {
            this.Image2 = Image2;
        }

        public String getImage3() {
            return Image3;
        }

        public void setImage3(String Image3) {
            this.Image3 = Image3;
        }

        public String getImage4() {
            return Image4;
        }

        public void setImage4(String Image4) {
            this.Image4 = Image4;
        }

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
            this.Id = Id;
        }

        public double getCountryId() {
            return CountryId;
        }

        public void setCountryId(double CountryId) {
            this.CountryId = CountryId;
        }
    }


    public static class ExteriorColor {
        @SerializedName("Id")
        private double Id;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("ArabicName")
        private String ArabicName;

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
            this.Id = Id;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getArabicName() {
            return ArabicName;
        }

        public void setArabicName(String ArabicName) {
            this.ArabicName = ArabicName;
        }
    }

    public static class doubleeriorColor {
        @SerializedName("Id")
        private double Id;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("ArabicName")
        private String ArabicName;

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
            this.Id = Id;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getArabicName() {
            return ArabicName;
        }

        public void setArabicName(String ArabicName) {
            this.ArabicName = ArabicName;
        }
    }


    public static class VehicleType {
        @SerializedName("Country")
        private Country Country;
        @SerializedName("EnglishName")
        private String EnglishName;
        @SerializedName("ArabicName")
        private String ArabicName;
        @SerializedName("OpenDoorPrice")
        private double OpenDoorPrice;
        @SerializedName("KilometerCost")
        private double KilometerCost;
        @SerializedName("WaitingPerMinuteCost")
        private double WaitingPerMinuteCost;
        @SerializedName("SupportSchedule")
        private boolean SupportSchedule;
        @SerializedName("Sort")
        private double Sort;
        @SerializedName("HourCost")
        private double HourCost;
        @SerializedName("CalcbyDistance")
        private boolean CalcbyDistance;
        @SerializedName("SupportPromotion")
        private boolean SupportPromotion;
        @SerializedName("SupportCash")
        private boolean SupportCash;
        @SerializedName("SupportCredit")
        private boolean SupportCredit;
        @SerializedName("TripPercentage")
        private double TripPercentage;
        @SerializedName("Podouble")
        private double Podouble;
        @SerializedName("currency")
        private double currency;
        @SerializedName("IsServiceProvider")
        private boolean IsServiceProvider;
        @SerializedName("MinimumCharge")
        private String MinimumCharge;
        @SerializedName("IsActive")
        private boolean IsActive;
        @SerializedName("Id")
        private double Id;
        @SerializedName("CountryId")
        private double CountryId;

        public Country getCountry() {
            return Country;
        }

        public void setCountry(Country Country) {
            this.Country = Country;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getArabicName() {
            return ArabicName;
        }

        public void setArabicName(String ArabicName) {
            this.ArabicName = ArabicName;
        }

        public double getOpenDoorPrice() {
            return OpenDoorPrice;
        }

        public void setOpenDoorPrice(double OpenDoorPrice) {
            this.OpenDoorPrice = OpenDoorPrice;
        }

        public double getKilometerCost() {
            return KilometerCost;
        }

        public void setKilometerCost(double KilometerCost) {
            this.KilometerCost = KilometerCost;
        }

        public double getWaitingPerMinuteCost() {
            return WaitingPerMinuteCost;
        }

        public void setWaitingPerMinuteCost(double WaitingPerMinuteCost) {
            this.WaitingPerMinuteCost = WaitingPerMinuteCost;
        }

        public boolean getSupportSchedule() {
            return SupportSchedule;
        }

        public void setSupportSchedule(boolean SupportSchedule) {
            this.SupportSchedule = SupportSchedule;
        }

        public double getSort() {
            return Sort;
        }

        public void setSort(double Sort) {
            this.Sort = Sort;
        }

        public double getHourCost() {
            return HourCost;
        }

        public void setHourCost(double HourCost) {
            this.HourCost = HourCost;
        }

        public boolean getCalcbyDistance() {
            return CalcbyDistance;
        }

        public void setCalcbyDistance(boolean CalcbyDistance) {
            this.CalcbyDistance = CalcbyDistance;
        }

        public boolean getSupportPromotion() {
            return SupportPromotion;
        }

        public void setSupportPromotion(boolean SupportPromotion) {
            this.SupportPromotion = SupportPromotion;
        }

        public boolean getSupportCash() {
            return SupportCash;
        }

        public void setSupportCash(boolean SupportCash) {
            this.SupportCash = SupportCash;
        }

        public boolean getSupportCredit() {
            return SupportCredit;
        }

        public void setSupportCredit(boolean SupportCredit) {
            this.SupportCredit = SupportCredit;
        }

        public double getTripPercentage() {
            return TripPercentage;
        }

        public void setTripPercentage(double TripPercentage) {
            this.TripPercentage = TripPercentage;
        }

        public double getPodouble() {
            return Podouble;
        }

        public void setPodouble(double Podouble) {
            this.Podouble = Podouble;
        }

        public double getCurrency() {
            return currency;
        }

        public void setCurrency(double currency) {
            this.currency = currency;
        }

        public boolean getIsServiceProvider() {
            return IsServiceProvider;
        }

        public void setIsServiceProvider(boolean IsServiceProvider) {
            this.IsServiceProvider = IsServiceProvider;
        }

        public String getMinimumCharge() {
            return MinimumCharge;
        }

        public void setMinimumCharge(String MinimumCharge) {
            this.MinimumCharge = MinimumCharge;
        }

        public boolean getIsActive() {
            return IsActive;
        }

        public void setIsActive(boolean IsActive) {
            this.IsActive = IsActive;
        }

        public double getId() {
            return Id;
        }

        public void setId(double Id) {
            this.Id = Id;
        }

        public double getCountryId() {
            return CountryId;
        }

        public void setCountryId(double CountryId) {
            this.CountryId = CountryId;
        }
    }
}
