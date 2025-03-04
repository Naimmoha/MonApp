package ma.project.MyApp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.logo);

        RotateAnimation rotate = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setRepeatCount(Animation.INFINITE);
        logo.startAnimation(rotate);

        new Thread(() -> {
            try {
                Thread.sleep(5000); // Pause de 5 secondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Passer à MainActivity
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish(); // Fermer SplashActivity
        }).start();
    }
}