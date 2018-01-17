package test;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.apache.commons.lang3.StringUtils;
import test.Constants;

/**
 * @Description:
 * @Author: zyw
 * @Date: 2018/1/17
 */
public class CrosierServiceImplTest {

    public boolean containsAuthority(String binding, String authority)
    {
        if(StringUtils.isBlank(binding))
            return true;

        if(StringUtils.isBlank(authority))
            return false;

        return binding.indexOf(authority)>-1;
    }

    public static void main(String[] args) {
        CrosierServiceImplTest test = new CrosierServiceImplTest();
        System.out.println(test.containsAuthority("",null));
        System.out.println(Constants.LoanStatus.PENDING_FIRST_TRIAL.getValue());
        System.out.println(Constants.ParamsSettingKey.CAPITAL_COST_RATE_EQUAL_PRINCIPAL_INTEREST);
        //Constants.ParamsSettingKey paramsSettingKey = new Constants().new ParamsSettingKey();
        Constants.ParamsSettingKey p = new Constants.ParamsSettingKey();

    }
}
