/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 5000 Series
 */
@Entity
@Table(name = "PROGRAMMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programmer.findAll", query = "SELECT p FROM Programmer p")
    , @NamedQuery(name = "Programmer.findByEmail", query = "SELECT p FROM Programmer p WHERE p.email = :email")
    , @NamedQuery(name = "Programmer.findByPl", query = "SELECT p FROM Programmer p WHERE p.pl = :pl")
    , @NamedQuery(name = "Programmer.findByLang", query = "SELECT p FROM Programmer p WHERE p.lang = :lang")})
public class Programmer implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PL")
    private String pl;
    @Column(name = "LANG")
    private String lang;

    public Programmer() {
    }

    public Programmer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        String oldPl = this.pl;
        this.pl = pl;
        changeSupport.firePropertyChange("pl", oldPl, pl);
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        String oldLang = this.lang;
        this.lang = lang;
        changeSupport.firePropertyChange("lang", oldLang, lang);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmer)) {
            return false;
        }
        Programmer other = (Programmer) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "search.Programmer[ email=" + email + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
