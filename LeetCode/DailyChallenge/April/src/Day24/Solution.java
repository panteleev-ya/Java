package Day24;

public class Solution {
    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(37043, "K2618O72", 29);
        undergroundSystem.checkOut(37043, "U1DTINDT", 39);
        undergroundSystem.getAverageTime("K2618O72", "U1DTINDT");
        undergroundSystem.checkIn(779975, "K2618O72", 112);
        undergroundSystem.checkOut(779975, "CN3K6CYM", 157);
        undergroundSystem.getAverageTime("K2618O72", "U1DTINDT");
        undergroundSystem.checkIn(706901, "K2618O72", 221);
        undergroundSystem.getAverageTime("K2618O72", "CN3K6CYM");
        undergroundSystem.checkIn(18036, "K2618O72", 258);
        undergroundSystem.getAverageTime("K2618O72", "U1DTINDT");
        undergroundSystem.getAverageTime("K2618O72", "CN3K6CYM");
        undergroundSystem.checkOut(18036, "U1DTINDT", 293);
    }
}
