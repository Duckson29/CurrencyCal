package dk.ducksoft.currencycal.Models;
/***
 * Stroes two kind of infomation about the currency such as the rate and the name of it..
 * */
public class CurrencyRate {

    private String currencyRateName;
    private double currencyRateValue;

    public String getCurrencyRateName() {
        return currencyRateName;
    }

    public void setCurrencyRateName(String currencyRateName) {this.currencyRateName = currencyRateName;}

    public double getCurrencyRateValue() {
        return currencyRateValue;
    }

    public void setCurrencyRateValue(double currencyRateValue) {this.currencyRateValue = currencyRateValue;}

    /***
     * @param currencyRateName the name of the valuta is the shorthand name for the currency ("Densih Kronner" is "DK" or "USA Dollers" is "US")
     * @param currencyRateValue the current rate of the currency conversion. in double (eg. 0.5 or 1.5).
     */
    public CurrencyRate(String currencyRateName, double currencyRateValue) {
        this.currencyRateName = currencyRateName;
        this.currencyRateValue = currencyRateValue;
    }

    /***
     * For use as testing values are ("TD",0.1).
     */
    public CurrencyRate(){
        this.currencyRateName = "TD";
        this.currencyRateValue = 0.1;
    }


}
