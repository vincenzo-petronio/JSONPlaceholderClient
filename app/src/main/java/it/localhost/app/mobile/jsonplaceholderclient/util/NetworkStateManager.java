package it.localhost.app.mobile.jsonplaceholderclient.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *
 */
public class NetworkStateManager {
    private ConnectivityManager mConnectivityManager;

    /**
     * @param connectivityManager ConnectivityManager
     */
    public NetworkStateManager(ConnectivityManager connectivityManager) {
        this.mConnectivityManager = connectivityManager;
    }

    /**
     * Restituisce true se la connessione è stabilita, false altrimenti.
     *
     * @return boolean
     */
    public boolean isConnected() {
        NetworkInfo activeNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
