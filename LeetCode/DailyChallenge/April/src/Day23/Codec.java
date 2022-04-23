package Day23;

import java.util.HashMap;

public class Codec {
    HashMap<String, String> urls;
    public Codec() {
        urls = new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        String shortUrl = String.valueOf(hash);
        urls.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = urls.get(shortUrl);
        return longUrl;
    }
}
