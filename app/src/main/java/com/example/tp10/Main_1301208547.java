package com.example.tp10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Main_1301208547 extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private FloatingActionButton fab;
    private TextView to, subject, content;
    private EditText et_to, et_subject, et_content;
    String to1, subject1, content1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_1301208547);

        constraintLayout = findViewById(R.id.constraintLayout);
        to = findViewById(R.id.to);
        subject = findViewById(R.id.subject);
        content = findViewById(R.id.content);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(constraintLayout, "Compose New Email?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("New", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                to.setText(null);
                                subject.setText(null);
                                content.setText(null);
                                DialogForm();
                            }
                        });
                snackbar.show();
            }
        });
    }

    // untuk mengosongi edittext
    private void kosong(){
        et_to.setText(null);
        et_subject.setText(null);
        et_content.setText(null);
    }

    private void DialogForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main_1301208547.this);
        View view = LayoutInflater.from(this).inflate(R.layout.email, null);

        builder.setView(view)
                .setCancelable(true)
                .setTitle("Compose Email")
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                to1 = et_to.getText().toString();
                subject1 = et_subject.getText().toString();
                content1 = et_content.getText().toString();

                to.setText(to1);
                subject.setText(subject1);
                content.setText(content1);
                dialog.dismiss();
            }
        }).setNegativeButton("Discard", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        et_to = view.findViewById(R.id.to);
        et_subject = view.findViewById(R.id.subject);
        et_content = view.findViewById(R.id.content);

        kosong();

        builder.show();
    }

}