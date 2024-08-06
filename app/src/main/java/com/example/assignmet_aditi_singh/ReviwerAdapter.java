package com.example.assignmet_aditi_singh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviwerAdapter extends RecyclerView.Adapter<ReviwerAdapter.ReviewViewHolder> {

    private List<Review> reviews;
    private Context context;

    public ReviwerAdapter(Context context, List<Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);

        holder.reviewerNameTextView.setText(review.getReviewerName());
        holder.reviewerEmailTextView.setText(review.getReviewerEmail());
        holder.reviewDateTextView.setText(review.getDate());
        holder.reviewCommentTextView.setText(review.getComment());
        holder.reviewRatingBar.setRating(review.getRating());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView reviewerNameTextView;
        TextView reviewerEmailTextView;
        TextView reviewDateTextView;
        TextView reviewCommentTextView;
        RatingBar reviewRatingBar;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            reviewerNameTextView = itemView.findViewById(R.id.reviewerNameTextView);
            reviewerEmailTextView = itemView.findViewById(R.id.reviewerEmailTextView);
            reviewDateTextView = itemView.findViewById(R.id.reviewDateTextView);
            reviewCommentTextView = itemView.findViewById(R.id.reviewCommentTextView);
            reviewRatingBar = itemView.findViewById(R.id.reviewRatingBar);
        }
    }
}
