package SerializeAndDeserializeBST;

public class Solution {
    public static void main(String[] args) {
//        String input = "5,1,4,n,n,3,6,5,n,10,11";
        String input = "1,n,2";

        Codec ser = new Codec();
        Codec deSer = new Codec();

        TreeNode root = deSer.deserialize(input);
        String output = ser.serialize(root);

        System.out.println(input);
        System.out.println(output);
        System.out.println(input.equals(output));
    }
}
