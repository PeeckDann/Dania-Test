package ua.lviv.iot.seafood.model;

public class Clam extends Seafood {

    private String productCathegory;

    public Clam(int priceInGryvnias, String producer, String speciesOfProduct, ConditionOfProduct conditionOfProduct,
            String productCathegory) {
        super(priceInGryvnias, producer, speciesOfProduct, conditionOfProduct);
        this.productCathegory = productCathegory;
    }

    public String getProductCathegory() {
        return productCathegory;
    }

    public void setProductCathegory(String productCathegory) {
        this.productCathegory = productCathegory;
    }

    public String getHeaders() {
        return super.getHeaders() + ", productCathegory";
    }

    public String toCSV() {
        return super.toCSV() + ", productCathegory: " + getProductCathegory();
    }
}