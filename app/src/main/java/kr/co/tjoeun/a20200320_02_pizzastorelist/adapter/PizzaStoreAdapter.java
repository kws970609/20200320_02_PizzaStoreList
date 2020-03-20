package kr.co.tjoeun.a20200320_02_pizzastorelist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tjoeun.a20200320_02_pizzastorelist.R;
import kr.co.tjoeun.a20200320_02_pizzastorelist.datas.PizzaStore;

public class PizzaStoreAdapter extends ArrayAdapter<PizzaStore> {

    Context mContext;
    List<PizzaStore> mList;
    LayoutInflater inf;

    public PizzaStoreAdapter(@NonNull Context context, int resource, @NonNull List<PizzaStore> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.pizza_stroe_list_item,null);
        }

        PizzaStore data = mList.get(position);

        ImageView logoImg = row.findViewById(R.id.logoImg);
        TextView nameTxt = row.findViewById(R.id.nameTxt);

        nameTxt.setText(data.getStoreName());

        Glide.with(mContext).load(data.getLogoUrl()).into(logoImg);


        return row;


    }

}
