package rest_practice;

public class Email {
    public Email(String emailType, String emailId) {
        this.emailType = emailType;
        this.emailId = emailId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailType;
    private String emailId;

}
