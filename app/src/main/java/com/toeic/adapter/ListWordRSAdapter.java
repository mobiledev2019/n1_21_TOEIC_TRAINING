package com.toeic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.toeic.R;
import com.toeic.common.Common;
import com.toeic.model.WordAnswer;

import java.util.ArrayList;
import java.util.List;

public class ListWordRSAdapter extends RecyclerView.Adapter<ListWordRSAdapter.RecyclerViewHolder>{

    private List<WordAnswer> data = new ArrayList<>();

    Animation animation;
    ViewGroup view;
    Common cm;
    public String urlDelete = cm.getUrlDelete();
    public String urlSave = cm.getUrlPostSaved();

    public ListWordRSAdapter(List<WordAnswer> data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = parent;

        View view = inflater.inflate(R.layout.item_message, parent, false);

         animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.scale_list);
//        view.startAnimation(animation);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        String result = data.get(position).getResult();
        int is_true = data.get(position).getIs_true();

        holder.txt_rs.setText(result);
        holder.txt_user_2.setText(""+ position);

    }

    @Override
    public int getItemCount() {
        if (data == null){
            return 0;
        }
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txt_user_2, txt_rs;
        ImageView imgPost, imgHeart;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txt_user_2 = (TextView) itemView.findViewById(R.id.txt_user_2);
            txt_rs = (TextView) itemView.findViewById(R.id.message_content);


        }
    }

}