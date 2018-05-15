package bo.com.cognos.topmusic.domain;

public class Cancion {

    private String trackName;
    private String collectionName;
    private String nombreArtista;
    private String nombreAlbum;
    private String nombrteCancion;
    private String imagenUrl;
    private String pais;
    private String genero;

    public Cancion() {
    }

    public String getTrackName() {
        return trackName;
    }

    public String getCollectionName() {
        return collectionName;
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

    public String getNombrteCancion() {
        return nombrteCancion;
    }

    public void setNombrteCancion(String nombrteCancion) {
        this.nombrteCancion = nombrteCancion;
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
