/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.dao.bank;

import hanulhan.finanzen.base.EntityBank;
import java.util.List;

/**
 *
 * @author uli
 */
public interface BankDAOInterface {

    public List<EntityBank> getBankList();

    public EntityBank findBank(long aId);

    public EntityBank findBankByName(String aName);

    public boolean updateBank(EntityBank aEntityBank);
    public boolean removeBank(EntityBank aEntityBank);
    public boolean insertBank(EntityBank aEntityBank);
    
}
