package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.R;
import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;

/**
 *
 */
public class PostsAdapter extends  RecyclerView.Adapter<PostsAdapter.ViewHolder>{

    private List<Post> posts;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);

//            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
