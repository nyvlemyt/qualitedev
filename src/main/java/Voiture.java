public class Voiture {
    private String marque;
    private int prix;
    private int test; 

    public Voiture(String marque, int prix, int test) {
        this.marque = marque;
        this.prix = prix;
	this.test = test

    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public String toString() {
        return "Voiture [marque=" + marque + ", prix=" + prix + "]";
    }
}
