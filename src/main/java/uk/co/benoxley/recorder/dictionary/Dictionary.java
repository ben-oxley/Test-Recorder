package uk.co.benoxley.recorder.dictionary;

import javafx.event.Event;

import java.util.Optional;

/**
 * Created by ben on 30/09/2016.
 */
public interface Dictionary {
    Optional<String> translate(Event event);
}
