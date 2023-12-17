package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {

    private String tagBody;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    /**
     * @return String representation of Paired tag
     */
    @Override
    public String toString() {

        StringBuilder result = new StringBuilder(new Tag(this.tagName, this.attributes).toString());
        result.append(this.tagBody);
        if (!this.children.isEmpty()) {
            for (Tag tag : this.children) {
                result.append(tag.toString());
            }
        }
        result.append(String.format("</%s>", this.tagName));
        return result.toString();
    }
}
// END
