public class Proizvod {
    private String nazivProizvoda;
    private double cijenaProizvoda;
    private int kolicinaProizvoda;


    public Proizvod(String nazivProizvoda, double cijenaProizvoda, int kolicinaProizvoda){
        this.nazivProizvoda = nazivProizvoda;
        this.cijenaProizvoda = cijenaProizvoda;
        this.kolicinaProizvoda  = kolicinaProizvoda;
    }
    public String getNazivProizvoda(){
        return this.nazivProizvoda;
    }
    public double getCijenaProizvoda(){
        return this.cijenaProizvoda;
    }
    public int getKolicinaProizvoda(){
        return this.kolicinaProizvoda;
    }

    public String toString(){
        return "|Naziv proizvoda: "+this.nazivProizvoda+"|Cijena proizvoda: "+this.cijenaProizvoda+"$|Kolicna proizvoda: "+this.kolicinaProizvoda+"|";
    }
}
