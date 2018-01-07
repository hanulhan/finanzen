/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.bank;

import hanulhan.finanzen.beans.account.AccountBean;
import hanulhan.finanzen.util.SpringFinanzenBeansDef;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author uli
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManagerFinanzen", defaultRollback = true)
@Transactional
public class BankBeanTest  extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger LOGGER = LogManager.getLogger(BankBeanTest.class);
    private EntityManager emFinanzen;
    
    public BankBeanTest() {
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Test
    public void testFindBank() {
        LOGGER.log(Level.DEBUG, "testFindBank");
        BankListBean myBankListBean = (BankListBean) applicationContext.getBean(SpringFinanzenBeansDef.BANK_LIST_BEAN);
        List<BankBean> myBankList= myBankListBean.getItems();

        BankBean myBank= (BankBean)applicationContext.getBean(SpringFinanzenBeansDef.BANK_BEAN);
        myBank.InitializeByName("Postbank");
        Assert.assertTrue("", myBank != null);
    }

    @Transactional(value = "transactionManagerFinanzen")
    @Test
    public void testNewBank() {
        LOGGER.log(Level.DEBUG, "testNewBank");

        BankBean myBank= (BankBean)applicationContext.getBean(SpringFinanzenBeansDef.BANK_BEAN);
        myBank.setName("MyTestBank");
        myBank.setBic("BICTEST");
        Assert.assertTrue("", myBank != null);
        
        AccountBean rootAcoount = (AccountBean)applicationContext.getBean(SpringFinanzenBeansDef.ACCOUNT_BEAN);

        AccountBean myAccount = (AccountBean)applicationContext.getBean(SpringFinanzenBeansDef.ACCOUNT_BEAN);
        myAccount.setName("TestAccount");
        myAccount.setDescription("Description");

        
        
    }
    
    public EntityManager getEmFinanzen() {
        return emFinanzen;
    }

    public void setEmFinanzen(EntityManager emFinanzen) {
        this.emFinanzen = emFinanzen;
    }
    
    
}
