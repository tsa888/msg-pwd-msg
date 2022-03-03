package com.ts.msg.invw.PwMgr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList record_id, web_app_name, user_name, user_pwd;

    CustomAdapter(Activity activity, Context context, ArrayList record_id, ArrayList web_app_name, ArrayList user_name,
                  ArrayList user_pwd){
        this.activity = activity;
        this.context = context;
        this.record_id = record_id;
        this.web_app_name = web_app_name;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.web_app_name_txt.setText(String.valueOf(web_app_name.get(position)));
        holder.user_name_txt.setText(String.valueOf(user_name.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(record_id.get(position)));
                intent.putExtra("webapp", String.valueOf(web_app_name.get(position)));
                intent.putExtra("usrname", String.valueOf(user_name.get(position)));
                intent.putExtra("usrpwd", String.valueOf(user_pwd.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return record_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView web_app_name_txt, user_name_txt, user_pwd_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            web_app_name_txt = itemView.findViewById(R.id.web_app_name_txt);
            user_name_txt = itemView.findViewById(R.id.user_name_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
