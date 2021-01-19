package beans.ringNotification;

import beans.DateTime;

public class RingNotification {

    private String nameSender;
    private String linkImgSender;
    private String content;
    private DateTime dateCreated;
    private String idSender;
    private int typeSender;
    private String link;

    public RingNotification() {
    }

    //  GETTER AND SETTER
    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public String getLinkImgSender() {
        return linkImgSender;
    }

    public void setLinkImgSender(String linkImgSender) {
        this.linkImgSender = linkImgSender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    public int getTypeSender() {
        return typeSender;
    }

    public void setTypeSender(int typeSender) {
        this.typeSender = typeSender;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
