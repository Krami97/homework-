public abstract class AbstraktnaKnjiga implements Knjiga{
    protected String naslov;
    protected String autor;
    protected Integer godinaIzdavanja;
    protected Integer brojStranica;
    protected String stanjePosudbe;


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
        return this.godinaIzdavanja;
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
    public void setGodinjaIzdanja(Integer godinjaIzdanja){
        if(godinjaIzdanja>1900 && godinjaIzdanja < 2024){
            this.godinaIzdavanja = godinjaIzdanja;
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
}
