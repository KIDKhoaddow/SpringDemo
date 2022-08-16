package model;

import javax.persistence.*;

@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_country;

    private  String name_Country;

    public Country(Long id_country, String name_Country) {
        this.id_country = id_country;
        this.name_Country = name_Country;
    }

    public Country() {

    }

    public Long getId_country() {
        return id_country;
    }

    public void setId_country(Long id_country) {
        this.id_country = id_country;
    }

    public String getName_Country() {
        return name_Country;
    }

    public void setName_Country(String name_Country) {
        this.name_Country = name_Country;
    }
}

