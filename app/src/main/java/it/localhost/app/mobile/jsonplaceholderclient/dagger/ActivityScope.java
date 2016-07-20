package it.localhost.app.mobile.jsonplaceholderclient.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Annotation @Scope per permettere ad oggetti la cui vita è sovrapponibile a quella dell'Activity
 * di essere memorizzati nel corretto @Component
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
