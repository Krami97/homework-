public class Roman implements Knjiga{

    private String naslov;
    private String autor;
    private Integer godinjaIzdanja;
    private Integer brojStranica;
    private String stanjePosudbe= "Dostupno";

    public Roman(String naslov , String autor, Integer godinjaIzdanja,Integer brojStranica, String stanjePosudbe){
        this.naslov = naslov;
        this.autor = autor;
        setGodinjaIzdanja(godinjaIzdanja);
        setBrojStranica(brojStranica);
        this.stanjePosudbe = stanjePosudbe;
    }

    public void setGodinjaIzdanja(Integer godinjaIzdanja){
        if(godinjaIzdanja>1900 && godinjaIzdanja < 2024){
            this.godinjaIzdanja = godinjaIzdanja;
        }else {
            System.out.println("Krivo usnesena godina");
        }
    }
    public void setBrojStranica(Integer brojStranica){
        if(brojStranica>0){
            this.brojStranica = brojStranica;
        }else {
            System.out.println("broj stranica nemože biti negtivan broj i nula");
        }
    }



    @Override
    public String getNaslov() {
        return this.naslov;
    }

    @Override
    public String getAutor() {
        return this.autor;
    }

    @Override
    public Integer getGodinaIzdavanja() {
        return this.godinjaIzdanja;
    }

    @Override
    public Integer getBrojStraanica() {
        return this.brojStranica;
    }

    @Override
    public String getStanje() {
        return this.stanjePosudbe;
    }

    @Override
    public void posudi() {
        this.stanjePosudbe = "Posuđeno";

    }

    @Override
    public void vrati() {
        this.stanjePosudbe = "Dostupno";

    }
}
