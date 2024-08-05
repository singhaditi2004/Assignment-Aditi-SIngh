package com.example.assignmet_aditi_singh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {
    private final List<String> tags;

    public TagAdapter(List<String> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_item, parent, false);
        return new TagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder holder, int position) {
        holder.bind(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    static class TagViewHolder extends RecyclerView.ViewHolder {
        private final TextView tagTextView;

        public TagViewHolder(@NonNull View itemView) {
            super(itemView);
            tagTextView = itemView.findViewById(R.id.tagTextView);
        }

        public void bind(String tag) {
            tagTextView.setText(tag);
        }
    }
}
