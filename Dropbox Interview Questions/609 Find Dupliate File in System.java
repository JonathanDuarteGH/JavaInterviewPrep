// Brute Force - Linked List Approach
public class Solution {
    public List < List < String >> findDuplicate(String[] paths) {
        List < String[] > list = new ArrayList < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                list.add(new String[] {
                    values[0] + "/" + name_cont[0], name_cont[1]
                });
            }
        }
        boolean[] visited = new boolean[list.size()];
        List < List < String >> res = new ArrayList < > ();
        for (int i = 0; i < list.size() - 1; i++) {
            if (visited[i])
                continue;
            List < String > l = new ArrayList < > ();
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i)[1].equals(list.get(j)[1])) {
                    l.add(list.get(j)[0]);
                    visited[j] = true;
                }
            }
            if (l.size() > 0) {
                l.add(list.get(i)[0]);
                res.add(l);
            }
        }
        return res;
    }
}

// Optimized Solution - Hashmap
public class Solution {
    public List < List < String >> findDuplicate(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }
        return res;
    }
}

/*
Question-1:
Imagine you are given a real file system, how will you search files? DFS or BFS?

Answer:
core idea: DFS

Reason: if depth of directory is not too deeper, which is suitable to use DFS, comparing with BFS.



Question-2:
If the file content is very large (GB level), how will you modify your solution?

Answer:
core idea: make use of meta data, like file size before really reading large content.
Two steps:
DFS to map each size to a set of paths that have that size: Map<Integer, Set>
For each size, if there are more than 2 files there, compute hashCode of every file by MD5, if any files with the same size have the same hash, then they are identical files: Map<String, Set>, mapping each hash to the Set of filepaths + filenames. This hash id's are very very big, so we use the Java library BigInteger.

To optimize Step-2. In GFS, it stores large file in multiple "chunks" (one chunk is 64KB). we have meta data, including the file size, file name and index of different chunks along with each chunk's checkSum(the xor for the content). For step-2, we just compare each file's checkSum.
Disadvantage: there might be false positive duplicates, because two different files might share the same checkSum.



Question-3:
If you can only read the file by 1kb each time, how will you modify your solution?

Answer:
- makeHashQuick Function is quick but memory hungry, might likely to run with java -Xmx2G or the likely to increase heap space if RAM available.
- We might need to play with the size defined by "buffSize" to make memory efficient.



Question-4:
What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?

Answer:
hashing part is the most time-consuming and memory consuming.
optimize as above mentioned, but also introduce false positive issue.



Question-5:
How to make sure the duplicated files you find are not false positive?

Answer:
Question-2-Answer-1 will avoid it.
We need to compare the content chunk by chunk when we find two "duplicates" using checkSum.


FollowUp:
This is great, but it requires you to compute the hash for every single file once, which can be expensive for large files. Is there anyway you can avoid computing the hash for a file?

One approach is to also maintain a metadata field for each file's size on disk. Then you can take a 2 pass approach:

DFS to map each size to a set of paths that have that size
For each size, if there are more than 2 files there, compute hash of every file, if any files with the same size have the same hash, then they are identical files.
*/