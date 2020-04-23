package ua.lviv.iot.seafood.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.seafood.model.ConditionOfProduct;
import ua.lviv.iot.seafood.model.Seafood;

public class SeafoodManager {

    private List<Seafood> seafood = new LinkedList<>();

    public void addSeafood(final List<Seafood> seafood) {
        this.seafood.addAll(seafood);
    }

    public List<Seafood> findSeafood(int minPrice, int maxPrice, String speciesOfProduct,
            ConditionOfProduct conditionOfProduct) {
        List<Seafood> result = new LinkedList<>();
        for (Seafood seafoodProduct : seafood) {
            if (seafoodProduct.getPriceInGryvnias() > minPrice && seafoodProduct.getPriceInGryvnias() < maxPrice
                    && seafoodProduct.getSpeciesOfProduct().equals(speciesOfProduct)
                    && seafoodProduct.getConditionOfProduct().equals(conditionOfProduct)) {
                result.add(seafoodProduct);
            }
        }
        return result;
    }
}