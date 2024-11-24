public interface Kjnjiznicar {
    /**
     * Posudivanje knige iz knjiznice
     * @param knjiga koja se posuduje
     * @param clan koji posuduje knjigu
     */
    public void posudivanjeKnjige(Knjiga knjiga,Clan clan);

    /**
     * Vracanje knjige u knjiznicu
     * @param knjiga koja se vraca
     * @param clan koji vraca knjigu
     */
    public void vracanjeKnjige(Knjiga knjiga,Clan clan);
}
