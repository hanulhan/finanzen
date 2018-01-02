/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.bank;

import javax.transaction.Transactional;
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
    
    public BankBeanTest() {
    }

    @Test
    public void testSomeMethod() {
        LOGGER.log(Level.DEBUG, "Testit");
        Assert.assertTrue("", true);
    }
    
}
