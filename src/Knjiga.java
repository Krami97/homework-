public interface Knjiga {
    String getNaslov();
    String getAutor();
    Integer getGodinaIzdavanja();
    Integer getBrojStraanica();
    String getStanje();
    void posudi();
    void vrati();
}
