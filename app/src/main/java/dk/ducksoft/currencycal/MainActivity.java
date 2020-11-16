package dk.ducksoft.currencycal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;;
import android.os.Bundle;

import dk.ducksoft.currencycal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainContract.MvpView{

    private MainPresenter mainPresenter;
    private ActivityMainBinding  binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setPreset(mainPresenter);
    }
}