/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.bank;

import hanulhan.finanzen.base.EntityBank;
import hanulhan.finanzen.dao.bank.BankDAOInterface;
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
public class BankListBean implements ApplicationContextAware {

    private ArrayList<BankBean> items;
    
    @Autowired
    private ApplicationContext applicatioinContext;
    private BankDAOInterface daoInterface;
    private static final Logger LOGGER = Logger.getLogger(BankListBean.class);

    public BankListBean() {
        super();
    }

    public void remove (int i)  {
        getItems().remove(i);
    }
    
    public void add (BankBean bean) {
        getItems().add(bean);
    }

    public int size()   {
        return getItems().size();
    }
    
    public ArrayList<BankBean> getItems() {
        try {
        if (items == null)  {
            items = new ArrayList<>();
            List<EntityBank> myBankList= this.daoInterface.getBankList();
            for (EntityBank temp : myBankList)  {
                BankBean myBank = (BankBean)applicatioinContext.getBean(SpringFinanzenBeansDef.BANK_BEAN);
                items.add(myBank);
            }
        }
        } catch (Exception e)   {
            LOGGER.log(Level.ERROR, "unable to get Bank list", e);
        }
        return items;
    }

    public void setItems(ArrayList<BankBean> items) {
        this.items = items;
    }



    
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicatioinContext= ac;
    }

    public BankDAOInterface getDaoInterface() {
        return daoInterface;
    }

    public void setDaoInterface(BankDAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }





    
}