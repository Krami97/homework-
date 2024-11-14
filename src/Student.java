public  class Student {
    private String ime;
    private String prezime;
    private String brIndexa;

    public Student(String ime, String prezime, String brIndexa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brIndexa = brIndexa;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + ", Prezime: " + prezime + ", Broj Indexa: " + brIndexa;
    }
}