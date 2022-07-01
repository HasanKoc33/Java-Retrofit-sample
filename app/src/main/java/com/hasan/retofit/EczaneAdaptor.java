package com.hasan.retofit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EczaneAdaptor  extends RecyclerView.Adapter {

    private Context mContext;
    private List<Eczane> eczaneler;
    private Activity mActivity;

    public EczaneAdaptor(Context mContext, List<Eczane> eczaneler, Activity mActivity) {
        this.eczaneler = eczaneler;
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;

        View view = LayoutInflater.from(mContext).inflate(R.layout.eczane_item, parent, false);
        vh = new UViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Eczane eczane = eczaneler.get(position);
        ((UViewHolder) holder).adres.setText(eczane.getAddress());
        ((UViewHolder) holder).name.setText(eczane.getName());
        ((UViewHolder) holder).tel.setText(eczane.getPhone());

    }

    @Override
    public int getItemCount() {
        return eczaneler.size();
    }


    public class UViewHolder extends RecyclerView.ViewHolder {

        public TextView name,adres,tel;


        public UViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            adres = itemView.findViewById(R.id.adres);
            tel =  itemView.findViewById(R.id.tel);

        }

    }


}
