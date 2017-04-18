package com.ccdp.apppln.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ccdp.apppln.Constants;
import com.ccdp.apppln.R;
import com.ccdp.apppln.model.Data;

import java.util.ArrayList;

/**
 * Created by Asus on 3/6/2017.
 */
public class DataAdapter extends ArrayAdapter<Data> {

    private ArrayList<Data> dataset;
    Context context;

    public DataAdapter(Context context, int resource, ArrayList<Data> objects) {
        super(context, resource, objects);
        this.context = context;
        this.dataset = objects;
    }

    //View Holder
    private static class ViewHolder {
        TextView txtId;
        TextView txtIdPelanggan;
        TextView txtNama;
        TextView txtTanggal;
        TextView txtJumlah;
        TextView txtUserId;
        ImageView photo;
    }

    //getView

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Data data = getItem(position);

        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.row_item, parent, false);
        viewHolder.txtId = (TextView) convertView.findViewById(R.id.id);
        viewHolder.txtIdPelanggan = (TextView) convertView.findViewById(R.id.id_pelanggan);
        viewHolder.txtNama = (TextView) convertView.findViewById(R.id.nama);
        viewHolder.txtTanggal = (TextView) convertView.findViewById(R.id.tanggal);
        viewHolder.txtJumlah = (TextView) convertView.findViewById(R.id.jumlah);
        viewHolder.txtUserId = (TextView) convertView.findViewById(R.id.userid);
        viewHolder.photo = (ImageView) convertView.findViewById(R.id.photo);

        try {
            String dataId = String.valueOf(data.getId());
            viewHolder.txtId.setText(dataId);
            String dataIdPelanggan = String.valueOf(data.getIdPelanggan());
            viewHolder.txtIdPelanggan.setText(dataIdPelanggan);
            viewHolder.txtNama.setText(data.getNama());
            viewHolder.txtTanggal.setText(data.getTanggal());
            viewHolder.txtJumlah.setText(data.getJumlah());
            String userId = String.valueOf(data.getUserid());
            viewHolder.txtUserId.setText(userId);
            String photoUrl = Constants.BASE_ASSETS+data.getId()+".jpg";
            Glide.with(context)
                    .load(photoUrl)
                    .error(R.mipmap.ic_launcher)
                    .override(150, 150)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(viewHolder.photo);
        }catch (Exception e){
            e.printStackTrace();
        }

        return convertView;

    }
}
