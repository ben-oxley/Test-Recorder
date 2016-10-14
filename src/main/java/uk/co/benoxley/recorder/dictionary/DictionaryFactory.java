package uk.co.benoxley.recorder.dictionary;

import java.util.Properties;

/**
 * Created by ben on 14/10/2016.
 */
public class DictionaryFactory {
    public static Dictionary createDictionary(Properties props){
        return new TestFXDictionary();
    }
}
