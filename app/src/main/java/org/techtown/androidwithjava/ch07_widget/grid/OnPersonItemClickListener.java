package org.techtown.androidwithjava.ch07_widget.grid;

import android.view.View;

public interface OnPersonItemClickListener {
    public void onItemClick(PersonAdapter2.ViewHolder holder, View view, int position);
    // 온아이템클릭 메서드가 호출될때 파라미터로 뷰홀더 객체와 뷰객체 그리고 뷰의 포지션 정보가 전달.
}
