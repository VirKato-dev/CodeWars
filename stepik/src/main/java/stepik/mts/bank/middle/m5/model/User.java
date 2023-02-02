package stepik.mts.bank.middle.m5.model;

public class User {
    private long msisdn;
    private String firstname;
    private String lastname;

    public User(long msisdn, String firstname, String lastname) {
        this.msisdn = msisdn;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
