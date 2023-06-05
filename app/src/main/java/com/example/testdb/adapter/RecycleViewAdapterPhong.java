package com.example.testdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testdb.R;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.Phong;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterPhong extends RecyclerView.Adapter<RecycleViewAdapterPhong.HomeViewHolder>{
    private List<Phong> list;
    Context context;
    private ItemListener itemListener;
    public RecycleViewAdapterPhong(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<Phong> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public Phong getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phong,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Phong item=list.get(position);
        Glide.with(context).load(item.getUrl_img()).into(holder.img);
//        holder.img.setImageResource(R.drawable.icon_phong);
        holder.maPhong.setText("Mã phòng: "+item.getMaPhong());
        holder.dientich.setText("Diện tích phòng: "+String.valueOf(item.getDientich())+" m2");
        holder.tinhtrang.setText("Tình trạng: "+item.getTinhTrangPhong());
        holder.loaiPhong.setText("Loại phòng: "+item.getLoaiPhong());
        holder.giaphong.setText("Giá phòng: "+String.valueOf(item.getGiaPhong())+ " triệu đồng/tháng");
        holder.mota.setText("Mô tả: "+item.getMota());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView maPhong,loaiPhong,dientich,tinhtrang,giaphong,mota;
        private ImageView img;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            maPhong=view.findViewById(R.id.tvMaPhong);
            loaiPhong=view.findViewById(R.id.tvLoaiPhong);
            dientich=view.findViewById(R.id.tvDienTich);
            tinhtrang=view.findViewById(R.id.tvTinhTrang);
            giaphong=view.findViewById(R.id.tvGiaPhong);
            mota=view.findViewById(R.id.tvMoTa);
            img=view.findViewById(R.id.imgPhong);
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
