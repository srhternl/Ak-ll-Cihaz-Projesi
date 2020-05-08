package akillicihaz;
import java.util.Random;
public class SicaklikAlgilayici implements ISıcaklıkAlgilayici {

    private static final SicaklikAlgilayici instance = new SicaklikAlgilayici();

    private SicaklikAlgilayici() {}

    public static SicaklikAlgilayici getInstance()
    {
        return instance;
    }

    @Override
    public int ortamSicakligiOlcme()
    {
        Random derece = new Random();

        double sicaklikDegeri = (derece.nextInt(40) + 1);

        return (int)sicaklikDegeri;
    }

}

