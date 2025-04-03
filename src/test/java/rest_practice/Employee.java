package rest_practice;

import java.util.List;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    private String name;
    private String job;
    private List<Email> email;
    private String[] skills;
    private Details details;

    public Employee(String name, String job, List<Email> email, String[] skills, Details details) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.skills = skills;
        this.details = details;
    }



}
