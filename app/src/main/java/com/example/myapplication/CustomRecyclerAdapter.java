package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder> {

    private List<ItemList> itemList;

    public CustomRecyclerAdapter(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);

        return customViewHolder;
    } // 처음으로 생성될떄 생명주기

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.CustomViewHolder holder, int position) {

        holder.tv_idx.setText(String.valueOf(itemList.get(position).getTv_idx()));
        holder.iv_icon.setImageResource(itemList.get(position).getIv_icon());
        holder.tv_id.setText(itemList.get(position).getTv_id());
        holder.tv_pwd.setText(itemList.get(position).getTv_pwd());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curIdx = holder.tv_idx.getText().toString();
                Toast.makeText(v.getContext(), curIdx, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }// 실제로 추가될 때

    @Override
    public int getItemCount() {
        return (itemList != null ? itemList.size():0);
    }

    public void  remove(int position){
        try{
            itemList.remove(position);
            notifyItemRemoved(position); // 새로고침
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_idx;
        protected ImageView iv_icon;
        protected TextView tv_id;
        protected TextView tv_pwd;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_idx = (TextView) itemView.findViewById(R.id.tv_idx);
            this.iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            this.tv_id = (TextView) itemView.findViewById(R.id.tv_id);
            this.tv_pwd = (TextView) itemView.findViewById(R.id.tv_pwd);
        }
    }
}
