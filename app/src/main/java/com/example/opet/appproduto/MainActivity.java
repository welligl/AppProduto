package com.example.opet.appproduto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Produto> produtos;
    private EditText editNome;
    private EditText editCategoria;
    private EditText editQtd;
    private EditText editValor;
    private ListView listProduto;
    private ArrayAdapter<Produto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtos = new ArrayList<>();
       editNome = findViewById(R.id.editNome);
        editCategoria = findViewById(R.id.editCategoria);
        editValor = findViewById(R.id.editValor);
        editQtd = findViewById(R.id.editQtd);
       listProduto = findViewById(R.id.listProduto);

        adapter = new ProdutoAdapter (getApplicationContext(),R.layout.produto_item,produtos);
        listProduto.setAdapter(adapter);
    }

    public void salvarProduto(View v){
        String nome = editNome.getText().toString();
        String categoria = editCategoria.getText().toString();
        String qtd = editQtd.getText().toString();
        String valor = editValor.getText().toString();
        Produto a = new Produto();
        a.setNome(nome);
        a.setCategoria(categoria);
        a.setQuantidade(Integer.parseInt(qtd));
        a.setValor(Double.parseDouble(valor));

        produtos.add(a);
        adapter.notifyDataSetChanged();

        editNome.setText("");
        editCategoria.setText("");
        editQtd.setText("");
        editValor.setText("");
    }
}
