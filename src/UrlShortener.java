import java.net.MalformedURLException;
import java.net.URL;

public class UrlShortener {

    private URL shortDomainUrl;

    private final static int MAX_SEO_LENGTH = 20;

    public UrlShortener (URL shortDomainUrl) {
        if (shortDomainUrl == null) {
            throw new IllegalArgumentException("Url cannot be null");
        }
        this.shortDomainUrl = shortDomainUrl;
    }

    public URL getShortenUrl (URL url, String seoKeyword) {
        if (url == null) {
            throw new IllegalArgumentException("Your url is null");
        }
        if (seoKeyword == null) {
            throw new IllegalArgumentException("Your SEO keyword is null");
        }


        if (seoKeyword.length()>MAX_SEO_LENGTH) {
            throw new IllegalArgumentException(String.format("Your SEO keyword is longer than %d", MAX_SEO_LENGTH));
        }

        URL result;
        try {
            result = new URL(shortDomainUrl, seoKeyword);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Input parameters are wrong.");
        }

        return result;
    }
}
