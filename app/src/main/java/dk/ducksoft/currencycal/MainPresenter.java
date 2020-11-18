package dk.ducksoft.currencycal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
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
    private ArrayList<String> countes;
    private ArrayList<String> contruies = new ArrayList<>();

    MainPresenter(MainContract.MvpView view) {
//        apiCaller.GetNewCurrencyRate(((Context) view));
        mvpView = view;
        data = new ArrayList<>();
//        data = CreateTestData();
        apiCaller.addListener(this::OnDataRecived);
        countes = new ArrayList<>();
//        countes = CreateSpinnerContent();
    }

    /**
     * this handles the btn press from the view.
     */
    @Override
    public void handleConvertButtonClick(View view) {

        apiCaller.GetNewCurrencyRate(view.getContext());
//        calculator.calculatRate();
    }

    /**
     * This is the oberver side of the patten.
     * the oberable "Notiyfys" evey "Subscripe" part in its list and evey parts then runs this.
     * since the contract binds them this works perfectly..
     */
    @Override
    public void OnDataRecived(Object data) {
        Log.e("", ((ArrayList<CurrencyRate>) data).get(0).getCurrencyRateName());
        this.setData(((ArrayList<CurrencyRate>) data));
        for (CurrencyRate s : this.data) {
            s.setCurrencyFlag(((Context) mvpView).getResources().getIdentifier(s.getCurrencyRateName().toLowerCase(), "drawable", ((Context) mvpView).getPackageName()));
        }
        for (CurrencyRate cur : this.data) {
            countes.add(cur.getCurrencyRateName());

        }

    }

    public ArrayList<CurrencyRate> CreateTestData() {
        CurrencyRate tempNew = new CurrencyRate("dkk", 0.7, R.drawable.dkk);
        CurrencyRate tempNew2 = new CurrencyRate("usd", 0.7, R.drawable.usd);
        CurrencyRate tempNew3 = new CurrencyRate("eur", 0.7, R.drawable.eur);
        CurrencyRate tempNew4 = new CurrencyRate("aud", 0.7, R.drawable.aud);
        CurrencyRate tempNew5 = new CurrencyRate("sek", 0.7, R.drawable.sek);
        CurrencyRate tempNew6 = new CurrencyRate("gbp", 0.7, R.drawable.gbp);
        ArrayList<CurrencyRate> tempList = new ArrayList<CurrencyRate>();
        tempList.add(tempNew);
        tempList.add(tempNew2);
        tempList.add(tempNew3);
        tempList.add(tempNew4);
        tempList.add(tempNew5);
        tempList.add(tempNew6);
        return tempList;

    }

//    public ArrayList<String> CreateSpinnerContent() {
//        String[] countries = new String[]{
//                "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "ar", "at", "au", "ax", "az", "ba", "bb",
//                "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bw", "by",
//                "bz", "ca", "caf", "cas", "cd", "ceu", "cf", "cg", "ch", "ch", "ci", "cl", "cm", "cn",
//                "cna", "co", "coc", "cr", "csa", "cu", "cv", "cy", "cz", "de", "dj", "dk", "dm", "dz", "ec",
//                "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fm", "fr", "ga", "gb", "gd", "ge", "gh",
//                "gm", "gn", "gq", "gr", "gt", "gw", "gy", "hk", "hn", "hr", "ht", "hu", "id", "ie", "il",
//                "in", "iq", "ir", "is", "it", "jm", "jo", "jp", "ke", "kg", "kh", "km", "kn", "kp", "kr",
//                "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma",
//                "mc", "md", "me", "mg", "mk", "ml", "mm", "mn", "mo", "mr", "ms", "mt", "mu", "mv", "mw",
//                "mx", "my", "mz", "na", "ne", "ng", "ni", "nl", "no", "np", "nz", "om", "pa", "pe", "pg",
//                "ph", "pk", "pl", "pr", "pt", "pw", "py", "qa", "ro", "rs", "ru", "rw", "sa", "sb", "sc",
//                "sd", "se", "sg", "si", "sk", "sl", "sm", "sn", "so", "sr", "st", "sv", "sy", "sz", "tc",
//                "td", "tg", "th", "tj", "tl", "tm", "tn", "to", "tr", "tt", "tw", "tz", "ua", "ug", "us",
//                "uy", "uz", "vc", "ve", "vg", "vn", "ws", "ww", "ye", "za", "zw"};
//        ArrayList<String> result = new ArrayList<String>(Arrays.asList(countries));
//        return result;
//    }

    public ArrayList<String> getCountes() {
        return countes;
    }

    public void setCountes(ArrayList<String> countes) {
        this.countes = countes;
    }
}
