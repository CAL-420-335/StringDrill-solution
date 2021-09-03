package org.example;

public class StringDrill {
    private String str;

    public StringDrill(String str) {
        this.str = str;
    }

    public boolean commencePar(String sub) {
        if(sub == null) throw new IllegalArgumentException("Args 'sub' est null");
        if(sub.length() > str.length()) return false;

        for(int i=0; i<sub.length();i++) {
            if(str.charAt(i) != sub.charAt(i)) return false;
        }
        return true;
    }

    public int nbOccurence(String sub) {
        if(sub == null) throw new IllegalArgumentException("Args 'sub' est null");

        int nb = 0;
        int idx = 0;

        while(idx + sub.length() <= str.length()) {
            if(str.substring(idx, idx + sub.length()).equals(sub)) {
                nb++;
            }
            idx++;
        }

        return nb;
    }

    public String subSplit(int idx, String sub){
        String[] subs = split(sub);;
        if(idx >= subs.length) throw new IllegalArgumentException();

        return subs[idx];
    }

    public String[] split(String sub){
        int nb = nbOccurence(sub) + 1;
        String[] subs = new String[nb];

        int startIdx = 0;
        int subsIdx = 0;

        while(startIdx < str.length()) {
            int endIdx = startIdx;

            boolean foundSplit = false;
            while(!foundSplit){
                if(endIdx + sub.length() > str.length()) {
                    endIdx = str.length();
                    foundSplit = true;
                }
                else if(str.substring(endIdx, endIdx + sub.length()).equals(sub)){
                    foundSplit = true;
                }
                else {
                    endIdx++;
                }
            }
            subs[subsIdx++] = str.substring(startIdx, endIdx);
            startIdx = endIdx + sub.length();
        }

        while(subsIdx < subs.length) subs[subsIdx++] = "";

        return subs;
    }

    // Implementation type
    private String substring(int debut, int fin){
        String res = "";
        for(int i = debut; i < fin; i++) res += str.substring(debut,fin);
        return res;
    }
}
