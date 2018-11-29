package com.example.alifatemeh.game;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetNameDialog extends Dialog {
    private Button confirm;
    private EditText playerNmae;
    private OnNameSellectedListener listener;

    public GetNameDialog(Context context, OnNameSellectedListener listener) {
        super(context);
        this.listener=listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_get_name);
        getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);

        confirm =findViewById(R.id.confirm_b);
        playerNmae=findViewById(R.id.player_name);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNameSlected(playerNmae.getText().toString());
                dismiss();
            }
        });
    }
}
