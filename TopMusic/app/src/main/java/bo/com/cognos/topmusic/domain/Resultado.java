package bo.com.cognos.topmusic.domain;

import java.util.List;

public class Resultado {

    private Integer resultCount;
    private List<Cancion> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public List<Cancion> getResults() {
        return results;
    }
}
