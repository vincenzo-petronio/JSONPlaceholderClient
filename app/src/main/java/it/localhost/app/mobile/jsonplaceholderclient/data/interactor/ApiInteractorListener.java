package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;

import java.util.List;

/**
 * @deprecated
 */
public interface ApiInteractorListener {

    void onDataSuccess(List<?> items);

    void onDataError(Exception e);
}
