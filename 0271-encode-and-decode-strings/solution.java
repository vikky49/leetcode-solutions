public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length())
              .append("#")
              .append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
       List<String> result = new ArrayList<String>();
       int i = 0;
       while (i < s.length()) {
         int delim = s.indexOf('#',i);
         int size = Integer.valueOf(s.substring(i,delim));
         i = delim + size + 1;
         result.add(s.substring(delim+1,i));
         
       }

       return result;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
