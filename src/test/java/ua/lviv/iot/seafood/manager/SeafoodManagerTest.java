package ua.lviv.iot.seafood.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.seafood.manager.SeafoodManager;
import ua.lviv.iot.seafood.model.ConditionOfProduct;
import ua.lviv.iot.seafood.model.Seafood;

public class SeafoodManagerTest extends BaseSeafoodManagerTest {

    private SeafoodManager seafoodManager;

    @BeforeEach
    public void setUp() {
        seafoodManager = new SeafoodManager();
        seafoodManager.addSeafood(fish);
    }

    @Test
    public void testFindSeafood() {
        List<Seafood> seafood = seafoodManager.findSeafood(20, 200, "Salmon", ConditionOfProduct.FROSEN);
        assertEquals(2, seafood.size());

        assertEquals(50, seafood.get(0).getPriceInGryvnias());
        assertEquals(170, seafood.get(1).getPriceInGryvnias());

        assertEquals("Salmon", seafood.get(0).getSpeciesOfProduct());
        assertEquals("Salmon", seafood.get(1).getSpeciesOfProduct());

        assertEquals(ConditionOfProduct.FROSEN, seafood.get(0).getConditionOfProduct());
        assertEquals(ConditionOfProduct.FROSEN, seafood.get(1).getConditionOfProduct());
    }
}
