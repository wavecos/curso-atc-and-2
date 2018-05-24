package bo.com.cognos.quakeradar.domain;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class QuakeDeserializer implements JsonDeserializer<Quake> {

    @Override
    public Quake deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Quake quake = new Quake();
        final JsonObject jsonObject = json.getAsJsonObject();
        JsonObject propertiesObject = jsonObject.get("properties").getAsJsonObject();
        JsonObject geometryObject = jsonObject.get("geometry").getAsJsonObject();

        Float magnitude = propertiesObject.get("mag").getAsFloat();
        String place = propertiesObject.get("place").getAsString();
        String url = propertiesObject.get("url").getAsString();
        boolean tsunami = propertiesObject.get("tsunami").getAsBoolean();
        String type = propertiesObject.get("type").getAsString();
        long time = propertiesObject.get("time").getAsLong();

        double longitude = geometryObject.get("coordinates").getAsJsonArray().get(0).getAsDouble();
        double latitude = geometryObject.get("coordinates").getAsJsonArray().get(1).getAsDouble();

        quake.setMagnitude(magnitude);
        quake.setPlace(place);
        Date quakeDate = new Date(time);
        quake.setDate(quakeDate);

        quake.setUrl(url);
        quake.setTsunami(tsunami);
        quake.setType(type);
        quake.setLongitude(longitude);
        quake.setLatitude(latitude);

        return quake;
    }
}
