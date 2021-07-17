package objects;

public class Locator {
    String key, androidEl, iosEl, webEl;

    public Locator(String key, String androidEl, String iosEl, String webEl) {
        this.key = key;
        this.androidEl = androidEl;
        this.iosEl = iosEl;
        this.webEl = webEl;
    }

    public String getKey() {
        return this.key;
    }

    public String getAndroidEl() {
        return this.androidEl;
    }

    public String getIosEl() {
        return this.iosEl;
    }

    public String getWebEl() {
        return this.webEl;
    }
}
