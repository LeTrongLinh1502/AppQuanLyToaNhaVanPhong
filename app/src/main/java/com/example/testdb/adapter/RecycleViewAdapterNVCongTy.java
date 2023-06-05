package com.example.testdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.NhanVienCongTy;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterNVCongTy extends RecyclerView.Adapter<RecycleViewAdapterNVCongTy.HomeViewHolder>{
    private List<NhanVienCongTy> list;
    private ItemListener itemListener;
    public RecycleViewAdapterNVCongTy() {
        list=new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<NhanVienCongTy> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public NhanVienCongTy getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhanvien_congty,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        NhanVienCongTy item=list.get(position);
        holder.hoten.setText(item.getHoten());
        holder.diachi.setText(item.getDiachi());
        holder.email.setText(item.getEmail());
        holder.gioitinh.setText(item.getGioitinh());
        holder.cmt.setText(item.getCmt());
        holder.ngaysinh.setText(item.getNgaysinh());
        holder.chucvu.setText(item.getChucvu());
        Controller db=new Controller();
        holder.congty.setText(db.searchTenCongTyById(item.getIdCongTy()));
        holder.solanravao.setText(String.valueOf(item.getSolanravao()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView hoten,diachi,gioitinh,cmt,ngaysinh,email,chucvu,congty,solanravao;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            hoten=view.findViewById(R.id.tvTen);
            diachi=view.findViewById(R.id.tvDiaChi);
            gioitinh=view.findViewById(R.id.tvGioiTinh);
            ngaysinh=view.findViewById(R.id.tvNgaySinh);
            email=view.findViewById(R.id.tvEmail);
            cmt=view.findViewById(R.id.tvCMT);
            chucvu=view.findViewById(R.id.tvChucVu);
            congty=view.findViewById(R.id.tvCongTy);
            solanravao=view.findViewById(R.id.tvSoLanRaVao);
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
