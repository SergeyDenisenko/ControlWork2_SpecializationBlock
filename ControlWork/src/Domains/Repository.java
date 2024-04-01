package Domains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class Repository {
    private String path;

    public Repository(String path)
    {
        this.path = path;
    }

    public String readLine()
    {
        StringBuilder str = new StringBuilder();
        try (FileReader fileReader = new FileReader(this.path)) {
            BufferedReader buffer = new BufferedReader(fileReader);

            while(buffer.ready())
            {
                str.append(" "+ buffer.readLine());
            }
        } catch (Exception e) {
            return "";
        }
        return str.toString();
    }

    public List<String> read()
    {
        String[] ar = this.readLine().split(" ");
        List<String> list = new ArrayList<>();

        for (int i=0; i<ar.length; i++)
        {
            String str = ar[i].replace(" ", "");
            if (str.length() > 0) {
                list.add(str);
            }
        }
        return list;
    }

    public Integer length() {
        return this.read().size();
    }

    public Integer maxLengthEntries()
    {
        Integer maxLen = 0;
        List<String> list = this.read();
        for (int i=0; i<list.size(); i++)
        {
            int size = list.get(i).length();
            if (size > maxLen) {
                maxLen = size;
            }
        }
        return maxLen;
    }

    public HashMap<String, Integer> getFrequency()
    {
        List<String> list = this.read();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 0);
            } else {
                Integer num = map.get(list.get(i));
                map.put(list.get(i), ++num);
            }
        }
        return map;
    }

    public List<String> maxEntries()
    {
        List<String> list = this.read();
        Integer maxLengthWord = this.maxLengthEntries();
        List<String> listMax = new ArrayList<>();

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).length() == maxLengthWord && !listMax.contains(list.get(i))) {
                listMax.add(list.get(i));
            }
        }
        return listMax;
    }
}
