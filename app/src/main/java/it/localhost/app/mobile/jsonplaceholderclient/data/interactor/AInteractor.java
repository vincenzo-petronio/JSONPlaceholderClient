package it.localhost.app.mobile.jsonplaceholderclient.data.interactor;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Abstract Interactor. Consente di gestire le operazioni con Rx.
 */
public abstract class AInteractor {

    /**
     *
     */
    private Subscription subscription = Subscriptions.empty();

    /**
     * Restituisce un Observable, cioè la sorgente che emette un flusso di dati
     *
     * @return Observable
     */
    protected abstract Observable getObservable();

    /**
     * Effettua la Subscription, cioè l'operazione di connessione tra l'Observable che emette il
     * flusso di dati e l'Observer che consuma tali dati. <br>
     * Il Subscriber è l'Observer, ma con in più la capacità di effettuare l'unsubscribe. <br>
     *
     * @param subscriber Subscriber<T>
     */
    @SuppressWarnings("unchecked")
    public void connect(Subscriber subscriber) {
        subscription = this.getObservable()
                .subscribeOn(Schedulers.io()) // changes the Scheduler where the Observable should operate.
                .observeOn(AndroidSchedulers.mainThread()) // changes the Scheduler where the Observable will send notifications.
                .subscribe(subscriber); // connect Observable with Subscriber/Observer
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
