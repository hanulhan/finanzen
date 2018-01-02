/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.account;

import hanulhan.finanzen.base.EntityBank;
import hanulhan.finanzen.beans.bank.serBank;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author uli
 */
public class serAccount {
    private Long id;
    private String name;
    private String type;
    private String iban;
    private BigInteger idParent;
    private String description;
    private Short placeholder;
    private serBank idBank;    

    public serAccount() {
        super();
    }

    public serAccount(AccountBean aAccount) {
        super();
        this.id= aAccount.getId();
        this.name= aAccount.getName();
        this.type= aAccount.getType();
        this.iban= aAccount.getIban();
        this.idParent= aAccount.getIdParent();
        this.description= aAccount.getDescription();
        this.placeholder= aAccount.getPlaceholder();
        this.idBank= new serBank(aAccount.getBank());
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

    public serBank getIdBank() {
        return idBank;
    }

    public void setIdBank(serBank idBank) {
        this.idBank = idBank;
    }
    
    
    
}
