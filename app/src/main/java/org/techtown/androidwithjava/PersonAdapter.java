package org.techtown.androidwithjava;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter {

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

//            textView = itemView.findViewById(R.id.);
//            textView2 = itemView.findViewById(R.id.textView2);

        }

        public void setItem(PersonActivity item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }

}
