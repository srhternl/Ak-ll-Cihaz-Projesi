package akillicihaz;

public interface IKullaniciYonetimi {

    public void attach(IObserver o);
    public void detach(IObserver o);
    public void notify(String m);

}
