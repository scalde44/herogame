package co.com.sofkau.model.card;

import co.com.sofkau.model.card.values.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Card {
    private String id;
    private String description;
    private Integer power;
    private Set<Feature> features;
    private String imageUrl;
}
