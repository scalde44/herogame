package co.com.sofkau.mongo.card.collection;

import co.com.sofkau.mongo.card.collection.value.FeatureDocumentValue;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(value = "card")
public class CardDocument {
    @Id
    private String id;
    private String description;
    private Integer power;
    private Set<FeatureDocumentValue> features;
    private String imageUrl;
}
