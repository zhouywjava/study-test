package Enum;

/**
 * @Description:
 * @Author: zyw
 * @Date: 2018/1/17
 */
public enum LoanStatus {
    PENDING_INTO_PIECES(0),PENDING_FIRST_TRIAL(1)
    ;
    private int value;

    LoanStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
