package model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_province ;
    private  String name_province;
    private int popular_province;
    private  double area_province;
    private  double gdp_province;
    private String picture_province;
    @Transient
    private MultipartFile image;
    @ManyToOne
    private  Country country;

    public Province(Long id_province, String name_province, int popular_province, double area_province,
                    double gdp_province, String picture_province, MultipartFile image, Country country) {
        this.id_province = id_province;
        this.name_province = name_province;
        this.popular_province = popular_province;
        this.area_province = area_province;
        this.gdp_province = gdp_province;
        this.picture_province = picture_province;
        this.image = image;
        this.country = country;
    }

    public Province() {
    }

    public int getPopular_province() {
        return popular_province;
    }

    public void setPopular_province(int popular_province) {
        this.popular_province = popular_province;
    }

    public Long getId_province() {
        return id_province;
    }

    public void setId_province(Long id_province) {
        this.id_province = id_province;
    }

    public String getName_province() {
        return name_province;
    }

    public void setName_province(String name_province) {
        this.name_province = name_province;
    }

    public double getArea_province() {
        return area_province;
    }

    public void setArea_province(double area_province) {
        this.area_province = area_province;
    }

    public double getGdp_province() {
        return gdp_province;
    }

    public void setGdp_province(double gdp_province) {
        this.gdp_province = gdp_province;
    }

    public String getPicture_province() {
        return picture_province;
    }

    public void setPicture_province(String picture_province) {
        this.picture_province = picture_province;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
