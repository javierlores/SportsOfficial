package example.example.com.sportsofficial.views.dialogs;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.example.com.sportsofficial.R;

public class CreateSportDialogFragment extends DialogFragment {
    public interface CreateSportDialogListener {
        public void onCreateSportDialogPositiveClicked(String name);
    }

    private CreateSportDialogListener mListener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.create_sport_dialog, null);

        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Create Sport")
                .setPositiveButton(R.string.create, null)
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
                        EditText nameField = (EditText) view.findViewById(R.id.name);

                        // Get inputted values
                        String name = nameField.getText().toString();

                        // Ensure inputted values
                        if (TextUtils.isEmpty(name)) {
                            nameField.setError("Invalid name");
                            return;
                        }

                        mListener.onCreateSportDialogPositiveClicked(name);
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
            mListener = (CreateSportDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement JoinServerDialogListener");
        }
    }
}
