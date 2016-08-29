package it.localhost.app.mobile.jsonplaceholderclient.ui.adapter;

import android.view.View;

/**
 * Callback per passare l'evento OnItemClick dall'Adapter al Fragment
 */
public interface OnItemClickListener {
    void onItemClick(View itemView, int position);
}
