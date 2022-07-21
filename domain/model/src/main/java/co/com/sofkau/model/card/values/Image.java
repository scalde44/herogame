package co.com.sofkau.model.card.values;

import co.com.sofkau.model.generic.ValueObject;

import java.util.Objects;

public class Image implements ValueObject<Image.Properties> {
    private static final String NAME_REQUERIDO = "El name es requerido";
    private static final String URL_REQUERIDA = "La url es requerida";
    private final String name;
    private final String url;

    public Image(String name, String url) {
        this.name = Objects.requireNonNull(name, NAME_REQUERIDO);
        this.url = Objects.requireNonNull(url, URL_REQUERIDA);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String url() {
                return url;
            }
        };
    }

    public interface Properties {
        String name();

        String url();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return name.equals(image.name) && url.equals(image.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}
