/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.dao.bank;

import hanulhan.finanzen.base.EntityBank;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author uli
 */
public class BankDAO implements BankDAOInterface {

    private static final Logger LOGGER = Logger.getLogger(BankDAO.class);

    @PersistenceContext(unitName = "PersistenceFinanzen")
    private EntityManager em;

    public BankDAO() {
        super();
    }

    
    
    
    @Override
    public List<EntityBank> getBankList() {
        try {
            Query q1 = em.createNamedQuery("Bank.findAll");
            return q1.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to load bank list", e);
            return null;
        }
    }

    @Override
    public EntityBank findBank(long aId) {
        try {
            return em.find(EntityBank.class, aId);
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "unable to load bank by id " + aId + " not found");
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "unable to load bank by id " + aId, e);
            return null;
        }

    }

    @Override
    public EntityBank findBankByName(String aName) {
        try {
            Query q1 = em.createNamedQuery("Bank.findByName");
            q1.setParameter("name", aName);
            return (EntityBank) q1.getSingleResult();
        } catch (NonUniqueResultException e) {
            LOGGER.log(Level.ERROR, "more than 1 bank found for name " + aName);
            return null;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to access bank by name" + aName, e);
            return null;
        }
    }

    
    @Transactional(value = "transactionManagerFinanzen")
    @Override
    public boolean update(EntityBank aEntityBank) {
        try {
            if (aEntityBank.getId() == null)
                em.persist(aEntityBank);
            else
                 em.merge(aEntityBank);
        }
        catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to save bank " + aEntityBank.toString(), e);
            return false;
        }
        return true;
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Override
    public boolean remove(EntityBank aEntityBank) {
        try {
           em.remove(aEntityBank);
        }
        catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to remove bank " + aEntityBank.toString(), e);
            return false;
        }
        return true;
        
    }


    public EntityManager getEm() {
        return em;
    }

    @PersistenceContext(unitName = "PersistenceFinanzen")
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
