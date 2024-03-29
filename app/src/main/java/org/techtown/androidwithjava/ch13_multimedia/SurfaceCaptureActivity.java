package org.techtown.androidwithjava.ch13_multimedia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import org.techtown.androidwithjava.R;

import java.util.List;

public class SurfaceCaptureActivity extends AppCompatActivity {
    CameraSurfaceView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_capture);

        FrameLayout previewFrame = findViewById(R.id.previewFrame);
        cameraView = new CameraSurfaceView(this);
        previewFrame.addView(cameraView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        AndPermission.with(this)
                .runtime()
                .permission(
                        Permission.CAMERA,
                        Permission.READ_EXTERNAL_STORAGE,
                        Permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> permissions) {
                        showToast("허용된 권한 갯수 : " + permissions.size());
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> permissions) {
                        showToast("거부된 권한 갯수 : " + permissions.size());
                    }
                })
                .start();

    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void takePicture() {
        cameraView.capture((data, camera) -> {
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                String outUriStr = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        bitmap,
                        "Captured Image",
                        "Captured Image using Camera.");
                if (outUriStr == null) {
                    Log.d("SurfaceCapture", "Image insert failed");
                    return;
                } else {
                    Uri outUri = Uri.parse(outUriStr);
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, outUri));
                }
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {  //SurfaeView 클래스 상속하고 콜백인터페이스를 구현하는 클래스 정의
        private SurfaceHolder mHolder;
        private Camera camera = null;

        public CameraSurfaceView(Context context) {
            super(context);

            mHolder = getHolder();        // 생성자에 서피스 홀더 객체 참조후 설정
            mHolder.addCallback(this);

        }
        public void getCameraInstance(){
            try {
                camera = Camera.open();
            } catch (Exception e){
                showToast("카메라가 다른 앱에서 사용중입니다.");
            }
        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) { //서피스 뷰가 만들어질 때 카메라 객체를 참조한 후 미리보기 화면으로 홀더객체 설정
            getCameraInstance();
            setCameraOrientation();

            try {
                camera.setPreviewDisplay(mHolder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            try {
                camera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            try {
                camera.stopPreview();
                camera.release();
                camera = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public boolean capture(Camera.PictureCallback handler) {  //카메라 객체의 takePicture 메서드를 호출하여 사진 촬영
            if (camera != null) {
                camera.takePicture(null, null, handler);
                return true;
            } else {
                return false;
            }
        }
        public void setCameraOrientation() {
            if (camera == null) {
                return;
            }

            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(0, info);

            WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            int rotation = manager.getDefaultDisplay().getRotation();

            int degrees = 0;
            switch (rotation) {
                case Surface.ROTATION_0: degrees = 0; break;
                case Surface.ROTATION_90: degrees = 90; break;
                case Surface.ROTATION_180: degrees = 180; break;
                case Surface.ROTATION_270: degrees = 270; break;
            }

            int result;
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                result = (info.orientation + degrees) % 360;
                result = (360 - result) % 360;
            } else {
                result = (info.orientation - degrees + 360) % 360;
            }

            camera.setDisplayOrientation(result);
        }
    }
}