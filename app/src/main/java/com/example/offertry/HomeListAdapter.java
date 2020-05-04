package com.example.offertry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {

    Context mContext;
    ArrayList<HashMap<String, String>> mArray;

    public HomeListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray){
        this.mContext = cxt;
        this.mArray = mArray;
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBanner;
        TextView  txtDescription,txtDiscount,txtInstant,txtShop,txtCode,txtDay;
        public ViewHolder(View v){
            super(v);
            imgBanner = (ImageView) v.findViewById(R.id.image);
            // txtTitle = (TextView) v.findViewById(R.id.title);
            txtDescription = (TextView) v.findViewById(R.id.descroption);


            txtDiscount = (TextView) v.findViewById(R.id.discount);
            txtInstant = (TextView) v.findViewById(R.id.instance);
            txtShop= (TextView) v.findViewById(R.id.shop);
            txtCode = (TextView) v.findViewById(R.id.code);
            txtDay = (TextView) v.findViewById(R.id.day);



        }
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String,String> map = mArray.get(position);
        //Glid.with(mContext).load(map.get("url")).into(holder.imgBanner);
        Glide.with(mContext).load(map.get("url")).into(holder.imgBanner);
        //holder.txtTitle.setText(map.get("title"));
        holder.txtDescription.setText(map.get("detail"));
        MainActivity.description1=map.get("detail");

        holder.txtDiscount.setText(map.get("dis"));
        MainActivity.discount1=map.get("dis");

        holder.txtInstant.setText(map.get("int"));
        MainActivity.instant1=map.get("int");

        holder.txtShop.setText(map.get("sh"));
        MainActivity.shop1=map.get("sh");

        holder.txtCode.setText(map.get("co"));
        MainActivity.code1=map.get("co");

        holder.txtDay.setText(map.get("da"));
        MainActivity.day1=map.get("da");




    }

    @Override
    public int getItemCount()
    {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_content, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }


}
