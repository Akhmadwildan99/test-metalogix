package metalogix.test.domain;

import java.util.List;

public class AccountAgg {
    private String accountNo;
    private int balance;
    private List<AccountAgg> childs;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {

        int sumBal = 0;

        if(this.childs != null && !this.getChilds().isEmpty()) {
            for (AccountAgg c : this.childs) {
                sumBal += c.getBalance();
            }
        } else {
            sumBal = balance;
        }
        return sumBal;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<AccountAgg> getChilds() {
        return childs;
    }

    public void setChilds(List<AccountAgg> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "{" +
                "accountNo:'" + getAccountNo() + '\'' +
                ", balance:" + getBalance() +
                ", childs:" + getChilds() +
                '}';
    }
}
