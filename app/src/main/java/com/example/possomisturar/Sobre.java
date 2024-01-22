package com.example.possomisturar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Sobre extends AppCompatActivity {

    Button acessar;
    ImageView whatssap, github, email;
    String personalEmail = "riannm19@gmail.com";

    public static void copyTextToClipboard(Context context, String textToCopy) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Texto Personalizado", textToCopy);
        clipboardManager.setPrimaryClip(clipData);
    }

    public static void mostrarToast(Context context, String mensagem) {
        Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        acessar = findViewById(R.id.btn_acessar);
        whatssap = findViewById(R.id.whatssapLinkBtn);
        github = findViewById(R.id.githubLinkBtn);
        email = findViewById(R.id.emailLinkBtn);

        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://posso-misturar.vercel.app/");

            }
        });
        whatssap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://wa.me/qr/QM7JQSRPIFCXP1");

            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://github.com/Riannm");

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String textoParaCopiar = personalEmail;
                    copyTextToClipboard(Sobre.this, textoParaCopiar);
                    mostrarToast(Sobre.this, "Email copiado para a área de tranferência");
                } catch (Exception e) {
                    mostrarToast(Sobre.this, "Texto não copiado");
                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}