package bo.com.cognos.topmusic.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Cancion implements Parcelable {

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
    @SerializedName("previewUrl")
    private String cancionUrl;

    public Cancion() {
    }

    protected Cancion(Parcel in) {
        nombreArtista = in.readString();
        nombreAlbum = in.readString();
        nombreCancion = in.readString();
        imagenUrl = in.readString();
        pais = in.readString();
        genero = in.readString();
        cancionUrl = in.readString();
    }

    public static final Creator<Cancion> CREATOR = new Creator<Cancion>() {
        @Override
        public Cancion createFromParcel(Parcel in) {
            return new Cancion(in);
        }

        @Override
        public Cancion[] newArray(int size) {
            return new Cancion[size];
        }
    };

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

    public String getCancionUrl() {
        return cancionUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nombreArtista);
        parcel.writeString(this.nombreAlbum);
        parcel.writeString(this.nombreCancion);
        parcel.writeString(this.imagenUrl);
        parcel.writeString(this.pais);
        parcel.writeString(this.genero);
        parcel.writeString(this.cancionUrl);
    }
}
