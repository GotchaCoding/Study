package org.techtown.androidwithjava.ch10_server.http.movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.androidwithjava.R;

import java.util.ArrayList;

public class MovieAdapter2 extends RecyclerView.Adapter<MovieAdapter2.ViewHolder> {

    ArrayList<Movie2> items = new ArrayList<Movie2>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, parent, false);

        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie2 item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

  public void addItem(Movie2 item){
        items.add(item);
  }

  public void setItems(ArrayList<Movie2> items) {
        this.items = items;
  }

  public Movie2 getItem(int position) {
        return items.get(position);
  }

    static class ViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    TextView textView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView_adapter_movie);
            textView2 = itemView.findViewById(R.id.textView2_adapter_movie);
        }

        public void setItem(Movie2 item) {
            textView.setText(item.movieNm);
            textView2.setText(item.audiCnt + " 명");
        }
    }



}
