package com.example.testdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.HoaDon;
import com.example.testdb.model.HopDong;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterHopDong extends RecyclerView.Adapter<RecycleViewAdapterHopDong.HomeViewHolder>{
    private List<HopDong> list;
    private ItemListener itemListener;
    public RecycleViewAdapterHopDong() {
        list=new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<HopDong> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public HopDong getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hopdong,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HopDong item=list.get(position);
        holder.maHopDong.setText("Code: "+item.getMaHopDong());
        Controller db=new Controller();
        String tenKhachHang=db.searchTenNhanVienById(item.getIdKhachHang());
        holder.tenKH.setText("Khách hàng: "+tenKhachHang);
        holder.ngayBatDauThue.setText("Ngày bắt đầu thuê: "+item.getNgayBatDauThue());
        holder.mota.setText("Mô tả: "+item.getMoTa());
        holder.ngayky.setText("Ngày ký hợp đồng: "+item.getNgayKy());
        holder.thoihan.setText("Thời hạn thuê: "+item.getThoihan()+" tháng");
        holder.tiencoc.setText("Tiền cọc: "+item.getTienCoc()+" triệu đồng");
        holder.maphong.setText("Mã phòng: "+item.getMaPhong());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView maHopDong,tenKH,ngayBatDauThue,mota,ngayky,thoihan,tiencoc,maphong;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            maHopDong=view.findViewById(R.id.tvMaHopDong);
            tenKH=view.findViewById(R.id.tvTenKH);
            ngayBatDauThue=view.findViewById(R.id.tvNgayBatDauThue);
            mota=view.findViewById(R.id.tvMoTa);
            ngayky=view.findViewById(R.id.tvNgayKy);
            thoihan=view.findViewById(R.id.tvThoiHan);
            tiencoc=view.findViewById(R.id.tvTienCoc);
            maphong=view.findViewById(R.id.tvMaPhong);
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
