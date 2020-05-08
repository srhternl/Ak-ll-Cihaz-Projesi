package akillicihaz;
import java.util.ArrayList;
import java.util.List;
public class Kullanici implements IKullaniciYonetimi {

    private List<IObserver> kullanici = new ArrayList<>();

    @Override
    public void attach(IObserver o) {
        kullanici.add(o);
    }

    @Override
    public void detach(IObserver o) {
        kullanici.remove(o);
    }

    @Override
    public void notify(String m) {
        kullanici.forEach((kullanici) -> {
            kullanici.guncelleme(m);
        });
    }



}
