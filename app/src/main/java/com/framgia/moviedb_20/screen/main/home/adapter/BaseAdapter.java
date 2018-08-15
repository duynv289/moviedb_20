package com.framgia.moviedb_20.screen.main.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.framgia.moviedb_20.R;
import com.framgia.moviedb_20.data.model.BaseMovie;
import com.framgia.moviedb_20.screen.detail.movie.MovieDetailFragment;
import com.framgia.moviedb_20.utils.Constants;
import com.framgia.moviedb_20.utils.ViewUtils;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.HomeContentHolder> {

    private List<BaseMovie> mBaseMovies;
    private OnItemClickListener mListener;

    public void onItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public BaseAdapter(List<BaseMovie> baseMovies) {
        mBaseMovies = baseMovies;
    }

    @NonNull
    @Override
    public HomeContentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_movie, viewGroup, false);
        return new HomeContentHolder(view,mBaseMovies,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeContentHolder holder, int i) {
        holder.setView(mBaseMovies.get(i));
    }

    @Override
    public int getItemCount() {
        return mBaseMovies != null ? mBaseMovies.size() : 0;
    }

    static class HomeContentHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ImageView mImageView;

        public HomeContentHolder(@NonNull View itemView, final List<BaseMovie> baseMovies, final OnItemClickListener listener) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_film_name);
            mImageView = itemView.findViewById(R.id.image_film_poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        listener.OnItemClick(baseMovies.get(getAdapterPosition()).getId());
                    }
                }
            });
        }
        private void setView(BaseMovie baseMovie) {
            mTextView.setText(baseMovie.getTitle());
            ViewUtils.loadImageByUrl(mImageView, Constants.DOMAIN_POSTER_IMAGE + baseMovie.getPosterPath());
        }
    }
}
