package Day23;

public class Solution {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
        Codec codec = new Codec();
        String sameUrl = codec.decode(codec.encode(url));
        System.out.println(url.equals(sameUrl));
        System.out.println(url);
        System.out.println(sameUrl);
    }
}
