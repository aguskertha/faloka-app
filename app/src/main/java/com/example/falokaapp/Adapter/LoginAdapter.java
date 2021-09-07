package com.example.falokaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falokaapp.Model.User;
import com.example.falokaapp.R;

import java.util.List;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.LoginViewHolder> {

    List<User> users;
    LayoutInflater inflater;

    public LoginAdapter(Context context, List<User> users){
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.activity_login, parent, false);
        return new LoginViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoginViewHolder holder, int position) {
//        User user = users.get(position);
//        user.
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder {

        EditText username;

        public LoginViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.edt_regis_username);
        }
    }
}
