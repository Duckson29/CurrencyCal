package dk.ducksoft.currencycal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;;
import android.os.Bundle;
import android.widget.TextView;

import dk.ducksoft.currencycal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainContract.MvpView{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private MainPresenter mainPresenter;
    private ActivityMainBinding  binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
        * Bulidfeature {databinding = true} xml bindging.
        * */
        mainPresenter = new MainPresenter(this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setPreset(mainPresenter);
        /**
         * Apadater patten(MVP)
         * */

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerViewAdapterClass(mainPresenter.getData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}