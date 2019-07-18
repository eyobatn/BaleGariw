package com.azrar.balegariw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {


    android.content.Context context;
    ArrayList<message> messages;

    public MessageAdapter(Context c, ArrayList<message> p){


        context = c;
        messages = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myView = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.messages_card_view, parent, false));
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(messages.get(position).getTitle());
        holder.time.setText(messages.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.messsage_title_view);
            time = itemView.findViewById(R.id.message_time_view);
        }

    }
}
