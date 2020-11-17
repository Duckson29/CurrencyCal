package dk.ducksoft.currencycal;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dk.ducksoft.currencycal.Models.CurrencyCalculator;
import dk.ducksoft.currencycal.Models.CurrencyRate;

public class MainPresenter implements MainContract.Presenter, OnJsonRespon {

    private MainContract.MvpView mvpView;

    public ArrayList<CurrencyRate> getData() {
        return data;
    }

    WebApiCaller apiCaller = new WebApiCaller();
    CurrencyCalculator calculator;

    public void setData(ArrayList<CurrencyRate> data) {
        this.data = data;
    }

    private ArrayList<CurrencyRate> data;
    private  ArrayList<String> countes;

    MainPresenter(MainContract.MvpView view) {
        mvpView = view;
        data = CreateTestData();
        apiCaller.addListener(this::OnDataRecived);
        countes = CreateSpinnerContent();
    }

    /**
     * this handles the btn press from the view.
     */
    @Override
    public void handleConvertButtonClick(View view) {

        apiCaller.GetNewCurrencyRate(view.getContext());
//        calculator.calculatRate();
    }

    @Override
    public void OnDataRecived(String data) {

//        this.data.add(data);
        Log.e("onjsondata", "resived deata");
    }

    public ArrayList<CurrencyRate> CreateTestData() {
        CurrencyRate tempNew = new CurrencyRate("dk", 0.7, R.drawable.dk);
        CurrencyRate tempNew2 = new CurrencyRate("us", 0.7, R.drawable.ua);
        CurrencyRate tempNew3 = new CurrencyRate("eu", 0.7, R.drawable.eu);
        CurrencyRate tempNew4 = new CurrencyRate("de", 0.7, R.drawable.de);
        CurrencyRate tempNew5 = new CurrencyRate("se", 0.7, R.drawable.se);
        CurrencyRate tempNew6 = new CurrencyRate("uk", 0.7, R.drawable.gb);
        ArrayList<CurrencyRate> tempList = new ArrayList<CurrencyRate>();
        tempList.add(tempNew);
        tempList.add(tempNew2);
        tempList.add(tempNew3);
        tempList.add(tempNew4);
        tempList.add(tempNew5);
        tempList.add(tempNew6);
        return tempList;

    }

    public ArrayList<String> CreateSpinnerContent() {
        String[] countries = new String[]{
                "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "ar", "at", "au", "ax", "az", "ba", "bb",
                "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bw", "by",
                "bz", "ca", "caf", "cas", "cd", "ceu", "cf", "cg", "ch", "ch", "ci", "cl", "cm", "cn",
                "cna", "co", "coc", "cr", "csa", "cu", "cv", "cy", "cz", "de", "dj", "dk", "dm", "dz", "ec",
                "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fm", "fr", "ga", "gb", "gd", "ge", "gh",
                "gm", "gn", "gq", "gr", "gt", "gw", "gy", "hk", "hn", "hr", "ht", "hu", "id", "ie", "il",
                "in", "iq", "ir", "is", "it", "jm", "jo", "jp", "ke", "kg", "kh", "km", "kn", "kp", "kr",
                "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma",
                "mc", "md", "me", "mg", "mk", "ml", "mm", "mn", "mo", "mr", "ms", "mt", "mu", "mv", "mw",
                "mx", "my", "mz", "na", "ne", "ng", "ni", "nl", "no", "np", "nz", "om", "pa", "pe", "pg",
                "ph", "pk", "pl", "pr", "pt", "pw", "py", "qa", "ro", "rs", "ru", "rw", "sa", "sb", "sc",
                "sd", "se", "sg", "si", "sk", "sl", "sm", "sn", "so", "sr", "st", "sv", "sy", "sz", "tc",
                "td", "tg", "th", "tj", "tl", "tm", "tn", "to", "tr", "tt", "tw", "tz", "ua", "ug", "us",
                "uy", "uz", "vc", "ve", "vg", "vn", "ws", "ww", "ye", "za", "zw"};
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(countries));
        return result;
    }

    public ArrayList<String> getCountes() {
        return countes;
    }

    public void setCountes(ArrayList<String> countes) {
        this.countes = countes;
    }
}
