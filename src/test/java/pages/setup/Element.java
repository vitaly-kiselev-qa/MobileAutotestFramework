package pages.setup;

public class Element {
    String key, androidEl, iosEl;

    public Element(String key, String androidEl, String iosEl) {
        this.key = key;
        this.androidEl = androidEl;
        this.iosEl = iosEl;
    }

    public static Element create(String key, String androidEl, String iosEl, String web) {
        return new Element(key,androidEl,iosEl);
    }
    public static Element create(String key, String androidEl, String iosEl) {
        return create(key, androidEl, iosEl,"");
    }
    public static Element create(String key, String web) {
        return create(key, "", "",web);
    }
}
