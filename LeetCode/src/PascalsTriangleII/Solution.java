package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int rowIndex = 1;
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
    }

    public static List<Integer> getRow(int rowIndex) {
        // Iterative solution
//        List<Integer> prevLayer = new ArrayList<>();
//        prevLayer.add(1);
//        for (int layer = 1; layer <= rowIndex; layer++) {
//            List<Integer> nextLayer = new ArrayList<>();
//            nextLayer.add(1);
//            for (int i = 0; i < prevLayer.size() - 1; i++) {
//                nextLayer.add(prevLayer.get(i) + prevLayer.get(i + 1));
//            }
//            nextLayer.add(1);
//            prevLayer = nextLayer;
//        }
//        return prevLayer;
        // Math solution
        List<Integer> layer = new ArrayList<>();
        layer.add(1);
        long number = 1;
        if (rowIndex == 0) {
            return layer;
        }
        for (int layerIndex = 0; layerIndex < rowIndex; layerIndex++) {
            number = (number * (rowIndex - layerIndex)) / (layerIndex + 1);
            layer.add((int) number);
        }
        return layer;
    }
}
