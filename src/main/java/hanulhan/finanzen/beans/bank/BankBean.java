/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.bank;

import hanulhan.finanzen.base.EntityAccount;
import hanulhan.finanzen.base.EntityBank;
import hanulhan.finanzen.dao.bank.BankDAOInterface;
import java.util.Collection;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author uli
 */
public class BankBean implements ApplicationContextAware {

    private static final Logger LOGGER = Logger.getLogger(BankBean.class);
    private ApplicationContext applicationContext;
    private BankDAOInterface daoInterface;
    private EntityBank entityBank;

    private long id;

    public BankBean() {
        super();
    }

    public BankBean(EntityBank aEntity) {
        super();
        this.entityBank = aEntity;
    }

    public BankBean(int id) {
        super();
        this.id = id;
    }

    public boolean isLoaded() {
        return this.getEntityBank() != null;
    }

    public EntityBank getEntityBank() {
        if (entityBank == null) {
            if (id == 0) {
                entityBank = new EntityBank();
            } else {
                try {
                    entityBank = getDaoInterface().findBank(id);
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, "unable to create hotel  with id " + id, e);
                }
            }
        }

        return entityBank;
    }

    public long getId() {
        long myId = 0;
        try {
            myId = this.getEntityBank().getId();
        } catch (Exception E) {
        }
        return myId;
    }

    public String getName() {
        return this.getEntityBank().getName();
    }

    public void setName(String aName) {
        this.getEntityBank().setName(aName);
    }

    public String getBic() {
        return this.getEntityBank().getBic();
    }

    public void setBic(String aBic) {
        this.getEntityBank().setBic(aBic);
    }

    public Collection<EntityAccount> getAccountCollection() {
        return this.getEntityBank().getAccountCollection();
    }

    public void setAccountCollection(Collection<EntityAccount> aAccountCollection) {
        this.getEntityBank().setAccountCollection(aAccountCollection);
    }

    public BankDAOInterface getDaoInterface() {
        return daoInterface;
    }

    public void setDaoInterface(BankDAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
    }

}
