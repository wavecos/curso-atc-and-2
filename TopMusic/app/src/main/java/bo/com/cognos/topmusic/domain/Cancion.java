package bo.com.cognos.topmusic.domain;

import com.google.gson.annotations.SerializedName;

public class Cancion {

    @SerializedName("artistName")
    private String nombreArtista;
    @SerializedName("collectionName")
    private String nombreAlbum;
    @SerializedName("trackName")
    private String nombreCancion;
    @SerializedName("artworkUrl100")
    private String imagenUrl;
    @SerializedName("country")
    private String pais;
    @SerializedName("primaryGenreName")
    private String genero;

    public Cancion() {
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
