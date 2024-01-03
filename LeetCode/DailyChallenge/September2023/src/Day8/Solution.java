package Day8;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> layers = new ArrayList<>();
        List<Integer> firstLayer = new ArrayList<>();
        firstLayer.add(1);
        layers.add(firstLayer);
        for (int layer = 2; layer <= numRows; layer++) {
            List<Integer> prevLayer = layers.get(layer - 2);
            List<Integer> nextLayer = new ArrayList<>();
            nextLayer.add(1);
            for (int i = 0; i < prevLayer.size() - 1; i++) {
                nextLayer.add(prevLayer.get(i) + prevLayer.get(i + 1));
            }
            nextLayer.add(1);
            layers.add(nextLayer);
        }
        return layers;
    }
}
