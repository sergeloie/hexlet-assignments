package exercise;

import java.util.Map;

// BEGIN
public class Tag {

    protected String tagName;

    protected Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }


    /**
     * @return String representation of tag
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("<%s", this.tagName));
        for (Map.Entry<String, String> entry : this.attributes.entrySet()) {
            result.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
