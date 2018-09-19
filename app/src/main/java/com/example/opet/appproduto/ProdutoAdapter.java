package com.example.opet.appproduto;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto>{

    private int rId;

    public ProdutoAdapter(Context context, int resource, List<Produto> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View mView, ViewGroup parent){
        View view = mView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(rId,  null);
        }

        TextView textNome = view.findViewById(R.id.textNomeProduto);
        TextView textValor = view.findViewById(R.id.textValorProduto);
        TextView textQtd = view.findViewById(R.id.textQtdeProduto);
        TextView textCategoria = view.findViewById(R.id.textCategoriaProduto);

        Produto prod = getItem(position);

        textNome.setText(prod.getNome());
        textValor.setText(String.valueOf(prod.getValor()));
        textCategoria.setText(prod.getCategoria());

        if(prod.getQuantidade() < 10) {
            textQtd.setTextColor(Color.RED);
        }
        else{
            textQtd.setTextColor(Color.BLUE);
        }
        textQtd.setText(String.valueOf(prod.getQuantidade()));

        return view;
    }
}
