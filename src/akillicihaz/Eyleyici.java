package akillicihaz;

public class Eyleyici implements IEyleyici{

    private static final Eyleyici instance = new Eyleyici(); //singleton pattern

    private Eyleyici() {}

    public static Eyleyici getInstance()
    {
        return instance;
    }

    @Override
    public String sogutucuAcma()
    {
        return ("Sogutucu Başlatıldı.");
    }

    @Override
    public String sogutucuKapatma()
    {
        return ("Sogutucu Kapatıldı.");
    }

}
