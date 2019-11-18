package com.mymur.menutraining;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList <String> stringsArray;

    public MyAdapter(ArrayList <String> stringsArray) {
        this.stringsArray = stringsArray;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemText.setText(stringsArray.get(position));
    }

    @Override
    public int getItemCount() {
        return stringsArray.size();
    }


    //Сюда поставим наследование интерфейса OnCreateContextMenyListener
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
            public TextView itemText;

        //сюда вставляем наш контейнер от recyclerView
        LinearLayout myRecyclerViewLayout;


        public MyViewHolder (final View itemView) {
            super(itemView);

            itemText = itemView.findViewById(R.id.itemText);
            //инициализируем контейнер recyclerView
            myRecyclerViewLayout = itemView.findViewById(R.id.mRecyclerViewLayout);
            //делаем слушатель контекстного меню
            myRecyclerViewLayout.setOnCreateContextMenuListener(this);

        }


        //здесь делаем меню
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), 111, 100, "Delete this Item");
            menu.add(this.getAdapterPosition(), 222, 200, "Add to yourAlphabet");

        }
    }

    //метод удаления iten
    public void removeItem(int position) {
            stringsArray.remove(position);
            notifyDataSetChanged();
    }



}