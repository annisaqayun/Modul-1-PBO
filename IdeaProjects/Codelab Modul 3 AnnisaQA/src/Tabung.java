import java.util.Scanner;

public class Tabung extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double tinggi;
    private double jariJari;

    public Tabung(String name) {
        super(name);
    }

    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();//menambahkan objek scanner sebelum nextdouble
        System.out.print("Input jari-jari: ");
        jariJari = scanner.nextDouble();//tidak terdapat tanda (_) pada atribut yang telah dibuat di atas
    }

    @Override
    public void luasPermukaan(){
        double hasil = 2 * Math.PI * jariJari * (jariJari + tinggi);//tidak terdapat tanda (_) pada atribut yang telah dibuat di atas
        super.luasPermukaan();// menambahkan parameter
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        double hasil = Math.PI * Math.pow(jariJari, 2) * tinggi;//tidak terdapat tanda (_) pada atribut yang telah dibuat di atas
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}