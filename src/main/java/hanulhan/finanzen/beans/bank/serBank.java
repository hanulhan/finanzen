/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanulhan.finanzen.beans.bank;

/**
 *
 * @author uli
 */
public class serBank {

    private long id;
    private String name;
    private String bic;

    public serBank() {
        super();
    }

    public serBank(BankBean aBank)  {
        super();
        this.id= aBank.getId();
        this.name= aBank.getName();
        this.bic= aBank.getBic();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    
}
