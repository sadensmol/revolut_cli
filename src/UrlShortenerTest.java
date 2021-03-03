import jdk.nashorn.api.scripting.URLReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/*

 */
class UrlShortenerTest {

    @Test
    void testIfConfiguredWithNullAsUrl() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new UrlShortener(null));
    }

    @Test
    void testIfPassedUrlIsNull() throws MalformedURLException {
        URL url = new URL("http://www.ya.ru");
        UrlShortener urlShortener = new UrlShortener(url);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> urlShortener.getShortenUrl(null, "SEO"));
    }

    @Test
    void testIfPassedSeoKeywordIsNull() throws MalformedURLException {
        URL url = new URL("http://www.ya.ru");
        UrlShortener urlShortener = new UrlShortener(url);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> urlShortener.getShortenUrl(url, null));
    }


    @Test
    void testSEOIsMoreThan20Characters() throws MalformedURLException {
        URL shortUrl = new URL("http://short.com");
        URL url = new URL("http://looooong.com/somepath");
        URL resultShortURL = new URL("http://short.com/MY-NEW-WS");

        UrlShortener urlShortener = new UrlShortener(shortUrl);

        Assertions.assertThrows(IllegalArgumentException.class, () -> urlShortener.getShortenUrl(url, "123456789012345678901"));
    }

    @Test
    void testIfWeGetAValidURLBack() throws MalformedURLException {
        URL shortUrl = new URL("http://short.com");
        URL url = new URL("http://looooong.com/somepath");
        URL resultShortURL = new URL("http://short.com/MY-NEW-WS");

        UrlShortener urlShortener = new UrlShortener(shortUrl);

        Assertions.assertEquals(resultShortURL, urlShortener.getShortenUrl(url, "MY-NEW-WS"));
    }

}