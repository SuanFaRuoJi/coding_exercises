import java.util.ArrayList;
import java.util.List;

public class wsz_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        List<Integer> metainfo = new ArrayList<>();
        int length = 0;
        for (String word : words) {
            if (cur.size() + length + word.length() > maxWidth) {
                result.add(cur);
                cur = new ArrayList<>();
                metainfo.add(length);
                length = 0;
            }
            cur.add(word);
            length += word.length();
        }
        result.add(cur);
        metainfo.add(length);
        List<String> formatted = new ArrayList<>();
        for (int index = 0; index < result.size(); index++) {
            List<String> line = result.get(index);
            System.out.println(line.size() + " " + metainfo.get(index));
            StringBuilder formatted_line = new StringBuilder();
            if (line.size() == 1) {
                formatted_line.append(line.get(0));
                repeatSpace(formatted_line, maxWidth - line.get(0).length());
            } else if (index + 1 < result.size()) {
                int raw_length = metainfo.get(index);
                int base = (maxWidth - raw_length) / (line.size()-1);
                int remain = (maxWidth - raw_length) % (line.size()-1);
                for (int i=0; i<line.size(); i++) {
                    formatted_line.append(line.get(i));
                    if (i+1 < line.size()) {
                        repeatSpace(formatted_line, base);
                    }
                    if (i < remain) {
                        repeatSpace(formatted_line, 1);
                    }
                }
            } else {
                for (int i=0; i<line.size(); i++) {
                    formatted_line.append(line.get(i));
                    formatted_line.append(' ');
                }
            }

            formatted.add(formatted_line.toString());
        }
        return formatted;
    }

    private void repeatSpace(StringBuilder sb, int times) {
        for (int i=0; i<times; i++) {
            sb.append(' ');
        }
    }
}
