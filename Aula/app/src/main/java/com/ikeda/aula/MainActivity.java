package com.ikeda.aula;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button buttonSave= null;
    private EditText editText= null;
    private SharedPreferences myPrefs = null;
    TextView textView = null;
    Button button =null;
    boolean chave = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
        });

        buttonSave = this.findViewById(R.id.button);
        editText = this.findViewById(R.id.editText);
        myPrefs= getSharedPreferences("myPrefs", MODE_PRIVATE);
        LoadNameFromPrefs(editText);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                SaveNameOnPrefs(MainActivity.this.editText.getText().toString());
            }
        });

        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button2);
        Resources resources = getResources();

        textView.setText(R.string.texto); button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (chave)
                {
                    SetLocalization(resources, "en");

                    textView.setText(R.string.texto);
                    chave = false;
                }
                else
                {
                    SetLocalization(resources, "pt");
                    textView.setText(R.string.oimundo);
                    chave=true;
                }
            }
        });
    }

    private void LoadNameFromPrefs(EditText editText) {
        String name = myPrefs.getString("nome","");
        if (name != null)
        {
            editText.setText(name);
        }
    }

    private void SaveNameOnPrefs(String name) {
        SharedPreferences.Editor ePrefs = myPrefs.edit();
        ePrefs.putString("nome", name);
        ePrefs.commit();
    }

    public void SetLocalization(Resources resources,String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

}