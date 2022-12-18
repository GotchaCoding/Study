package org.techtown.androidwithjava.socket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.techtown.androidwithjava.R;   // 새로운 패키지 하니까 R. 연결할때 만듬...

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    TextView textView2;

    Handler handler = new Handler();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        editText = findViewById(R.id.editText_socket1);
        textView = findViewById(R.id.textView_socket1);
        textView2 = findViewById(R.id.textView_socket2);

        Button button = findViewById(R.id.btn_socket1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String
                        data = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        send(data);
                    }
                }).start();
            }
        });

        Button button2  = findViewById(R.id.btn_socket2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                        Log.e("MainActivity" , "ㅅㅓ버시작버튼 눌림 ");   //이거 왜 실행 안되?  첫번째 누르면 실행 안되고  두번째부터 에러메세지와 함께 실해왿
                        //버튼 클릭시  run 메소드 에서  startServer 메소드는 실행되는대, while 구문에 루프처럼 갖혀서 반응을 기다리는듯?
                    }
                }).start();
            }
        });


    }






    public void printClientLog(final String data) {
        Log.d("MainActivity" , data);
        handler.post((new Runnable() {
            @Override
            public void run() {
                textView.append(data + "\n");
            }
        }));
    }

    public void printServerLog(final String data) {
        Log.d("MainActivity", data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView2.append(data + "\n");
            }
        });
    }




    public void send(String data) {
        try{
            int portNumber = 5001;
            Socket sock = new Socket("localhost" , portNumber);  //2
            printClientLog("소켓 연결함.");

            ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream()); //sock.getOutputStream
            outstream.writeObject(data);
            outstream.flush();
            printClientLog("데이터 전송함");   //4

            ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
            printClientLog("서버로부터 받음 " + instream.readObject());    //6
            sock.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void startServer(){
        try {
            int portNumber = 5001;

            ServerSocket server = new ServerSocket(portNumber);   //1
            printServerLog("서버 시작함 " + portNumber);

            while(true) {   // 클라이언트의 접속을 기다리다가 클라이언트의 접속 요청이 왓을때 accept 메서드를 통해 소켁 객체가 반환
                Socket sock = server.accept();
                InetAddress clientHost = sock.getLocalAddress();
                int clientPort = sock.getPort();
                printServerLog("클라이언트 연결됨 : " + clientHost + " : " + clientPort);  //3

                ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());   //sock.getInputStream
                Object obj = instream.readObject();
                printServerLog("데이터 받음 : " + obj);   //5

                ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
                outstream.writeObject(obj + " from Server.");    //7
                outstream.flush();
                printServerLog("데이터 보냄.");    //6

                sock.close();
            }
        } catch(Exception ex) {
            ex.printStackTrace();


        }
    }
}