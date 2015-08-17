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
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Group of tracks
 */
@Entity(name = "optaconf_track")
public class Track extends AbstractPersistable
{
   @Column
   private String title;
   
   @Column
   private String cssStyleClass;
   
   @OneToMany(mappedBy="track", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Talk> talks = new ArrayList<Talk>();

   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="conference_id", nullable=false)
   @JsonBackReference
   private Conference conference;
   
   public Track()
   {}

   public Track(String id, String title, String cssStyleClass, Conference conference)
   {
      super(id);
      this.title = title;
      this.cssStyleClass = cssStyleClass;
      this.conference = conference;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getCssStyleClass()
   {
      return cssStyleClass;
   }

   public void setCssStyleClass(String cssStyleClass)
   {
      this.cssStyleClass = cssStyleClass;
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
