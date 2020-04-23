package ua.lviv.iot.seafood.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SeafoodShop {

    private String nameOfShop;
    
    private String locationOfShop;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shopId;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "seafod_shops", joinColumns = {
            @JoinColumn(name = "shop_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "seafood_id", nullable = false) })
    @JsonIgnoreProperties("seafoodShops")
    private Set<Seafood> seafood;
    
    public SeafoodShop() {
        this("DefaultShop", "DefaultLocation");
    }
    
    public SeafoodShop(String nameOfShop, String locationOfShop) {
        this.nameOfShop = nameOfShop;
        this.locationOfShop = locationOfShop;
    }
    
    public String getNameOfShop() {
        return nameOfShop;
    }
    
    public void setNameOfShop(String nameOfShop) {
        this.nameOfShop = nameOfShop;
    }
    
    public String getLocationOfShop() {
        return locationOfShop;
    }
    
    public void setLocationOfShop(String locationOfShop) {
        this.locationOfShop = locationOfShop;
    }

    public Integer getId() {
        return shopId;
    }

    public void setId(Integer shopId) {
        this.shopId = shopId;
    }
    
    public Set<Seafood> getSeafood() {
        return seafood;
    }

    public void setSeafood(Set<Seafood> seafood) {
        this.seafood = seafood;
    }
}