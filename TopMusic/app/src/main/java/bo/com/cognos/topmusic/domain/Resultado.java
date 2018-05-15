package bo.com.cognos.topmusic.domain;

import java.util.List;

public class Resultado {

    private String resultCount;
    private List<Cancion> results;

    public String getResultCount() {
        return resultCount;
    }

    public List<Cancion> getResults() {
        return results;
    }
}
