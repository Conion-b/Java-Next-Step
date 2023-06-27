import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * [입금]
 * 조건 1. 1회 입금한도는 1,000,000으로 제한한다.
 * 조건 2. 입금제한한도 초과 시 RuntimeException 발생 메세지는 임금 가능 한도 초과
 * 조건 3. 입금 시 최소 금액은 10000원이다. 메세지는 최소 금액 미만입니다.
 * 조건 4. 입금액이 음수이면 RuntimeException 발생 메세지는 유효하지 않은 금액입니다.
 *
 * [출금]
 * 조건 1. 음수는 출금할 수 없다. RuntimeException 발생 메세지는 유효하지 않은 금액입니다.
 * 조건 2. 현재 소지금보다 많은 금액을 출금할 수 없다. RuntimeException 발생 메세지는 계좌 잔액이 부족합니다입니다.
 * 조건 3. 출금 시 password가 일치해야한다. 일치하지 않을 시 RuntimeException 발생 메세지는 패스워드 불일치입니다.
 *
 * [잔액 확인]
 * 조건 1. 잔액을 세자리 형태로 출력한다.
 */
public class BankTest {

    private Bank mybank;

    @BeforeEach
    public void setup(){
        mybank = new Bank("#1234");
    }

    @Test
    void 입금(){
        mybank.deposit(10000);
        assertEquals(10000, mybank.getMoney());
    }

    @Test
    void 임금한도_초과시_예외(){
        assertThrows(RuntimeException.class, () -> mybank.deposit(1_000_001));
    }

    @Test
    void 입금_최소금액_예외(){
        assertThrows(RuntimeException.class, () -> mybank.deposit(999));
    }

    @Test
    void 입금_금액_음수_예외(){
        assertThrows(RuntimeException.class, () -> mybank.deposit(-1));
    }

    @Test
    void 출금(){
        mybank.deposit(10000);
        assertDoesNotThrow(() -> mybank.withdraw(10000,"#1234"));
    }

    @Test
    void 출금시_패스워드_불일치(){
        assertThrows(RuntimeException.class,() -> mybank.withdraw(10000,"1234"));
    }

    @Test
    void 출금금액_음수_예외(){
        assertThrows(RuntimeException.class, () -> mybank.withdraw(-1,"#1234"));
    }

    @Test
    void 소지금보다_많은_금액_출금_예외(){
        mybank.deposit(2000);
        assertThrows(RuntimeException.class, () -> mybank.withdraw(2001,"#1234"));
    }

    @Test
    void 잔액조회_문자포멧(){
        mybank.deposit(10000);
        String getMoney = mybank.checkAccountMoney();
        assertEquals("10,000", getMoney);
    }
}