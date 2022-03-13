package ReconstructItinerary;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        String[][] t = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}, {"JFK", "LHR"}, {"SFO", "JFK"}};
        String[][] t = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
//        String[][] t = {{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},{"EZE","ADL"},{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},{"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},{"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},{"AUA","SYD"},{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},{"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},{"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},{"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},{"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},{"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},{"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},{"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},{"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}};
        List<List<String>> tickets = new ArrayList<>();
        for (var ticket: t) {
            ArrayList<String> newTicket = new ArrayList<>();
            newTicket.add(ticket[0]);
            newTicket.add(ticket[1]);
            tickets.add(newTicket);
        }
        System.out.println(findItinerary(tickets));
    }

    // Класс указателя
    private static class Pointer<T> {
        private T value;
        public Pointer() {

        }
        public Pointer(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        // Создаем карту полетов
//        HashMap<String, ArrayList<String>> map = makeMap(tickets);
        ArrayList<ArrayList<String>> flights = new ArrayList<>();
        ArrayList<Integer> available = new ArrayList<>();
        HashMap<String, Integer> cityIndexes = new HashMap<>();
        fillFlights(tickets, flights, cityIndexes, available);

        // Запускаем волшебную рекурсию и получаем ответ
        Pointer<String> maxItinerary = new Pointer<>();
        Pointer<Integer> maxItineraryLength = new Pointer<>(0);
        String startCity = "JFK";
        String startItinerary = startCity;
        int startItineraryLength = 0;
//        findLongestItinerary(map, "JFK", maxList, 0, maxLength, "JFK");
//        findLongestItinerary(startCity, startCity, 0, maxList, maxLength, map, map.get(startCity));

        fly(startCity,
            startItinerary, startItineraryLength,
            maxItinerary, maxItineraryLength,
            flights, available, cityIndexes);
        return List.of(maxItinerary.value.split(" - "));
    }

    private static void fillFlights(List<List<String>> tickets, ArrayList<ArrayList<String>> flights, HashMap<String, Integer> cityIndexes, ArrayList<Integer> available) {
        int index;
        for (var ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (cityIndexes.containsKey(from)) {
                index = cityIndexes.get(from);
                flights.get(index).add(to);
            } else {
                ArrayList<String> newCityFlights = new ArrayList<>();
                newCityFlights.add(to);

                index = flights.size();
                flights.add(newCityFlights);
                cityIndexes.put(from, index);
            }
        }
        for (String city: cityIndexes.keySet()) {
            index = cityIndexes.get(city);
            Collections.sort(flights.get(index));
            available.add(0);
        }
    }

    // Передаем в функцию:
    // 1) Город, в котором мы сейчас
    // 2) Текущую цепочку перелетов
    // 3) Длину текущей цепочки перелетов
    // 4) Максимальную цепочку перелетов
    // 5) Длину максимальной цепочки перелетов
    // 6) Все возможные перелеты из города в город, заранее отсортированные лексикографически
    // 7) Список индексов возможных для перелета городов (тех рейсов, которыми мы еще не летали)
    // 8) Мапу пар вида (город, индекс в списке перелетов)
    private static void fly(String city,
                            String itinerary, int itineraryLength,
                            Pointer<String> maxItinerary, Pointer<Integer> maxItineraryLength,
                            ArrayList<ArrayList<String>> flights, ArrayList<Integer> available, HashMap<String, Integer> cityIndexes) {

        // Если из этого города некуда лететь
        if (!cityIndexes.containsKey(city)) {
            // Если она больше максимальной - сохраняем ее
            setMaxItinerary(itinerary, itineraryLength, maxItinerary, maxItineraryLength);
            return;
        }

        // Индекс города в flights (из него есть куда лететь)
        int cityIndex = cityIndexes.get(city);

        // Индекс первого доступного перелета в flights[city]
        int availableIndex = available.get(cityIndex);

        // Список всех перелетов из текущего города (даже недоступных)
        ArrayList<String> cityFlights = flights.get(cityIndex);

        // Индекс последнего возможного перелета из текущего города
        int lastCityFlightIndex = cityFlights.size() - 1;

        // Если все перелеты уже недоступны - смотрим на длину цепочки перелетов
        if (lastCityFlightIndex < availableIndex) {
            // Если она больше максимальной - сохраняем ее
            setMaxItinerary(itinerary, itineraryLength, maxItinerary, maxItineraryLength);
        } else {
            // Если еще есть куда лететь - летим в следующим доступным перелетом, делаем этот перелет недоступным

            while (availableIndex <= lastCityFlightIndex) {
                String nextCity = cityFlights.get(availableIndex); // получаем город, в который мы прилетаем следующим перелетом
                String updatedItinerary = itinerary + " - " + nextCity; // добавляем этот город в цепочку перелетов
                int newItineraryLength = itineraryLength + 1; // увеличиваем длину цепочки на 1

                ArrayList<Integer> nowAvailable = new ArrayList<>(available);
                availableIndex++;
                nowAvailable.set(cityIndex, availableIndex); // делаем перелет более недоступным

                fly(nextCity,
                        updatedItinerary, newItineraryLength,
                        maxItinerary, maxItineraryLength,
                        flights, nowAvailable, cityIndexes);
            }
        }
    }

    private static void setMaxItinerary (String itinerary, int itineraryLength, Pointer<String> maxItinerary, Pointer<Integer> maxItineraryLength) {
        if (itineraryLength > maxItineraryLength.getValue()) {
            maxItineraryLength.setValue(itineraryLength);
            maxItinerary.setValue(String.valueOf(itinerary));
        }
    }
    // Создание карты полетов из списка списков
//    private static HashMap<String, ArrayList<String>> makeMap(List<List<String>> tickets) {
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        for (var ticket: tickets) {
//            String from = ticket.get(0);
//            String to = ticket.get(1);
//            if (map.containsKey(from)) {
//                var pq = map.get(from);
//                pq.add(to);
//            } else {
//                var pq = new ArrayList<String>();
//                pq.add(to);
//                map.put(from, pq);
//            }
//        }
//        for (var key: map.keySet()) {
//            Collections.sort(map.get(key));
//        }
//        return map;
//    }

////    private static void findLongestItinerary(HashMap<String, ArrayList<String>> newMap, String list, Pointer<String> maxList, int length, Pointer<Integer> maxLength, String currentCity) {
//    private static void findLongestItinerary(String currentCity, String list, int length, Pointer<String> maxList, Pointer<Integer> maxLength, HashMap<String, ArrayList<String>> newMap, ArrayList<String> currentCityFlights) {
////        var flights = newMap.get(currentCity);
////        if (flights == null || flights.size() == 0) {
////            if (length > maxLength.getValue()) {
////                maxLength.setValue(length);
////                maxList.setValue(String.valueOf(list));
////            }
////            return;
////        }
//        if (currentCityFlights == null || currentCityFlights.size() == 0) {
//            if (length > maxLength.getValue()) {
//                maxLength.setValue(length);
//                maxList.setValue(String.valueOf(list));
//            }
//            return;
//        }
//        for (String nextCity : currentCityFlights) {
////            findLongestItinerary(cloneMapRemoveFlight(newMap, currentCity, nextCity), list + " - " + nextCity, maxList, length + 1, maxLength, nextCity);
//            var newCityFlights = new ArrayList<>(newMap.get(currentCity));
//            newCityFlights.remove(nextCity);
//            findLongestItinerary(nextCity, list + " - " + nextCity, length + 1, maxList, maxLength, newMap, newCityFlights);
//        }
//    }

//    public static HashMap<String, ArrayList<String>> cloneMap(HashMap<String, ArrayList<String>> srcMap) {
//        HashMap<String, ArrayList<String>> destMap = new HashMap<>();
//        Set<Map.Entry<String, ArrayList<String>>> set = srcMap.entrySet();
//        for (var entry: set) {
//            destMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
//        }
//        return destMap;
//    }
//
//    public static HashMap<String, ArrayList<String>> cloneMapRemoveFlight(HashMap<String, ArrayList<String>> srcMap, String currentCity, String nextCity) {
//        var destMap = cloneMap(srcMap);
//        destMap.get(currentCity).remove(nextCity);
//        return destMap;
//    }
}
