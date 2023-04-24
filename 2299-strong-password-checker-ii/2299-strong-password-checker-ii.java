class Solution {
    public boolean strongPasswordCheckerII(String password) {
        String sp = "!@#$%^&*()-+";
        boolean len = false, lower = false, upper = false, digit = false, special = false, adj = true;
        if(password.length() >= 8) len = true;
        for(int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(c >= 'a' && c <= 'z') lower = true;
            if(c >= 'A' && c <= 'Z') upper = true;
            if(c >= '0' && c <= '9') digit = true;
            if(sp.indexOf(c) >= 0) special = true;
            if(i + 1 < password.length()) if(c == password.charAt(i+1)) adj = false;
        }
        return (len && lower && upper && digit && special && adj);
    }
}