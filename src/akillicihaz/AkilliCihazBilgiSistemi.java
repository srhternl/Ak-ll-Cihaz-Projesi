package akillicihaz;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AkilliCihazBilgiSistemi {

    private Connection connection =null;
    public boolean Baglanti(String kullaniciAdi, String sifre) throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYAT", "postgres", "123456");

            if (connection != null) {
                System.out.println("Veri Tabanına Bağlandı. \n");
            }
            else {
                System.out.println("Bağlantı girişimi başarısız! \n");
            }

        }
        catch (Exception e) {
            System.out.println("Baglanti Yapilamadı. \n");
            e.printStackTrace();
        }

        ResultSet rs=null;
        PreparedStatement pst=null;
        String sqlKomut = "select * from \"Bilgiler\" where \"kullaniciAdi\"=? and sifre=?";

        pst = connection.prepareStatement(sqlKomut);
        pst.setString(1,kullaniciAdi);
        pst.setString(2,sifre);
        rs = pst.executeQuery();
        connection.close();

        if(rs.next())
        {
            System.out.println("Kullanıcı Adı ve Şifre Doğrulandı. \n \n");
            return true;
        }
        else
        {
            System.out.println("Girilen Kullanıcı Adı ve Şifre Hatalı. \n \n");
            return false;
        }

    }
}
