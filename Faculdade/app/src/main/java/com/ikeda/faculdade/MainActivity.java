package com.ikeda.faculdade;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

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

//        String[] disciplinas = {"Redes", "Algoritmos", "Programacao"};
//        int layout = android.R.layout.simple_list_item_1;
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this, layout, disciplinas);
//        ListView lista = (ListView) findViewById(R.id.listView);
//        lista.setAdapter(adapter);
//
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//            Toast.makeText(MainActivity.this,
//                    adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
//        String[] myDataset = {"Redes", "Algoritmos", "Programacao"};
        String[][] myDataset = {
                {"Redes", "Sistemas Operacionais"},
                {"Algoritmos", "Programacao"},
                {"Engenharia de Software", "Banco de dados"}};

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mAdapter = new MyAdapter(myDataset, this);
        recyclerView.setAdapter(mAdapter);

        TextView textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String teste = intent.getStringExtra("disciplina");
        if (teste != null) {
            textView.setText(teste);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_disciplinas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_new) {
            Intent intent = new Intent(this, DisciplinaActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_terceiratela) {
            Intent intent = new Intent(this, TerceiraTela.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}