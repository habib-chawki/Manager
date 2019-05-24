package com.android.stockmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsDialog extends DialogFragment {

    private Bundle bundle;
    private TextView productNameTextView;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        bundle = getArguments();
        String productName = bundle.getString("productName");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_details, null);

        productNameTextView = rootView.findViewById(R.id.text_dialog_product_name);
        productNameTextView.setText(productName);

        builder.setView(rootView)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "positive button clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
