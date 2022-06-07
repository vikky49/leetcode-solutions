class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueEmails = new HashSet<>();
        
          for(String email : emails) {
              
              String[] parts = email.split("@");
              
              String[] localParts = parts[0].split("\\+");
              
              String uniqueEmail = localParts[0].replace(".","") + "@" + parts[1];
             
              uniqueEmails.add(uniqueEmail);
             
          }
        return uniqueEmails.size();
    }
}
