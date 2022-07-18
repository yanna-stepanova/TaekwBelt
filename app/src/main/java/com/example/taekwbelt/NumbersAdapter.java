package com.example.taekwbelt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taekwbelt.models.UBTerminologyItem;

import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {
    private int viewHolderCount;

    private LayoutInflater inflater;
    private ArrayList<UBTerminologyItem> arrayList;

    public NumbersAdapter(Context context, ArrayList<UBTerminologyItem> arrayList) {
        this.inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.doing_recycler_view; //нашли id  этого xml-файла
        //создаем новое представление
        //все созданные объекты б.помещаться в наш RecyclerView
        // parent - это наш RecyclerView
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        //делаем обёртку, кот. позволит переисп-ть эл-т списка

        return new NumberViewHolder(view);//передаем созданный view из xml
    }

    //этот метод будет вызываться при прокрутке списка, когда во viewHolder надо б.обновить данные
    //т.е. уже созданные ранее viewHolder'ы в методе onCreateViewHolder б.исп-ся заново
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        UBTerminologyItem ubTerminologyItem = arrayList.get(position);
        holder.itemEnglishView.setText(ubTerminologyItem.getEnglish());
        holder.itemKoreanView.setText(ubTerminologyItem.getKorean());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView itemEnglishView;
        TextView itemKoreanView;
        // NumberViewHolder - это обёртка для элемента списка, чтобы его можно было заново исп-ть
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            itemEnglishView = itemView.findViewById(R.id.tv_english);
            itemKoreanView = itemView.findViewById(R.id.tv_korean);
        }
    }

}
