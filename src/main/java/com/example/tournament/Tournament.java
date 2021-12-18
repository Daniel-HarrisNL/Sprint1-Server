package com.example.tournament;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Tournament {

    private long id;
    private String heading;
    //TODO: Convert startDate & endDate to proper date type.
    private String startDate;
    private String endDate;
    private String location;
    private Double fee;
    private Double prize;
    private String standings;
    private String status;


    //Tournament ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    //Tournament Heading
    public String getHeading() { return heading; }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    //Tournament Start
    //TODO: Convert startDate to proper date type.
    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    //Tournament End
    //TODO: Convert endDate to proper date type.
    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    //Tournament Location
    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    //Tournament Fee
    public Double getFee() { return fee; }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    //Tournament Prize
    public Double getPrize() { return prize; }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    //Tournament Standings
    public String getStandings() { return standings; }

    public void setStandings(String standings) {
        this.standings = standings;
    }

    //Tournament Status
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}
