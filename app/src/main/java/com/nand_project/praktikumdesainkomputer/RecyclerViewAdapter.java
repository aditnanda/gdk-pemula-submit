package com.nand_project.praktikumdesainkomputer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Model> rvData;
    private Context context;

    public RecyclerViewAdapter(Context context,ArrayList<Model> data){
        this.context = context;
        this.rvData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nama, tv_jadwal;
        ImageView iv_foto;
        Button btn_detail;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_jadwal = itemView.findViewById(R.id.tv_jadwal);
            iv_foto = itemView.findViewById(R.id.iv_foto);
            btn_detail = itemView.findViewById(R.id.btn_detail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.tv_nama.setText(rvData.get(i).getJudul());
        viewHolder.tv_jadwal.setText(rvData.get(i).getJadwal());
        Glide.with(context).load(rvData.get(i).getFoto()).into(viewHolder.iv_foto);
        viewHolder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("judul",rvData.get(i).getJudul()+"");
                intent.putExtra("deskripsi",rvData.get(i).getKeterangan()+"");
                intent.putExtra("jadwal",rvData.get(i).getJadwal()+"");
                intent.putExtra("foto",rvData.get(i).getFoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}