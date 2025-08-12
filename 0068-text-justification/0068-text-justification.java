class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < words.length){
            int j = i, len = 0;

            while(j < words.length && len + words[j].length() + (j - i) <= maxWidth){
                len += words[j].length();
                j++;
            }

            int gaps = j - (i + 1);
            int space = maxWidth - len;
            StringBuilder line = new StringBuilder();

            if(j == words.length || gaps == 0){
                for(int k = i; k < j; k++){
                    line.append(words[k]);
                    if(k != j - 1) line.append(" ");
                }

                while(line.length() < maxWidth) line.append(" ");
            } else {
                int spaceEach = space/gaps;
                int extra = space % gaps;

                for(int k = i; k < j; k++){

                    line.append(words[k]);
                    if(k != j - 1){
                        int toAdd = spaceEach;
                        if(extra > 0){
                            toAdd += 1;
                            extra--;
                        }
                        line.append(" ".repeat(toAdd));
                    } 
                }
            }

            res.add(line.toString());
            i = j;
        }

        return res;
    }
}