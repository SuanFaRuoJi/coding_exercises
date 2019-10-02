class wsz_java_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int l = edges.length, abnormal = -1;
        ArrayList<Integer>[] in_graph = new ArrayList[l+1];
        ArrayList<Integer>[] out_graph = new ArrayList[l+1];
        for (int i=0; i<l; i++){
            int[] cur = edges[i];
            int from = cur[0], to = cur[1];
            if (out_graph[from] == null){
                out_graph[from] = new ArrayList<Integer>();
            }
            if (in_graph[to] == null){
                in_graph[to] = new ArrayList<Integer>();
            }
            out_graph[from].add(i);
            in_graph[to].add(i);
            if (in_graph[to].size() >= 2){
                abnormal = to;
            }
        }
        ArrayList<Integer> seed = new ArrayList<Integer>();
        if (abnormal >= 0){
            if (out_graph[abnormal] != null){
                for (int i=0; i<out_graph[abnormal].size(); i++){
                    seed.add(out_graph[abnormal].get(i));
                    ArrayList<Integer> result = backtrack(edges, out_graph, seed);
                    if (result != null){
                        for (int j=0; j<result.size(); j++){
                            int end = edges[result.get(j)][1];
                            if (end == abnormal){
                                return edges[result.get(j)];
                            }
                        }
                    }
                    seed.remove(seed.size()-1);
                }
            }
            int to_remove = in_graph[abnormal].get(in_graph[abnormal].size()-1);
            return edges[to_remove];
        }else{
            for (int i=0; i<l; i++){
                seed.add(i);
                ArrayList<Integer> result = backtrack(edges, out_graph, seed);
                if (result != null){
                    int max = Integer.MIN_VALUE;
                    for (int j=0; j<result.size(); j++){
                        int cur = result.get(j);
                        if (cur > max){
                            max = cur;
                        }
                    }
                    return edges[max];
                }
                seed.remove(seed.size()-1);
            }
        }
        return edges[0];
    }

    private ArrayList<Integer> backtrack(int[][] edges,
                                         ArrayList<Integer>[] out_graph,
                                         ArrayList<Integer> cur){
        int tail_edge = cur.get(cur.size()-1), head_edge = cur.get(0);
        int head = edges[head_edge][0], tail = edges[tail_edge][1];
        if (head == tail){
            return new ArrayList<Integer>(cur);
        }
        ArrayList<Integer> next_steps = out_graph[tail];
        if (next_steps == null){
            return null;
        }
        for (int i=0; i<next_steps.size(); i++){
            int next_step = next_steps.get(i);
            cur.add(next_step);
            ArrayList<Integer> result = backtrack(edges, out_graph, cur);
            if (result != null){
                return result;
            }
            cur.remove(cur.size()-1);
        }
        return null;
    }
}