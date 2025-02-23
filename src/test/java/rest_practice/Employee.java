package rest_practice;

import java.util.List;

public class Employee {
    private String Name;

    private String Job;

    private List<Email> email;

    private String[] Skills;

    private Details details;

    public Employee(String name, String job, List<Email> email, String[] skills, Details details) {
        Name = name;
        Job = job;
        this.email = email;
        Skills = skills;
        this.details = details;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        Skills = skills;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

}


