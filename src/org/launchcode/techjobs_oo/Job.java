package org.launchcode.techjobs_oo;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employer, location, positionType, coreCompetency);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String stringOfJobData = "";

        ArrayList<String> jobDataLables = new ArrayList<>();
        jobDataLables.add("Name: ");
        jobDataLables.add("Employer: ");
        jobDataLables.add("Location: ");
        jobDataLables.add("Position Type: ");
        jobDataLables.add("Core Competency: ");

        ArrayList<String> jobData = new ArrayList<>();
        jobData.add(this.getName());
        jobData.add(this.getEmployer().getValue());
        jobData.add(this.getLocation().getValue());
        jobData.add(this.getPositionType().getValue());
        jobData.add(this.getCoreCompetency().getValue());

        for (int i = 0; i < jobDataLables.size(); i++) {
            if (jobData.get(i).isBlank()) {
                stringOfJobData += jobDataLables.get(i) + "Data is not available\n";
            } else {
                stringOfJobData += jobDataLables.get(i) + jobData.get(i) + "\n";
            }
        }

        return "\nID: " + this.getId() + "\n" + stringOfJobData;

    }
}
