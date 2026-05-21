package Ex2;

public abstract class NumberRandomizer {
    // returnn a single randomized number in between two numbers
    abstract int randomizeInBetween(int min, int max);
    // return array of randomized unique number in between two numbers
    abstract int[] randomizeUniqueInBetween(int min, int max, int amount);
}
