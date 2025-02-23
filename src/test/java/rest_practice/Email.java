package rest_practice;

public class Email {

    private String emailType;
    private String emailValue;


    public Email(String emailType, String emailValue) {
        this.emailType = emailType;
        this.emailValue = emailValue;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }


}
