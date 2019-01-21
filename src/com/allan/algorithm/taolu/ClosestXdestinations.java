package com.allan.algorithm.taolu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 *  At the very least, the runtime will be n, because we need to check all locations.
 *
 * Steps:
 *  - create a class called LocationInfo, with the following attributes:
 *      x, y - coordinates
 *      distance - which is the value of square root of x^2 and y^2 (pythagorean theorem)
 *
 *  - Create a TreeSet<LocationInfo> in descending order. TreeSet guarantees not just ordering, but also uniqueness.
 *    (My first thought was to use Min Heap, but Min Heap does not have de-duplication built-in.)
 *
 *  - Loop thru allLocations and add each entry into a TreeSet. - O(n)
 *
 * - loop thru the treeSet and add element to result while counter < numDeliveries.
 *
 *
 *  Final note: I can simplify this further using TreeMap and eliminate the class LocationInfo, but I think having the
 *  LocationInfo is a better design. More object oriented.
 *
 **/
public class ClosestXdestinations {


    public static void main(String[] args) {
        List<List<Integer>> allLocations = new ArrayList<>();
        List<Integer> location1 = new ArrayList<>();
        location1.add(1);
        location1.add(2);
        allLocations.add(location1);

        List<Integer> location2 = new ArrayList<>();
        location2.add(3);
        location2.add(4);
        allLocations.add(location2);

        List<Integer> location3 = new ArrayList<>();
        location3.add(1);
        location3.add(-1);
        allLocations.add(location3);

        List<Integer> location4 = new ArrayList<>();
        location4.add(1);
        location4.add(-1);
        allLocations.add(location4);

        List<Integer> location5 = new ArrayList<>();
        location5.add(1);
        location5.add(2);
        allLocations.add(location5);

        List<List<Integer>> selectedLocations = ClosestXdestinations(5, allLocations, 2);

        for (List<Integer> selectedLocation : selectedLocations) {
            System.out.println(selectedLocation.get(0));
            System.out.println(selectedLocation.get(1));
        }
    }

    private static List<List<Integer>> ClosestXdestinations(int numDestiations, List<List<Integer>> allLocations, int numDeliveries) {


        List<List<Integer>> deliverDestinations = new ArrayList<>();

        if (numDeliveries <= 0 || numDestiations <= 0 || allLocations == null || allLocations.isEmpty()) {
            return deliverDestinations;
        }

        if (numDeliveries > numDestiations) {
            throw new IllegalArgumentException("");
        }

        TreeSet<LocationInfo> deliveredDestinationDescendingOrder = new TreeSet<>((Comparator<LocationInfo>) (o1, o2) -> Double.compare(o1.getDistance(), o2.getDistance()));


        allLocations.forEach(coordinates -> {
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            deliveredDestinationDescendingOrder.add(new LocationInfo(x, y));
        });

//        for(List<Integer> coordinates: allLocations ) {
//            int x = coordinates.get(0);
//            int y = coordinates.get(1);
//            deliveredDestinationDescendingOrder.add(new LocationInfo(x, y));
//        }

        int counter = 0;
//        for(LocationInfo locationInfo : deliveredDestinationDescendingOrder) {
//            if(counter < numDeliveries) {
//                List<Integer> deliverDestination = new ArrayList<Integer>();
//                deliverDestination.add(locationInfo.getX());
//                deliverDestination.add(locationInfo.getY());
//                deliverDestinations.add(deliverDestination);
//                counter++;
//            }
//        }

        int destinationCounter = 0;
        for (Iterator<LocationInfo> iterator = deliveredDestinationDescendingOrder.iterator(); iterator.hasNext() && destinationCounter < numDestiations; ) {
            LocationInfo locationInfo = iterator.next();
            if (counter < numDeliveries) {
                List<Integer> deliverDestination = new ArrayList<Integer>();
                deliverDestination.add(locationInfo.getX());
                deliverDestination.add(locationInfo.getY());
                deliverDestinations.add(deliverDestination);
                counter++;
            }
        }


//        for( int i = 0; i < numDestiations; i++) {
//            if(counter < numDeliveries) {
//
//                List<Integer> deliverDestination = new ArrayList<Integer>();
//                deliverDestination.add(locationInfo.getX());
//                deliverDestination.add(locationInfo.getY());
//                deliverDestinations.add(deliverDestination);
//                counter++;
//            }
//        }


        return deliverDestinations;
    }

    static final class LocationInfo {
        int x;
        int y;
        double distance;

        public LocationInfo(int x, int y) {
            this.x = x;
            this.y = y;
            distance = calculateDistance(x, y);
        }

        private static double calculateDistance(int x, int y) {
            return Math.sqrt(x * x + y * y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double getDistance() {
            return distance;
        }
    }


}
