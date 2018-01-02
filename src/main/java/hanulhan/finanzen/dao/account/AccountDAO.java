/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.dao.account;

import hanulhan.finanzen.base.EntityAccount;
import hanulhan.finanzen.base.EntityBank;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uli
 */
public class AccountDAO implements AccountDAOInterface {

    private static final Logger LOGGER = Logger.getLogger(AccountDAO.class);

    @PersistenceContext(unitName = "PersistenceFinanzen")
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<EntityAccount> getAccountList() {
        try {
            Query q1 = em.createNamedQuery("Account.findall");
            return q1.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to load account list", e);
            return null;
        }
    }

    @Override
    public EntityAccount findAccount(long aId) {
        try {
            return em.find(EntityAccount.class, aId);
        } catch (NoResultException e) {
            LOGGER.log(Level.INFO, "unable to load account by id " + aId + " not found");
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, "unable to load account by id " + aId, e);
            return null;
        }
    }

    @Override
    public EntityAccount findAccountByName(String aName) {
        try {
            Query q1 = em.createNamedQuery("Bank.findByName");
            q1.setParameter("Name", aName);
            return (EntityAccount) q1.getSingleResult();
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

    @Override
    public List<EntityAccount> findAccountByType(String aType) {
        try {
            Query q1 = em.createNamedQuery("Bank.findByName");
            q1.setParameter("Type", aType);
            return (List<EntityAccount>) (EntityAccount) q1.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to access account by type" + aType, e);
            return null;
        }
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Override
    public List<EntityAccount> findAccountByParentId(int aParentId) {
        try {
            Query q1 = em.createNamedQuery("Bank.findByIdParent");
            q1.setParameter("idParent", aParentId);
            return (List<EntityAccount>) (EntityAccount) q1.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to access account by ParentId" + aParentId, e);
            return null;
        }
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Override
    public boolean update(EntityAccount aEntityAccount) {
        try {
            if (aEntityAccount.getId() == null) {
                em.persist(aEntityAccount);
            } else {
                em.merge(aEntityAccount);
            }
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to save account " + aEntityAccount.toString(), e);
            return false;
        }
        return true;
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Override
    public boolean remove(EntityAccount aEntityAccount) {
        try {
            em.remove(aEntityAccount);
        } catch (Exception e) {
            LOGGER.log(Level.FATAL, "unable to remove account " + aEntityAccount.toString(), e);
            return false;
        }
        return true;
    }

}
