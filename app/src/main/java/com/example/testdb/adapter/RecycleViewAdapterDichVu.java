package com.example.testdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.NhanVienCongTy;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterDichVu extends RecyclerView.Adapter<RecycleViewAdapterDichVu.HomeViewHolder>{
    private List<DichVu> list;
    private ItemListener itemListener;
    public RecycleViewAdapterDichVu() {
        list=new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<DichVu> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public DichVu getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dichvu,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        DichVu item=list.get(position);
        holder.maDV.setText(item.getMaDV().toString());
        holder.tenDV.setText(item.getTenDV());
        holder.giaDV.setText(item.getGia());
        holder.loaiDV.setText(item.getLoaiDV());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView maDV,tenDV,giaDV,loaiDV;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            maDV=view.findViewById(R.id.tvMaDV);
            tenDV=view.findViewById(R.id.tvTenDV);
            giaDV=view.findViewById(R.id.tvGiaDV);
            loaiDV=view.findViewById(R.id.tvLoaiDV);
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
