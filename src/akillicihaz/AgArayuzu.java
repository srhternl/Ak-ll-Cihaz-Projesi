package akillicihaz;

import org.w3c.dom.ls.LSOutput;

public class AgArayuzu implements IAgArayuzu {


    IKullaniciYonetimi admin;

    public AgArayuzu(IKullaniciYonetimi admin)
    {
        this.admin = admin;
    }

    @Override
    public double sicaklikGonderme() {
        double sicaklik;
        sicaklik = MerkeziIslemBirimi.getInstance().sicaklikGoruntuleme();
        admin.notify("Ortam Sıcaklığı: " + sicaklik + " Derece  " );
        return sicaklik;
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
