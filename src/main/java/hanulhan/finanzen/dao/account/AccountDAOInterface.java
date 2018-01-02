/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.dao.account;

import hanulhan.finanzen.base.EntityAccount;
import hanulhan.finanzen.base.EntityBank;
import java.util.List;

/**
 *
 * @author uli
 */
public interface AccountDAOInterface {
    public List<EntityAccount> getAccountList();
    public EntityAccount findAccount(long aId);
    public EntityAccount findAccountByName(String aName);
    public List<EntityAccount> findAccountByType(String aType);
    public List<EntityAccount> findAccountByParentId(int aParentId);
    
    public boolean update(EntityAccount aEntityAccount);

    public boolean remove(EntityAccount aEntityAccount);

}
