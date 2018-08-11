package com.framgia.moviedb_20.screen.main.navigation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.framgia.moviedb_20.R;

import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.GenreViewHolder> {
    private List<String> genres;

    public NavigationAdapter(List<String> genres) {
        this.genres = genres;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_nav, viewGroup, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int i) {
        holder.setView(genres.get(i));
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    static class GenreViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_genre);

        }

        private void setView(String genre) {
            mTextView.setText(genre);
        }
    }
}
