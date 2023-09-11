package Day24;

import java.util.HashMap;

public class UndergroundSystem {
    private HashMap<String, HashMap<String, AverageNumber>> averageTimes;
    private HashMap<Integer, Customer> customers;
    public UndergroundSystem() {
        averageTimes = new HashMap<>();
        customers = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        customers.put(id, new Customer(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Customer customer = customers.get(id);

        String checkInStation = customer.checkInStation;
        String checkOutStation = stationName;
        int checkInTime = customer.checkInTime;
        int checkOutTime = t;

        int timeDelta = checkOutTime - checkInTime;

        if (!averageTimes.containsKey(checkInStation)) {
            HashMap<String, AverageNumber> fromToAvgTimes = new HashMap<>();
            AverageNumber averageTime = new AverageNumber();

            averageTime.add(timeDelta);

            fromToAvgTimes.put(checkOutStation, averageTime);
            averageTimes.put(checkInStation, fromToAvgTimes);
        } else {
            AverageNumber averageTime = averageTimes.get(checkInStation).getOrDefault(checkOutStation, new AverageNumber());

            averageTime.add(timeDelta);
            averageTimes.get(checkInStation).put(checkOutStation, averageTime);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        double averageTime = averageTimes.get(startStation).get(endStation).getAverage();
//        System.out.println(averageTime);
        return averageTime;
    }

    private static class AverageNumber {
        private double average;
        private int count;
        AverageNumber() {
            average = 0.0;
            count = 0;
        }
        public void add(int value) {
            average = ((average * count) + value) / (count + 1);
            count++;
        }
        public double getAverage() {
            return average;
        }
    }

    private static class Customer {
        public String checkInStation;
        public int checkInTime;
        Customer(String checkInStation, int checkInTime) {
            this.checkInStation = checkInStation;
            this.checkInTime = checkInTime;
        }
    }
}
