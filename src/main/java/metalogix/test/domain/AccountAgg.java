package metalogix.test.domain;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountAgg other = (AccountAgg) obj;
        if (this.balance != other.balance) {
            return false;
        }
        return Objects.equals(this.accountNo, other.accountNo);
    }
    
    
}
