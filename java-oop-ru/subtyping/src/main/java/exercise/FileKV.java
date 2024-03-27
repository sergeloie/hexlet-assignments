package exercise;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.readFile;
import static exercise.Utils.serialize;
import static exercise.Utils.unserialize;
import static exercise.Utils.writeFile;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String filepath;
    private Map<String, String> map = new HashMap<>();

    public FileKV(String filepath, Map<String, String> initValue) {
        this.filepath = filepath;
        this.map.putAll(initValue);
        String json = serialize(this.map);
        writeFile(this.filepath, json);
    }


    @Override
    public void set(String key, String value) {

        Map<String, String> map = unserialize(readFile(this.filepath));
        map.put(key, value);
        writeFile(this.filepath, serialize(map));
    }

    @Override
    public void unset(String key) {

        Map<String, String> map = unserialize(readFile(this.filepath));
        map.remove(key);
        writeFile(this.filepath, serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> map = unserialize(readFile(this.filepath));
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return unserialize(readFile(this.filepath));
    }
}
// END
