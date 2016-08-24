package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import java.util.List;

import it.localhost.app.mobile.jsonplaceholderclient.data.model.Post;

/**
 *
 */
public interface ApiInteractorListener {

    void onDataSuccess(List<String> items);

    void onDataError(Exception e);
}
