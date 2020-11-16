package dk.ducksoft.currencycal;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import dk.ducksoft.currencycal.Models.CurrencyCalculator;

public class MainPresenter implements MainContract.Presenter,OnJsonRespon {

    private MainContract.MvpView mvpView;
    public List<String> getData() {
        return data;
    }
    WebApiCaller apiCaller = new WebApiCaller();
    CurrencyCalculator calculator;

    public void setData(List<String> data) {
        this.data = data;
    }

    private List<String> data;

    MainPresenter(MainContract.MvpView view) {
        mvpView = view;
        data = new ArrayList();
        apiCaller.addListener(this::OnDataRecived);
    }

    /**
     * this handles the btn press from the view.
     * */
    @Override
    public void handleConvertButtonClick(View view) {

        apiCaller.GetNewCurrencyRate(view.getContext());
        calculator.calculatRate();
    }

    @Override
    public void OnDataRecived(String data) {

        this.data.add(data);
        Log.e("onjsondata","resived deata");
    }
}
