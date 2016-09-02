package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import com.google.gson.Gson;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Comment;
import it.localhost.app.mobile.jsonplaceholderclient.util.Constants;

/**
 *
 */
public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private static final String TAG = CommentsAdapter.class.getSimpleName();
    private List<Comment> comments;
    private static OnItemClickListener sOnItemClickListener;

    /**
     * Costruttore
     *
     * @param comments List<Comment>
     */
    public CommentsAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @param onItemClickListener OnItemClickListener
     */
    public static void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        sOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.fragment_items_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comment comment = comments.get(position);

        //GUARD-CLAUSE
        if (comment == null) {
            Log.e(TAG, "Post NULL!!!");
            return;
        }

        holder.tvTitle.setText(comment.getBody());
        try {
            holder.tvSubTitle.setText(String.format(Locale.getDefault(), "%d", comment.getPostId()));
        } catch (Exception e) {
            Log.e(TAG, "Exception", e);
        }
    }

    @Override
    public int getItemCount() {
        return comments != null ? comments.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvSubTitle)
        TextView tvSubTitle;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            // LISTENER
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Comment comment = comments.get(getLayoutPosition());

                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.BUNDLE_KEY_ITEM, new Gson().toJson(comment));

                    sOnItemClickListener.onItemClick(bundle);
                }
            });
        }
    }
}
