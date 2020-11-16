package dk.ducksoft.currencycal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dk.ducksoft.currencycal.Models.CurrencyRate;

public class RecyclerViewAdapterClass extends RecyclerView.Adapter<RecyclerViewAdapterClass.RecyclerViewAdapterClassHolder> {
    private ArrayList<CurrencyRate> mCurrencyRate;
    public static class RecyclerViewAdapterClassHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public RecyclerViewAdapterClassHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.editTextNumber);

        }
    }

    public RecyclerViewAdapterClass(ArrayList<CurrencyRate> list) {
        mCurrencyRate = list;
    }
    @Override
    public RecyclerViewAdapterClass.RecyclerViewAdapterClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.currencylayout,parent,false);
        RecyclerViewAdapterClassHolder evh = new RecyclerViewAdapterClassHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterClass.RecyclerViewAdapterClassHolder holder, int position) {
        CurrencyRate currencyItem = mCurrencyRate.get(position);
        holder.textView.setText(currencyItem.getCurrencyRateName());

        holder.imageView.setImageResource(currencyItem.getCurrencyFlag());
    }

    @Override
    public int getItemCount() {
        return mCurrencyRate.size();
    }
}
