package com.nand_project.praktikumdesainkomputer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView iv_foto;
    private TextView tv_judul, tv_deskripsi, tv_jadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(getIntent().getStringExtra("judul"));

        tv_judul = findViewById(R.id.tv_judul);
        tv_deskripsi = findViewById(R.id.tv_deskripsi);
        tv_jadwal = findViewById(R.id.tv_jadwal);
        iv_foto = findViewById(R.id.iv_foto);

        tv_judul.setText(getIntent().getStringExtra("judul"));
        tv_deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        tv_jadwal.setText(getIntent().getStringExtra("jadwal"));
        Glide.with(DetailActivity.this).load(getIntent().getIntExtra("foto",0)).into(iv_foto);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
