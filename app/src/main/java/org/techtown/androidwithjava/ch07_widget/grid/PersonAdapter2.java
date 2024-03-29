package org.techtown.androidwithjava.ch07_widget.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.androidwithjava.R;


import java.util.ArrayList;

public class PersonAdapter2 extends RecyclerView.Adapter<PersonAdapter2.ViewHolder> implements OnPersonItemClickListener {
    ArrayList<Person2> itemslist = new ArrayList<Person2>();
    OnPersonItemClickListener listener;     // 아이템리스너


    // 아이템을 위해 정의한 xml 레이아웃을 이용해 뷰 객체를 만들어줌.  그리고 뷰 객체를 새로 만든 뷰홀더 객체에 담아 반환.
    // 인플레이션 진행을 위해선 context 객체가 필요함 (파라미터로 전달되는 뷰그룹 객체의 getContext 메서드를 이용하여 context 객체를 참조)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //뷰타입은 이미자나 텍스트를등 원하는 타입을 보여주고싶다면 각각의 뷰타입에 따라 다른 xml 레이아웃을 인플레이션 하게됨
        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.person_item, parent, false);  //인플레이션을 통해 뷰 객체 만들기

        // 이걸 한번에 적으면    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);


        /**
         * 매개변수에  this 추가??
         */
        return new ViewHolder(itemView, this);   //뷰홀더 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체를 반환하기   ,
        //Q.   그냥 return ViewHolder; 랑 어캐 다르지
    }


    // 뷰홀더가 재사용될 때 호출됨.  뷰 객체는 기존것을 그대로 사용하고 데이터만 봐꿔 줌
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person2 item = itemslist.get(position);
        holder.setItem(item);


    }

    // ArrayList 의 전체 아이템이 몇개인지 확인 한 후 그 값을 반환
    @Override
    public int getItemCount() {
        return itemslist.size();
    }


    /**
     *  인터페이스 구현하는 오버라이드
     * @param holder
     * @param view
     * @param position
     */
    @Override   // 인터페이스 구현하는 오버라이드 .
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void setOnItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView, final OnPersonItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);

            /**
             * 아이템 뷰에 OnClickListener 설정하기
             */
            itemView.setOnClickListener(new View.OnClickListener() {    //ㅇㅏ이템 뷰에 OnClickListener 설정하기
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, v, position);  //아이템 뷰 클릭시 미리 정의한 다른 리스너의 메서드 호출하기
                    }
                }
            });

        }

        public void setItem(Person2 item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }
    }

    /** 각각의 아이템을 위한 Person 객체를 어레이리스트 안에 넣어 관리하기 때문에 이 어뎁터를 사용하는 소스코드에서 어뎁터에 Person 객체를 넣거나 가져갈수 잇도록 만든 메서드.
     *
     *  PersonActivity가 매개변수로 들어간거 이해됨? --> PersonActivity를 객체로 썻다는거고..?   --> 객체가된 변수를  어레이리스트에 넣으면.. 더해진다??     personactivity에는 2가지 정보가 입력되어야 하는데
     *
     */
    public void addItem(Person2 item){
        itemslist.add(item);
    }

    public void setItemslist(ArrayList<Person2> itemslist){            //  매개변수 어레이리스트를 전역변수 어레이리스트와 동일하게 만들어줌
        this.itemslist = itemslist;
    }

    public Person2 getItem(int position) {    // 어레이리스트 포지션값 리턴
        return itemslist.get(position);
    }

    public void setItem(int position, Person2 item) {  // 어레이리스트 수정할때 사용하는듯
        itemslist.set(position, item);
    }

}
