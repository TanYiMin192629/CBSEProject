/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chaiq
 */
@Entity
@Table(name = "EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByEventid", query = "SELECT e FROM Events e WHERE e.eventid = :eventid"),
    @NamedQuery(name = "Events.findByName", query = "SELECT e FROM Events e WHERE e.name = :name"),
    @NamedQuery(name = "Events.findByDate", query = "SELECT e FROM Events e WHERE e.date = :date"),
    @NamedQuery(name = "Events.findByTime", query = "SELECT e FROM Events e WHERE e.time = :time"),
    @NamedQuery(name = "Events.findByVenue", query = "SELECT e FROM Events e WHERE e.venue = :venue"),
    @NamedQuery(name = "Events.findByFee", query = "SELECT e FROM Events e WHERE e.fee = :fee"),
    @NamedQuery(name = "Events.findByDescription", query = "SELECT e FROM Events e WHERE e.description = :description")})
public class Events implements Serializable {

    @OneToMany(mappedBy = "eventid")
    private Collection<Ticket> ticketCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENTID")
    private Integer eventid;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DATE")
    private String date;
    @Size(max = 255)
    @Column(name = "TIME")
    private String time;
    @Size(max = 255)
    @Column(name = "VENUE")
    private String venue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FEE")
    private Double fee;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    public Events() {
    }

    public Events(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Events[ eventid=" + eventid + " ]";
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }
    
}
