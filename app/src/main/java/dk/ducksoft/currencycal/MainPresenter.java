package dk.ducksoft.currencycal;

import android.view.View;

import java.util.ArrayList;

import java.util.List;

import dk.ducksoft.currencycal.Models.CurrencyRate;
import dk.ducksoft.firstdaolib.WebDataController;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.MvpView mvpView;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    private List<String> data;

    MainPresenter(MainContract.MvpView view) {
        mvpView = view;
        data = new ArrayList();
    }

    @Override
    public void handleConvertButtonClick(View view) {

    }
    public String getCurrencyRate(String currencyTag){
        WebDataController dad = new WebDataController();
        dad.Something();
        return dad.dataJson;

    }
}
