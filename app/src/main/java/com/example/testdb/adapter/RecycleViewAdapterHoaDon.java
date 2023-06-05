package com.example.testdb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.DanhSachHopDongActivity;
import com.example.testdb.HomeActivity;
import com.example.testdb.HopDongActivity;
import com.example.testdb.R;
import com.example.testdb.ThanhToanActivity;
import com.example.testdb.ThongBaoKetThucActivity;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterHoaDon extends RecyclerView.Adapter<RecycleViewAdapterHoaDon.HomeViewHolder>{
    private List<HoaDon> list;
    private Context context;
//    private ItemListener itemListener;
    public RecycleViewAdapterHoaDon(Context context) {
        this.context=context;
        list=new ArrayList<>();
    }

//    public void setItemListener(ItemListener itemListener) {
//        this.itemListener = itemListener;
//    }

    public void setList(List<HoaDon> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public HoaDon getItem(int position){
        return list.get(position);

    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HoaDon item=list.get(position);
        holder.maHD.setText("Code: "+item.getMaHoaDon());
        holder.tinhtrang.setText(item.getTinhTrang());
        Controller db=new Controller();
        String tenKhachHang=db.searchTenNhanVienById(item.getIdKhachHang());
        holder.tenKH.setText("Khách hàng: "+tenKhachHang);
        holder.loaiHD.setText("Hóa đơn: "+item.getLoaiHoaDon());
        holder.ngayTaoHD.setText("Ngày tạo: "+item.getNgayXuat());
        holder.hanDong.setText("Hạn nộp: "+item.getHanDong());
        holder.tienthanhtoan.setText(String.valueOf(item.getTongTien())+" VNĐ");
        if(item.getTinhTrang().equals("Chưa thanh toán")){
            holder.phuongthucthanhtoan.setText("Chưa thanh toán");
        }
        else holder.phuongthucthanhtoan.setText("Phương thức thanh toán: "+item.getPhuongThucThanhToan());
        if(item.getTinhTrang().equals("Chưa thanh toán")){
            holder.btnThanhToan.setVisibility(View.VISIBLE);
            holder.img.setImageResource(R.drawable.ic_chua_thanhtoan);
        }
        else {
            holder.btnThanhToan.setVisibility(View.INVISIBLE);
            holder.img.setImageResource(R.drawable.ic_da_thanhtoan);
        }
        holder.btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ThanhToanActivity.class);
                intent.putExtra("HoaDon",item);
                intent.putExtra("TenKhachHang",tenKhachHang);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView maHD,tinhtrang,tenKH,loaiHD,ngayTaoHD,hanDong,tienthanhtoan,phuongthucthanhtoan;
        private AppCompatButton btnThanhToan;
        private ImageView img;
        public HomeViewHolder(@NonNull View view) {
            super(view);
            maHD=view.findViewById(R.id.tvMaHoaDon);
            tinhtrang=view.findViewById(R.id.tvTinhTrang);
            tenKH=view.findViewById(R.id.tvTenKH);
            loaiHD=view.findViewById(R.id.tvLoaiHD);
            ngayTaoHD=view.findViewById(R.id.tvNgayTao);
            hanDong=view.findViewById(R.id.tvHanDong);
            tienthanhtoan=view.findViewById(R.id.tvTienThanhToan);
            btnThanhToan=view.findViewById(R.id.btnthanhtoan);
            phuongthucthanhtoan=view.findViewById(R.id.tvHinhThucThanhToan);
            img=view.findViewById(R.id.imgthanhtoan);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            if(itemListener!=null){
//                itemListener.onItemClick(view,getAdapterPosition());
//            }

        }
    }
//    public interface ItemListener{
//        void onItemClick (View view,int position);
//    }
}
