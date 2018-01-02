/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.account;

import hanulhan.finanzen.base.EntityAccount;
import hanulhan.finanzen.dao.account.AccountDAOInterface;
import hanulhan.finanzen.util.SpringFinanzenBeansDef;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author uli
 */
public class AccountListBean implements ApplicationContextAware{
    private ArrayList<AccountBean> items;

    @Autowired
    private ApplicationContext applicationContext;
    private AccountDAOInterface dAOInterface;
    private static final Logger LOGGER = Logger.getLogger(AccountListBean.class);

    public ArrayList<AccountBean> getItems() {
        try {
            if (items == null)  {
                items = new ArrayList<>();
                List<EntityAccount> myAccountList = this.dAOInterface.getAccountList();
                for (EntityAccount temp : myAccountList)    {
                    AccountBean myAccount = (AccountBean) applicationContext.getBean(SpringFinanzenBeansDef.ACCOUNT_BEAN);
                }
            }
        } catch (Exception e)   {
            LOGGER.log(Level.ERROR, "unable to get Account list", e);
        }
        
        return items;
    }

    public void setItems(ArrayList<AccountBean> items) {
        this.items = items;
    }
    
    
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext= ac;
    }

    public AccountDAOInterface getdAOInterface() {
        return dAOInterface;
    }

    public void setdAOInterface(AccountDAOInterface dAOInterface) {
        this.dAOInterface = dAOInterface;
    }
    
    
}
