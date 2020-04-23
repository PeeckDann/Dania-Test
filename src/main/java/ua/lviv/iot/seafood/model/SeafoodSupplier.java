package ua.lviv.iot.seafood.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "\"seafoodSupplier\"")
public class SeafoodSupplier {

    private String nameOfSupplier;
    private String countryOfSupplier;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;

    @OneToMany(mappedBy = "seafoodSupplier", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("seafoodSupplier")
    private Set<Seafood> seafood;

    public SeafoodSupplier() {
        this("DefaultSupplier", "DefaultCountry");
    }

    public SeafoodSupplier(String nameOfSupplier, String countryOfSupplier) {
        this.nameOfSupplier = nameOfSupplier;
        this.countryOfSupplier = countryOfSupplier;
    }

    public String getNameOfSupplier() {
        return nameOfSupplier;
    }

    public void setNameOfSupplier(String nameOfSupplier) {
        this.nameOfSupplier = nameOfSupplier;
    }

    public String getCountryOfSupplier() {
        return countryOfSupplier;
    }

    public void setCountryOfSupplier(String countryOfSupplier) {
        this.countryOfSupplier = countryOfSupplier;
    }

    public Integer getId() {
        return supplierId;
    }

    public void setId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Set<Seafood> getSeafood() {
        return seafood;
    }

    public void setSeafood(Set<Seafood> seafood) {
        this.seafood = seafood;
    }
}