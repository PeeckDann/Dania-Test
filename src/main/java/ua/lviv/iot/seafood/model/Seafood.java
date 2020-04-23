package ua.lviv.iot.seafood.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ua.lviv.iot.seafood.model.SeafoodShop;

@Entity
public class Seafood {

    @Column(name = "price_in_uah")
    protected int priceInGryvnias;

    protected String producer;

    protected String speciesOfProduct;

    @Enumerated(EnumType.STRING)
    protected ConditionOfProduct conditionOfProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer seafoodId;

    @ManyToMany(mappedBy = "seafood")
    @JsonIgnoreProperties("seafood")
    private Set<SeafoodShop> seafoodShops;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seafood_supplier_id")
    @JsonIgnoreProperties("seafood")
    private SeafoodSupplier seafoodSupplier;

    private String headers = "priceInGryvnias, producer, speciesOfProduct, conditionOfProduct";

    public Seafood() {
        this(0, "DefaultCompany", "DefaultFish", ConditionOfProduct.FROSEN);
    }
    
    public Seafood(int priceInGryvnias, String producer, String speciesOfProduct,
            ConditionOfProduct conditionOfProduct) {
        this(priceInGryvnias, producer, speciesOfProduct, conditionOfProduct, null);
    }
    
    public Seafood(int priceInGryvnias, String producer, String speciesOfProduct,
            ConditionOfProduct conditionOfProduct, SeafoodSupplier seafoodSupplier) {
        this.priceInGryvnias = priceInGryvnias;
        this.producer = producer;
        this.speciesOfProduct = speciesOfProduct;
        this.conditionOfProduct = conditionOfProduct;
        this.seafoodSupplier = seafoodSupplier;
    }

    public Integer getId() {
        return seafoodId;
    }

    public void setId(Integer id) {
        this.seafoodId = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPriceInGryvnias() {
        return priceInGryvnias;
    }

    public void setPriceInGryvnias(int priceInGryvnias) {
        this.priceInGryvnias = priceInGryvnias;
    }

    public String getSpeciesOfProduct() {
        return speciesOfProduct;
    }

    public void setSpeciesOfProduct(String speciesOfProduct) {
        this.speciesOfProduct = speciesOfProduct;
    }

    public ConditionOfProduct getConditionOfProduct() {
        return conditionOfProduct;
    }

    public void setConditionOfProduct(ConditionOfProduct conditionOfProduct) {
        this.conditionOfProduct = conditionOfProduct;
    }

    public String getHeaders() {
        return headers;
    }

    public Set<SeafoodShop> getSeafoodShops() {
        return seafoodShops;
    }

    public void setSportShops(Set<SeafoodShop> seafoodShops) {
        this.seafoodShops = seafoodShops;
    }
    
    public SeafoodSupplier getSeafoodSupplier() {
        return seafoodSupplier;
    }

    public void setSeafoodSupplier(SeafoodSupplier seafoodSupplier) {
        this.seafoodSupplier = seafoodSupplier;
    }

    public String toCSV() {
        return "priceInGryvnias: " + getPriceInGryvnias() + ", producer: " + getProducer() + ", speciesOfProduct: "
                + getSpeciesOfProduct() + ", conditionOfProduct: " + getConditionOfProduct();
    }
}