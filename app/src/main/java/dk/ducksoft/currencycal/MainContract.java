package dk.ducksoft.currencycal;

import android.view.View;

public interface MainContract {

    interface MvpView {
    }

    interface Presenter {
        void handleConvertButtonClick(View view);
    }

}
