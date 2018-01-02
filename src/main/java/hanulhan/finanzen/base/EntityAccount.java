/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.base;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author uli
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "FROM EntityAccount a")
    , @NamedQuery(name = "Account.findById", query = "SELECT a FROM EntityAccount a WHERE a.id = :id")
    , @NamedQuery(name = "Account.findByName", query = "SELECT a FROM EntityAccount a WHERE a.name = :name")
    , @NamedQuery(name = "Account.findByType", query = "SELECT a FROM EntityAccount a WHERE a.type = :type")
    , @NamedQuery(name = "Account.findByIban", query = "SELECT a FROM EntityAccount a WHERE a.iban = :iban")
    , @NamedQuery(name = "Account.findByIdParent", query = "SELECT a FROM EntityAccount a WHERE a.idParent = :idParent")
    , @NamedQuery(name = "Account.findByDescription", query = "SELECT a FROM EntityAccount a WHERE a.description = :description")
    , @NamedQuery(name = "Account.findByPlaceholder", query = "SELECT a FROM EntityAccount a WHERE a.placeholder = :placeholder")
})
public class EntityAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Type")
    private String type;
    @Column(name = "IBAN")
    private String iban;
    @Column(name = "idParent")
    private BigInteger idParent;
    @Column(name = "description")
    private String description;
    @Column(name = "Placeholder")
    private Short placeholder;
    @JoinColumn(name = "idBank", referencedColumnName = "ID")
    @ManyToOne
    private EntityBank idBank;

    public EntityAccount() {
    }

    public EntityAccount(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigInteger getIdParent() {
        return idParent;
    }

    public void setIdParent(BigInteger idParent) {
        this.idParent = idParent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Short placeholder) {
        this.placeholder = placeholder;
    }

    public EntityBank getIdBank() {
        return idBank;
    }

    public void setIdBank(EntityBank idBank) {
        this.idBank = idBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityAccount)) {
            return false;
        }
        EntityAccount other = (EntityAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hanulhan.finanzen.base.Account[ id=" + id + " ]";
    }

    public void setIdParent(long idParent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
