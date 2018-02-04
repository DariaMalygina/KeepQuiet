package com.example.daria.keepquiet.adaprer;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daria.keepquiet.R;

import java.util.List;

public final class DialogsAdapter extends RecyclerView.Adapter<DialogsAdapter.ViewHolder> {
    private List<Dialog> dialogs;

    public DialogsAdapter(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView photoDialog;
        public TextView nameDialog;

        public ViewHolder(View view) {
            super(view);
            photoDialog = view.findViewById(R.id.dialog_photo);
            nameDialog = view.findViewById(R.id.dialog_name);
        }
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.dialog_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameDialog.setText(dialogs.get(position).getNime());
        holder.photoDialog.setImageResource(R.drawable.ic_person_black_24dp);
    }

}
