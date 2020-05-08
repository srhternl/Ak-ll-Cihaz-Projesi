package akillicihaz;

public class MerkeziIslemBirimi implements IMerkeziİslemBirimi {
    private static final MerkeziIslemBirimi instance = new MerkeziIslemBirimi();

    private MerkeziIslemBirimi() {}

    public static MerkeziIslemBirimi getInstance()
    {

        return instance;
    }

    //ağ arayüzünden gelen isteğe cevaplar
    @Override
    public int sicaklikGoruntuleme()//sicaklik görünteleme isteğine cevap
    {
        return SicaklikAlgilayici.getInstance().ortamSicakligiOlcme(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }

    @Override
    public String sogutucuAcmaIstegi() //soğutucu açma isteğine cevap
    {
        return Eyleyici.getInstance().sogutucuAcma(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }

    @Override
    public String sogutucuKapatmaIstegi() //sogutucu kapatma isteğine cevap
    {
        return Eyleyici.getInstance().sogutucuKapatma(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }
}
