/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.account;

import hanulhan.finanzen.base.EntityAccount;
import hanulhan.finanzen.beans.bank.BankBean;
import hanulhan.finanzen.dao.account.AccountDAOInterface;
import hanulhan.finanzen.util.SpringFinanzenBeansDef;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author uli
 */
public class AccountBean implements ApplicationContextAware {

    private static final Logger LOGGER = Logger.getLogger(AccountBean.class);
    private ApplicationContext applicationContext;
    private AccountDAOInterface daoInterface;
    private EntityAccount entityAccount;
    
    private long id;
    private String name;
    private String type;
    private String iban;
    private long idParent;
    private String description;
    private Short placeholder;
    private BankBean bank;

    

    public AccountBean() {
        super();
    }

    public AccountBean(EntityAccount aEntity) {
        super();
        this.entityAccount = aEntity;
    }

    public AccountBean(long id) {
        super();
        this.id = id;
    }

    private boolean isLoaded() {
        return this.getEntityAccount() != null;
    }

    public EntityAccount getEntityAccount() {
        if (entityAccount == null)  {
            if (id == 0)    {
                entityAccount= new EntityAccount();
            } else {
                try {
                    entityAccount= getDaoInterface().findAccount(id);
                } catch (Exception e){
                    LOGGER.log(Level.ERROR, "unable to create account  with id " + id, e);
                }
            }
        }
        return entityAccount;
    }

    public long getId() {
        long tstId= 0;
        try {
            tstId= this.getEntityAccount().getId();
        } catch (Exception e)   {
            LOGGER.log(Level.ERROR, "unable to get id", e);
        }
        return tstId;
    }
    

    public String getName() {
        return this.getEntityAccount().getName();
    }

    public void setName(String aName) {
        this.getEntityAccount().setName(aName);
    }

    public String getType() {
        return this.getEntityAccount().getType();
    }

    public void setType(String aType) {
        this.getEntityAccount().setType(aType);
    }

    public String getIban() {
        return this.getEntityAccount().getIban();
    }

    public void setIban(String aIban) {
        this.getEntityAccount().setIban(aIban);
    }

    public long getIdParent() {
        return this.getEntityAccount().getIdParent();
    }

    public void setIdParent(long idParent) {
        this.getEntityAccount().setIdParent(idParent);
    }

    public String getDescription() {
        return this.getEntityAccount().getDescription();
    }

    public void setDescription(String aDescription) {
        this.getEntityAccount().setDescription(aDescription);
    }

    public Short getPlaceholder() {
        return this.getEntityAccount().getPlaceholder();
    }

    public void setPlaceholder(Short aPlaceholder) {
        this.entityAccount.setPlaceholder(aPlaceholder);
    }

    public BankBean getBank() {
        if (bank == null)   {
            bank = (BankBean) applicationContext.getBean(SpringFinanzenBeansDef.BANK_BEAN, this.getEntityAccount().getIdBank());
        }
        
        return bank;
    }

    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    
    
    
    
    public AccountDAOInterface getDaoInterface() {
        return daoInterface;
    }

    public void setDaoInterface(AccountDAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }


    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext= ac;
    }
 
    
    
}
