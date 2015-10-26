package ParserClasses;

/**
 * Created by lukasz on 26.10.15.
 */
public class DataHolder {
    private String input;
    private Boolean domainOnly;
    private Boolean showLinks;
    private Boolean isURL;
    private String linkOption;


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

    public String getLinkOption() {
        return linkOption;
    }

    public void setLinkOption(String linkOption) {
        this.linkOption = linkOption;
    }

    public Boolean getIsURL() {
        return isURL;
    }

    public void setIsURL(Boolean isURL) {
        this.isURL = isURL;
    }
}
