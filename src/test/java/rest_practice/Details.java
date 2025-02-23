package rest_practice;

public class Details {

    private String Company;
    private String Location;

    public Details(String Company, String location){
        this.Company = Company;
        Location = location;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }



}
