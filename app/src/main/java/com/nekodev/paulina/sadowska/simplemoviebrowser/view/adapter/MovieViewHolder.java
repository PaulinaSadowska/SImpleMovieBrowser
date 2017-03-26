package com.nekodev.paulina.sadowska.simplemoviebrowser.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nekodev.paulina.sadowska.simplemoviebrowser.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Paulina Sadowska on 25.03.2017.
 */

class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.movie_item_title)
    TextView title;

    @BindView(R.id.movie_item_image)
    ImageView image;

    MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
