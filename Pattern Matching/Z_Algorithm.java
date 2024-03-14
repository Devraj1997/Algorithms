class Z_Algorithm {
    public int minimumTimeToInitialState(String word, int k) {
        int[] z_values = computeZValues(word);
        int i = k;
        while(i < word.length()) {
            int len = word.length() - i;
            if(len == z_values[i]) {
                return i/k;
            }
            i+=k;
        }
        int q = word.length()/k;
        if(word.length()%k!=0) q+=1;
        return q;
    }

    private  int[] computeZValues(String pattern) {
        int[] z_values = new int[pattern.length()];
        int i = 1, j = 0;
        while(i<pattern.length()) {
            while(i+j < pattern.length() && pattern.charAt(i+j) == pattern.charAt(j)) {
                j++;
            }
            z_values[i] = j;
            if(j > 1) {
                int l = i+1, r = Math.min(i+j, pattern.length());
                j = 1;
                while(z_values[j] + l < r) {
                    z_values[l] = z_values[j];
                    j++;
                    l++;
                }
                if(l!=r) {
                    i = l;
                    j = r - l;
                } else {
                    i = r;
                    j = 0;
                }
                continue;
            }
            j = 0;
            i++;
        }
        return z_values;
    }
}