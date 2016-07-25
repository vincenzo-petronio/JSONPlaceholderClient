package it.localhost.app.mobile.jsonplaceholderclient.util;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import it.localhost.app.mobile.jsonplaceholderclient.R;

/**
 *
 */
public final class NotificationFactory {

    public static Dialog createSimpleOkErrorDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(R.string.common_ok, null);
        return alertDialog.create();
    }

    public static Dialog createSimpleOkErrorDialog(Context context,
                                                   @StringRes int titleResource,
                                                   @StringRes int messageResource) {
        return createSimpleOkErrorDialog(context,
                context.getString(titleResource),
                context.getString(messageResource));
    }

    public static Dialog createGenericErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.common_error))
                .setMessage(message)
                .setNeutralButton(R.string.common_ok, null);
        return alertDialog.create();
    }

    public static Dialog createGenericErrorDialog(Context context, @StringRes int messageResource) {
        return createGenericErrorDialog(context, context.getString(messageResource));
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog createProgressDialog(Context context,
                                                      @StringRes int messageResource) {
        return createProgressDialog(context, context.getString(messageResource));
    }

    public static Toast createToastLongNotification(Context context, String message) {
        return Toast.makeText(context, message, Toast.LENGTH_LONG);
    }

    public static Toast createToastLongNotification(Context context, @StringRes int messageResource) {
        return createToastLongNotification(context, context.getString(messageResource));
    }

    public static Toast createToastShortNotification(Context context, String message) {
        return Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }

    public static Toast createToastShortNotification(Context context, @StringRes int messageResource) {
        return createToastShortNotification(context, context.getString(messageResource));
    }
}
