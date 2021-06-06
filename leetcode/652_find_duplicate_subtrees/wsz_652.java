import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class wsz_652 {
    private static int global = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, List<TreeNode>> memory = new HashMap<>();
        Map<String, Integer> rawHashMemory = new HashMap<>();
        traverse(root, memory, rawHashMemory);
        List<TreeNode> result = new ArrayList<>();
        memory.entrySet().forEach(entry -> {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue().get(0));
            }
        });
        return result;
    }

    private static int traverse(TreeNode root, Map<Integer, List<TreeNode>> memory, Map<String, Integer> rawHashMemory) {
        int left_hash = root.left == null ? 0 : traverse(root.left, memory, rawHashMemory),
                right_hash = root.right == null ? 0 : traverse(root.right, memory, rawHashMemory);
        String raw_hash = left_hash + "/" + root.val + "/" + right_hash;
        int hash;
        if (rawHashMemory.containsKey(raw_hash)) {
            hash = rawHashMemory.get(raw_hash);
        } else {
            global ++;
            hash = global;
            rawHashMemory.put(raw_hash, hash);
        }
        memory.putIfAbsent(hash, new ArrayList<>());
        memory.get(hash).add(root);
        return hash;
    }

}
