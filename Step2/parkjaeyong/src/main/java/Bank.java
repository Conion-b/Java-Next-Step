import java.text.DecimalFormat;
import java.util.Objects;

public class Bank {

    private int money;
    private String password;

    Bank(String password){
        this.password = password;
    }
    public void deposit(int money) {
        isValidDepositMoney(money);
        this.money += money;
    }

    public void withdraw(int money,String password) {
        isValidPassword(password);
        isValidWithdrawMoney(money);
        this.money -= money;
    }

    public String checkAccountMoney() {
        return new DecimalFormat("#,###").format(money);
    }

    public int getMoney() {
        return money;
    }

    private void isValidDepositMoney(int money) {
        if (money > 1_000_000) {
            throw new RuntimeException("임금 가능 한도 초과");
        }
        if (money < 0) {
            throw new RuntimeException("유효하지 않은 금액");
        }
        if (money < 1000) {
            throw new RuntimeException("최소 금액 미만");
        }
    }

    private void isValidWithdrawMoney(int money) {
        if (money < 0) {
            throw new RuntimeException("유효하지 않은 금액");
        }
        if (this.money < money) {
            throw new RuntimeException("계좌 잔액이 부족합니다");
        }
    }


    private void isValidPassword(String password) {
        if (!Objects.equals(this.password,password)){
            throw new RuntimeException("패스워드 불일치");
        }
    }

}