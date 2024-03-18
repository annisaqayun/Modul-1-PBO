import java.util.Scanner;

public class Kubus extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double sisi;

    public Kubus(String name){
        super(name);
    }

    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input sisi: "); //   eror karena tidak lengkqp,seharusnya system.out.print bukan system.o
        sisi = scanner.nextDouble(); // karena angka bentuknya desimal jadi menggunakan nextdouble() bukaan nextnext()
    }

    @Override
    public void luasPermukaan(){
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan();// nama methodnya luaspermukaan bukan luasaan
        System.out.println("Hasil luas permukaan: " + hasil);//eror karena tidak lengkqp,seharusnya system.out.print bukan o.println
    }

    @Override
    public void volume(){
        double hasil = Math.pow(sisi, 3);// menambahkan tipe data yaitu double
        super.volume();
        System.out.println("Hasil volume: " + hasil);//karna saya sudah menambahkan tipe data double di atas maka +hasil tidak error
    }
}
