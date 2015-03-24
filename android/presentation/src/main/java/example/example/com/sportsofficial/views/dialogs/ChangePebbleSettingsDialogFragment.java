package example.example.com.sportsofficial.views.dialogs;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.example.com.sportsofficial.R;

public class ChangePebbleSettingsDialogFragment extends DialogFragment {
    public interface ChangePebbleSettingsDialogListener {
        public void onChangePebbleSettingsPositiveClicked(int singleClick, int doubleClick, int longClick);
    }

    private ChangePebbleSettingsDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.set_pebble_settings_dialog, null);

        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.change_pebble_settings_title)
                .setPositiveButton(R.string.save, null)
                .setNegativeButton(R.string.cancel, null)
                .create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                Button positiveButton = ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE);

                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Get input fields
                        EditText singleClickField = (EditText) view.findViewById(R.id.single_click);
                        EditText doubleClickField = (EditText) view.findViewById(R.id.double_click);
                        EditText longClickField = (EditText) view.findViewById(R.id.long_click);

                        // Get inputted values
                        String singleClick = singleClickField.getText().toString();
                        String doubleClick = doubleClickField.getText().toString();
                        String longClick = longClickField.getText().toString();

                        // Ensure inputted values
                        if (TextUtils.isEmpty(singleClick)) {
                            singleClickField.setError("Invalid single click value");
                            return;
                        }

                        if (TextUtils.isEmpty(doubleClick)) {
                            doubleClickField.setError("Invalid double click value");
                            return;
                        }

                        if (TextUtils.isEmpty(longClick)) {
                            longClickField.setError("Invalid long click value");
                            return;
                        }


                        mListener.onChangePebbleSettingsPositiveClicked(Integer.valueOf(singleClick),
                                Integer.valueOf(doubleClick), Integer.valueOf(longClick));

                        Log.i("TAG", Integer.toString(Integer.valueOf(singleClick)));
                        Log.i("TAG", Integer.toString(Integer.valueOf(doubleClick)));
                        Log.i("Tag", Integer.toString(Integer.valueOf(longClick)));
                        dialog.dismiss();
                    }
                });
            }
        });

        return dialog;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (ChangePebbleSettingsDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement CreateMatchDialogListener");
        }
    }
}
