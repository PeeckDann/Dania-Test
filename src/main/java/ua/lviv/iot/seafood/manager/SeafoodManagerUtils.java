package ua.lviv.iot.seafood.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.seafood.model.Seafood;
import ua.lviv.iot.seafood.model.SortType;

public class SeafoodManagerUtils {

    private static final FishSorterByPriceInGryvnias SEAFOOD_SORTER_BY_PRICE = new FishSorterByPriceInGryvnias();

    public static void sortByProducer(final List<Seafood> seafood, final SortType sortType) {
        seafood.sort(sortType == SortType.ASC ? new SeafoodManagerUtils().new FishSorterByProducer()
                : new SeafoodManagerUtils().new FishSorterByProducer().reversed());
    }

    public class FishSorterByProducer implements Comparator<Seafood> {

        @Override
        public int compare(Seafood firstFish, Seafood secondFish) {
            return firstFish.getProducer().compareTo(secondFish.getProducer());
        }
    }

    public static void sortByPriceInGryvnias(final List<Seafood> seafood, final SortType sortType) {
        seafood.sort(sortType == SortType.ASC ? SEAFOOD_SORTER_BY_PRICE : SEAFOOD_SORTER_BY_PRICE.reversed());
    }

    public static class FishSorterByPriceInGryvnias implements Comparator<Seafood> {

        @Override
        public int compare(Seafood firstFish, Seafood secondFish) {
            return firstFish.getPriceInGryvnias() - secondFish.getPriceInGryvnias();
        }
    }

    public static void sortByPriceInGryvniasUsingLambda(final List<Seafood> seafood, final SortType sortType) {
        if (sortType == SortType.ASC) {
            seafood.sort((firstFish, secondFish) -> Integer.compare(firstFish.getPriceInGryvnias(),
                    secondFish.getPriceInGryvnias()));
        } else {
            seafood.sort((firstFish, secondFish) -> Integer.compare(secondFish.getPriceInGryvnias(),
                    firstFish.getPriceInGryvnias()));
        }
    }

    public static void sortByProducerUsingAnonymousClass(List<Seafood> seafood, SortType sortType) {
        Comparator<Seafood> fishSorterByProducer = new Comparator<Seafood>() {

            @Override
            public int compare(Seafood firstFish, Seafood secondFish) {
                return firstFish.getProducer().compareTo(secondFish.getProducer());
            }
        };

        seafood.sort(sortType == SortType.ASC ? fishSorterByProducer : fishSorterByProducer.reversed());
    }
}