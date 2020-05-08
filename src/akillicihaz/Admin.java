package akillicihaz;
import java.util.ArrayList;
import java.util.List;
public class Admin implements IObserver {

    @Override
    public void guncelleme(String m)
    {
        System.out.println("Admine gelen mesaj --->" + m);
    }

}
