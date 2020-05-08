package akillicihaz;

public class KelvinHesabi implements  IAgArayuzu{
    IKullaniciYonetimi kullanici;

    public KelvinHesabi(IKullaniciYonetimi kullanici)
    {
        this.kullanici = kullanici;
    }


    @Override
    public double sicaklikGonderme() {
        int sicaklikDegeri = MerkeziIslemBirimi.getInstance().sicaklikGoruntuleme();
        double kelvin = sicaklikDegeri+273.15;
        kullanici.notify("Ortam Sıcaklığı: " + kelvin + " Kelvin");
        return kelvin;
    }

    @Override
    public String kapanmaBildirimi() {
        return MerkeziIslemBirimi.getInstance().sogutucuKapatmaIstegi();
    }

    @Override
    public String acilmaBildirimi() {
        return MerkeziIslemBirimi.getInstance().sogutucuAcmaIstegi();
    }


}
