public class BangunRuang {
    private String name;

    BangunRuang(String name){
        this.name = name;
    }

    public void inputNilai(){
        System.out.println("Input nilai");
    }

    public void luasPermukaan(){
        System.out.println("Menghitung luas permukaan bangun" + name);
    }

    public void volume(){
        System.out.println("Menghitung volume bangun" + name);
    }

    public void setName(String name){ //String seharusnya menggunakan huruf kapital di awal
        this.name = name;
    }

    public String getName(){
        return name;
    } //nama atributnya name bukan your
}
