package com.playground.android101;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.playground.android101.model.DummyData;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created on 23/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.GenericViewHolder> {

    private List<DummyData> data;

    public ListAdapter(List<DummyData> data) {
        this.data = data;
    }

    public void updateData(List<DummyData> data) {
        this.data = data;
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new GenericViewHolder(parentView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(this.data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class GenericViewHolder extends RecyclerView.ViewHolder {

        public GenericViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private ImageView getImageView() {
            return super.itemView.findViewById(R.id.image);
        }

        private TextView getTitleView() {
            return super.itemView.findViewById(R.id.title);
        }

        private TextView getDescriptionView() {
            return super.itemView.findViewById(R.id.description);
        }

        public void bind(DummyData data) {
            //load asynchronously the image from the internet without blocking the main thread
            Picasso.get()
                    .load(data.getImageUrl())
                    .fit()
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE) //needed because we have randomly generated images from the same URL
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) //needed because we have randomly generated images from the same URL
                    .error(R.drawable.image_error)
                    .placeholder(R.drawable.image_placeholder)
                    .into(getImageView());
            getTitleView().setText(data.getTitle());
            getDescriptionView().setText(data.getDescription());
        }
    }
}
