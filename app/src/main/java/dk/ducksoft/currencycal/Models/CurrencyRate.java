package dk.ducksoft.currencycal.Models;

import android.media.Image;

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
        this.currencyFlag = currencyFlag;
    }

    /***
     * For use as testing values are ("TD",0.1).
     */
    public CurrencyRate(){
        this.currencyRateName = "TD";
        this.currencyRateValue = 0.1;
    }
}

/**
 * private static final String[] countries = new String[] {
 *         "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "ar", "at", "au", "ax", "az", "ba", "bb",
 *         "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bw", "by",
 *         "bz", "ca", "caf", "cas", "cd", "ceu", "cf", "cg", "ch", "ch", "ci", "cl", "cm", "cn",
 *         "cna", "co", "coc", "cr", "csa", "cu", "cv", "cy", "cz", "de", "dj", "dk", "dm", "dz", "ec",
 *         "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fm", "fr", "ga", "gb", "gd", "ge", "gh",
 *         "gm", "gn", "gq", "gr", "gt", "gw", "gy", "hk", "hn", "hr", "ht", "hu", "id", "ie", "il",
 *         "in", "iq", "ir", "is", "it", "jm", "jo", "jp", "ke", "kg", "kh", "km", "kn", "kp", "kr",
 *         "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma",
 *         "mc", "md", "me", "mg", "mk", "ml", "mm", "mn", "mo", "mr", "ms", "mt", "mu", "mv", "mw",
 *         "mx", "my", "mz", "na", "ne", "ng", "ni", "nl", "no", "np", "nz", "om", "pa", "pe", "pg",
 *         "ph", "pk", "pl", "pr", "pt", "pw", "py", "qa", "ro", "rs", "ru", "rw", "sa", "sb", "sc",
 *         "sd", "se", "sg", "si", "sk", "sl", "sm", "sn", "so", "sr", "st", "sv", "sy", "sz", "tc",
 *         "td", "tg", "th", "tj", "tl", "tm", "tn", "to", "tr", "tt", "tw", "tz", "ua", "ug", "us",
 *         "uy", "uz", "vc", "ve", "vg", "vn", "ws", "ww", "ye", "za", "zw"
 *     };
 *
 * */
