package moi;

public class Voiture {
    private String marque;
    private float prix;

    public Voiture(String marque1, float prix1){
        this.marque = marque1;
        this.prix = prix1;
    }

    public String getMarque(){
        return this.marque;
    }

    public float getPrix(){
        return this.prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", prix=" + prix +
                '}';
    }

}
