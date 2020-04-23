package ua.lviv.iot.seafood.model;

public class Caviar extends Seafood {

    private String caviarGrade;

    public Caviar(int priceInGryvnias, String producer, String speciesOfProduct, ConditionOfProduct conditionOfProduct,
            String caviarGrade) {
        super(priceInGryvnias, producer, speciesOfProduct, conditionOfProduct);
        this.caviarGrade = caviarGrade;
    }

    public String getCaviarGrade() {
        return caviarGrade;
    }

    public void setCaviarGrade(String caviarGrade) {
        this.caviarGrade = caviarGrade;
    }

    public String getHeaders() {
        return super.getHeaders() + ", caviarGrade";
    }

    public String toCSV() {
        return super.toCSV() + ", caviarGrade: " + getCaviarGrade();
    }
}