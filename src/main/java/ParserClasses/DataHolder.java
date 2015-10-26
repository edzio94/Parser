package ParserClasses;

/**
 * Created by lukasz on 26.10.15.
 */
public class DataHolder {
    private String input;
    private Boolean domainOnly;
    private Boolean showLinks;


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Boolean getDomainOnly() {
        return domainOnly;
    }

    public void setDomainOnly(Boolean domainOnly) {
        this.domainOnly = domainOnly;
    }

    public Boolean getShowLinks() {
        return showLinks;
    }

    public void setShowLinks(Boolean showLinks) {
        this.showLinks = showLinks;
    }
}
