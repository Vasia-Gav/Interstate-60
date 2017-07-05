package gav.vaska.basil.hellokitty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements Shaker.Callback{

    private Integer images[] = this.getDarwables();
    private int currImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialImage();
        setImageShowingListener();
    }

    public void shakingStarted() {
        currImage++;
        if (currImage == 3) {
            currImage = 0;
        }
        setCurrentImage();
    }

    public void shakingStopped() {

    }

    private void setImageShowingListener() {
        Shaker shaker = new Shaker(this, 1, 10, this);
    }

    private Integer[] getDarwables() {
        Field[] ID_Fields = R.drawable.class.getFields();
        Integer[] resArray = new Integer[ID_Fields.length];
        for(int i = 0; i < ID_Fields.length; i++) {
            try {
                resArray[i] = 1; //todo: get id somehow like ID_Fields[i].getInt(null);
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resArray;
    }

    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {

        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        imageView.setImageResource(images[currImage]);

    }
}
