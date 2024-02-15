 class KMP_Algorithm {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int[] aLPS = createLPSArray(a);
        int[] bLPS = createLPSArray(b);

        int[] aMatch = patternMatch(s,a,aLPS);
        int[] bMatch = patternMatch(s,b,bLPS);

        for(int i=1;i<bMatch.length;i++) {
            bMatch[i] += bMatch[i-1];
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<=aMatch.length-a.length();i++) {
            if(aMatch[i]==1) {
                int max = bMatch[Math.min(i+k, s.length()-1)];
                int min = Math.max(i-k, 0);
                min = min == 0 ? 0 : bMatch[min-1];
                if(max > min) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    // Pattern match in the original array.
    private int[] patternMatch(String s, String pattern, int[] lps) {
        int[] match = new int[s.length()];

        int j = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == pattern.charAt(j)) {
                j++;
                if(j == pattern.length()) {
                    match[i-j+1] = 1;
                    j = lps[j-1];
                }
                continue;
            }
            while(j > 0) {
                j = lps[lps[j-1]];
                if(s.charAt(i) == pattern.charAt(j)) {
                    j++;
                    break;
                }
            }
        }
        return match;
    }

    //Creating the LPS Array - Longest Prefix which is Suffix
    private int[] createLPSArray(String pattern) {
        int i=0,j=1;
        int[] lps = new int[pattern.length()];

        while(j<pattern.length()) {
            if(pattern.charAt(j)==pattern.charAt(i)) {
                i++;
                lps[j++] = i;
                continue;
            }
            while(i > 0) {
                i = lps[lps[i-1]];
                if(pattern.charAt(j) == pattern.charAt(i)) {
                    i++;
                    lps[j] = i;
                    break;
                }
            }
            j++;
        }
        return lps;
    }
}