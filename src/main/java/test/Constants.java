package test;

/**
 * @Description:
 * @Author: zyw
 * @Date: 2018/1/17
 */
public class Constants {

   /* public Enum LoanStatus{
        ;
    }*/

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

    public static class ParamsSettingKey {

        /** 资金成本-先息后本费率*/
        public static final String CAPITAL_COST_RATE_INTEREST_PRINCIPAL = "capital.cost.rate.interest.principal";

        /** 资金成本-等额本息费率*/
        public static final String CAPITAL_COST_RATE_EQUAL_PRINCIPAL_INTEREST = "capital.cost.rate.equal.principal.interest";

        /** 标的收益率*/
        public static final String OBJECT_RATE_MONTH_0 = "object.rate.month.0";
        public static final String OBJECT_RATE_MONTH_1 = "object.rate.month.1";
        public static final String OBJECT_RATE_MONTH_2 = "object.rate.month.2";
        public static final String OBJECT_RATE_MONTH_3 = "object.rate.month.3";
        public static final String OBJECT_RATE_MONTH_6 = "object.rate.month.6";
        public static final String OBJECT_RATE_MONTH_9 = "object.rate.month.9";
        public static final String OBJECT_RATE_MONTH_12 = "object.rate.month.12";
        public static final String OBJECT_RATE_MONTH_18 = "object.rate.month.18";
        public static final String OBJECT_RATE_MONTH_24 = "object.rate.month.24";

    }

        /*public static final int PENDING_INTO_PIECES = 0;
        public static final int PENDING_FIRST_TRIAL = 1;
        public static final int FIRST_TRIAL_ING = 2;
        public static final int PENDING_FINAL_JUDGMENT = 3;
        public static final int FINAL_JUDGMENT_ING = 4;
        public static final int PENDING_DIRECTOR = 5;
        public static final int DIRECTOR_ING = 6;
        public static final int PENDING_MANAGER = 7;
        public static final int MANAGER_ING = 8;
        public static final int PENDING_MAJORDOMO = 9;
        public static final int APPROVAL_REFUSE  = 10;
        public static final int REDISCUSS_PENDING_APPROVAL = 11;
        public static final int PENDING_CUSTOM_SERVICE_PATCH = 12;
        public static final int PENDING_OUTER_PATCH = 13;
        public static final int PENDING_FIRST_TRIAL_PATCH = 14;
        public static final int PENGING_PUBLISH  = 15;
        public static final int FUNDRAISING = 16;
        public static final int REPAYMENT_ING = 17;
        public static final int REPAYMENTS = 18;
        public static final int PREPAYMENT = 19;
        public static final int OVERDUED = 20;
        public static final int REFUSE = 21;
        public static final int PENDING_OPEN_BID = 22;
        public static final int FULL_SCALE = 23;
        public static final int FAIL_BID = 24;
        public static final int PENDING_PRO_MANAGER = 25;
        public static final int PRO_MANAGER_ING = 26;*/

    public static void main(String[] args) {

    }
}
