package dk.ducksoft.currencycal.Models;

import android.graphics.drawable.Drawable;
import android.media.Image;

import dk.ducksoft.currencycal.R;

/***
 * Stroes two kind of infomation about the currency such as the rate and the name of it..
 * */
public class CurrencyRate {

    private String currencyRateName;
    private double currencyRateValue;
    private int currencyFlag;

    public String getCurrencyRateName() {
        return currencyRateName;
    }

    public void setCurrencyRateName(String currencyRateName) {this.currencyRateName = currencyRateName;}

    public double getCurrencyRateValue() {
        return currencyRateValue;
    }

    public void setCurrencyRateValue(double currencyRateValue) {this.currencyRateValue = currencyRateValue;}

    public int getCurrencyFlag() {return currencyFlag;}

    public void setCurrencyFlag(int currencyFlag) {this.currencyFlag = currencyFlag;}

    /***
     * @param currencyRateName the name of the valuta is the shorthand name for the currency ("Densih Kronner" is "DK" or "USA Dollers" is "US")
     * @param currencyRateValue the current rate of the currency conversion. in double (eg. 0.5 or 1.5).
     * @param currencyFlag the Flag "Icon" for the contruy.
     */
    public CurrencyRate(String currencyRateName, double currencyRateValue, int currencyFlag) {
        this.currencyRateName = currencyRateName;
        this.currencyRateValue = currencyRateValue;
        this.currencyFlag = 0;
    }

    /***
     * For use as testing values are ("TD",0.1).
     */
    public CurrencyRate(){
        this.currencyRateName = "TD";
        this.currencyRateValue = 0.1;
    }
}
