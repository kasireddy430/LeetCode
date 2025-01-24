public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //Initialize a string builder for encoding a string
       StringBuilder encodedString = new StringBuilder();

        //Iterate over input list and construct encoded string
        for(String str : strs){
            encodedString.append(str.length()).append('#').append(str);
        }

        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        //Iterate over input string
        while(i < s.length()){
            int j = i;

            //Iterate until '#' is found
            while(s.charAt(j) != '#'){
                j++;
            }

            //retrive the length of each of the substring
            int length = Integer.parseInt(s.substring(i, j));
            //move the pointer to starting index of next substring
            i = j + 1 + length;
            //add each of the substring to result array
            result.add(s.substring(j + 1, i));
        }
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));