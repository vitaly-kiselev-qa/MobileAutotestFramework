package ui.enums;

public enum Browsers {

    // enums with code example

    FIREFOX("Firefox"),
    CHROME("Chrome"),
    EDGE("Edge");

    private String code;
    Browsers(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}
