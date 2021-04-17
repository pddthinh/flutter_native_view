package com.pddthinh.flutter.flutter_native_view.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.pddthinh.flutter.flutter_native_view.R;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class NativeView implements PlatformView {
    private static final String TAG = NativeView.class.getSimpleName();

    private final LinearLayout mViewContainer;
    private final BinaryMessenger mMessenger;

    @SuppressLint("InflateParams")
    NativeView(
            Context context,
            int id,
            BinaryMessenger messenger
    ) {
        this.mMessenger = messenger;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewContainer = (LinearLayout) inflater.inflate(R.layout.sample_native_view, null);
        mViewContainer.setId(id);

        mViewContainer.findViewById(R.id.sample_view_submit)
                .setOnClickListener((v) -> {
                    // TODO: make the input work :)
//                    EditText text = mViewContainer.findViewById(R.id.sample_view_name);
//                    String txtName = text.getText().toString();
//                    if (txtName.length() == 0) {
//                        Log.e(TAG, "Text value is empty!");
//                        return;
//                    }

                    AlertDialog dialog = new AlertDialog.Builder(context)
                            .setTitle(R.string.txt_dialog_title)
                            .setMessage(R.string.txt_dialog_message)
                            .setNegativeButton(android.R.string.cancel,
                                    (dialog1, which) -> {
                                        Log.e(TAG, "Clicked on Cancel button");
                                        dialog1.dismiss();
                                    })
                            .create();
                    dialog.show();
                });
    }


    @Override
    public View getView() {
        return mViewContainer;
    }

    @Override
    public void dispose() {

    }
}
