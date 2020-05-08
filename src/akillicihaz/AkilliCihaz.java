package akillicihaz;
import static java.lang.System.exit;
import static java.lang.System.setOut;

import java.sql.SQLException;
import java.util.Scanner;

public class AkilliCihaz {

    private static Scanner giris;
    private static int secim = 0;
    private final IAgArayuzu agAraYuz;
    private final IAgArayuzu agAraYuzk;
    private final AkilliCihazBilgiSistemi akillicihaz;
    Admin admin;
    Kullanici k;

    public AkilliCihaz() {
        giris = new Scanner(System.in);
        akillicihaz = new AkilliCihazBilgiSistemi();
        admin = new Admin();
        k = new Kullanici();
        k.attach(admin);
        agAraYuz = new AgArayuzu(k);
        agAraYuzk = new KelvinHesabi(k);
    }

    public void basla() throws SQLException
    {
        if(login())
        {
            System.out.println("Başarılı bir şekilde giriş yapıldı.");
            secim();
        }
        else
        {
            System.out.println("Çıkış yapılıyor.");
        }
        exit(0);
    }

    private void secim()
    {
        while (secim != 4)
        {
            secimKontrolu();
            switch (secim)
            {

                case 1:
                    System.out.println(agAraYuz.acilmaBildirimi());
                    break;

                case 2:
                    System.out.println(agAraYuz.kapanmaBildirimi());
                    System.out.println("Akıllı cihaz kapalı durumdadır.");
                    break;
                case 3:
                    System.out.println("Cihaz üzerindeki mesaj --> Ortam Sıcaklığı : "  + agAraYuz.sicaklikGonderme() + " Derece" );//open-closed ilkesi örneği
                    System.out.println("Cihaz üzerindeki mesaj --> Ortam Sıcaklığı : "  + agAraYuzk.sicaklikGonderme() + " Kelvin"  );//open-closed ilkesi örneği
                    break;
                case 4:
                    System.out.println("Çıkış yapıldı.");
                default:
                    break;
            }

        }
    }

    public static void secimKontrolu()
    {

        System.out.println("1 - Soğutucu Açma\n2 - Soğutucu Kapatma\n3 - Sıcaklık Görüntüleme\n4 - Çıkış");
        System.out.print("Seçiminiz :");
        secim = giris.nextInt();

        while (secim < 1 || secim > 4)
        {
            System.out.println("Lütfen Geçerli Değerler Giriniz!\n1 - Soğutucu Açma\n2 - Soğutucu Kapatma\n3 - Sıcaklık Görüntüleme\n4 - Çıkış");
            System.out.print("Seçiminiz :");
            secim = giris.nextInt();
        }

    }

    private boolean login() throws SQLException
    {
        String kullaniciAdi;
        String sifre;
        for(int i = 1; i <= 3; i++)
        {
            System.out.println("Kullanici adinizi giriniz.");
            kullaniciAdi = giris.next();
            System.out.println("Sifrenizi Giriniz.");
            sifre = giris.next();
            if(kullaniciDogrulama(kullaniciAdi, sifre))
                return true;
            else
                System.out.println("Yanlış kullanıcı adı veya şifre. Lütfen bilgilerinizi doğru giriniz.");
        }

        return false;
    }
    private boolean kullaniciDogrulama(String kullaniciAdi, String sifre) throws SQLException
    {
        return akillicihaz.Baglanti(kullaniciAdi, sifre);
    }

}
