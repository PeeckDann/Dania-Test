package ua.lviv.iot.seafood.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.seafood.model.SortType;

public class SeafoodManagerUtilsTest extends BaseSeafoodManagerTest {

    @Test
    public void testSortingByPriceInGryvniasAscending() {
        SeafoodManagerUtils.sortByPriceInGryvnias(fish, SortType.ASC);
        assertEquals(10, fish.get(0).getPriceInGryvnias());
        assertEquals(50, fish.get(1).getPriceInGryvnias());
        assertEquals(100, fish.get(2).getPriceInGryvnias());
        assertEquals(150, fish.get(3).getPriceInGryvnias());
        assertEquals(170, fish.get(4).getPriceInGryvnias());
    }

    @Test
    public void testSortingByProducerAscending() {
        SeafoodManagerUtils.sortByProducer(fish, SortType.ASC);
        assertEquals("Fifth Firm", fish.get(0).getProducer());
        assertEquals("First Firm", fish.get(1).getProducer());
        assertEquals("Fourth Firm", fish.get(2).getProducer());
        assertEquals("Second Firm", fish.get(3).getProducer());
        assertEquals("Third Firm", fish.get(4).getProducer());
    }

    @Test
    public void testSortingByPriceInGryvniasUsingLambda() {
        SeafoodManagerUtils.sortByPriceInGryvniasUsingLambda(fish, SortType.ASC);
        assertEquals(10, fish.get(0).getPriceInGryvnias());
        assertEquals(50, fish.get(1).getPriceInGryvnias());
        assertEquals(100, fish.get(2).getPriceInGryvnias());
        assertEquals(150, fish.get(3).getPriceInGryvnias());
        assertEquals(170, fish.get(4).getPriceInGryvnias());
    }

    @Test
    public void testSortingByProducerUsingAnonymousClass() {
        SeafoodManagerUtils.sortByProducerUsingAnonymousClass(fish, SortType.ASC);
        assertEquals("Fifth Firm", fish.get(0).getProducer());
        assertEquals("First Firm", fish.get(1).getProducer());
        assertEquals("Fourth Firm", fish.get(2).getProducer());
        assertEquals("Second Firm", fish.get(3).getProducer());
        assertEquals("Third Firm", fish.get(4).getProducer());
    }
}