package ua.lviv.iot.seafood.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.seafood.model.ConditionOfProduct;
import ua.lviv.iot.seafood.model.Fish;
import ua.lviv.iot.seafood.model.Seafood;

public abstract class BaseSeafoodManagerTest {

    protected List<Seafood> fish;

    @BeforeEach
    public void createFish() {
        fish = new LinkedList<Seafood>();
        fish.add(new Fish(50, "First Firm", "Salmon", ConditionOfProduct.FROSEN, "Fillet"));
        fish.add(new Fish(100, "Second Firm", "Tuna", ConditionOfProduct.FROSEN, "Fillet"));
        fish.add(new Fish(10, "Third Firm", "Tuna", ConditionOfProduct.FROSEN, "Fillet"));
        fish.add(new Fish(150, "Fourth Firm", "Salmon", ConditionOfProduct.FRESH, "Fillet"));
        fish.add(new Fish(170, "Fifth Firm", "Salmon", ConditionOfProduct.FROSEN, "Fillet"));
    }
}
