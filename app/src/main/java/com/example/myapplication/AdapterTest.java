package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterTest  extends RecyclerView.Adapter<AdapterTest.ViewHolder>{

    List<Model> listData;
    Context context;
    AdapterTest(List<Model> _list , Context _context){
        this.listData = _list;
        this.context = _context;
    }

    @NonNull
    @Override
    public AdapterTest.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View listItem = layoutInflater.inflate(R.layout.item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(listItem);
//        return viewHolder;

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTest.ViewHolder holder, int position) {
        Model title = listData.get(position);
        holder.textView.setText(title.getTitle());

        List<String> _list = new ArrayList<>();
        _list.add("sub1");
        _list.add("sub2");
        _list.add("sub3");

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.isExpand()){
                    title.setExpand(false);
                }else{
                    title.setExpand(true);
                }
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

        if(title.isExpand()){
            holder.list_item2.setVisibility(View.VISIBLE);
            holder.arro_imageview.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
        }else{
            holder.list_item2.setVisibility(View.GONE);
            holder.arro_imageview.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
        }

        AdapterSub adapter = new AdapterSub(_list);
        holder.list_item2.setHasFixedSize(true);
        holder.list_item2.setLayoutManager(new LinearLayoutManager(this.context));
        holder.list_item2.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RelativeLayout relativeLayout;
        public RecyclerView list_item2;
        public ImageView arro_imageview;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            this.list_item2 = (RecyclerView) itemView.findViewById(R.id.list_item2);
            this.arro_imageview = (ImageView) itemView.findViewById(R.id.arro_imageview);
        }
    }
}
