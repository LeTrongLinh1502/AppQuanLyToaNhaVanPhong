package com.example.testdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.model.CongTy;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterCongTy extends RecyclerView.Adapter<RecycleViewAdapterCongTy.HomeViewHolder>{
    private List<CongTy> list;
    private ItemListener itemListener;
    public RecycleViewAdapterCongTy() {
        list=new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<CongTy> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public CongTy getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_congty,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        CongTy item=list.get(position);
        holder.tenCT.setText(item.getTenCTy());
        holder.diachi.setText(item.getDiachi());
        holder.email.setText(item.getEmail());
        holder.sđt.setText(item.getSđt());
        holder.soNV.setText(String.valueOf(item.getSoNV()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tenCT,diachi,email,sđt,soNV;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            tenCT=view.findViewById(R.id.tvTen);
            diachi=view.findViewById(R.id.tvDiaChi);
            email=view.findViewById(R.id.tvEmail);
            sđt=view.findViewById(R.id.tvSoDT);
            soNV=view.findViewById(R.id.tvSoNV);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface ItemListener{
        void onItemClick (View view,int position);
    }
}
