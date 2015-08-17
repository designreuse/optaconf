package org.optaconf.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="optaconf_day")
public class Day extends AbstractPersistable implements Comparable<Day> {

    @Column(length=255, nullable=false)
    private String name;
    
    @Column(length=255, nullable=false)
    private String date;
    
    @OneToMany(mappedBy="day", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Timeslot> timeslots = new ArrayList<Timeslot>();
    
    @ManyToOne()
    @JoinColumn(name="conference_id", nullable=false)
    @JsonBackReference
    private Conference conference;
    
    public Day() {
    }

    public Day(String id, String name, String date, Conference conference) {
        super(id);
        this.name = name;
        this.date = date;
        this.conference = conference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Day other) {
        return date.compareTo(other.date);
    }

   public List<Timeslot> getTimeslots()
   {
      return timeslots;
   }

   public void setTimeslots(List<Timeslot> timeslots)
   {
      this.timeslots = timeslots;
   }

   public Conference getConference()
   {
      return conference;
   }

   public void setConference(Conference conference)
   {
      this.conference = conference;
   } 
    
}
