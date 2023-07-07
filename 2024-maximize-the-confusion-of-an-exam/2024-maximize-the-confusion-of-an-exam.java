class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // return twoPassMethod(answerKey, k);

        return onePassMethod(answerKey, k);
    }

    public int onePassMethod(String answerKey, int k){
        int ans = 0;
        int left = 0, right = 0;
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('F', 0);
        freq.put('T', 0);

        while(right < answerKey.length()){
            char c = answerKey.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while(Math.min(freq.get('T'), freq.get('F')) > k){
                char d = answerKey.charAt(left);
                freq.put(d, freq.getOrDefault(d, 0) - 1);
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public int twoPassMethod(String answerKey, int k){
        int n = answerKey.length();
        int ans = 0;
        int left = 0, right = 0;
        int count = 0;
        
        // Checking For longest length 'T'
        while(right < n){
            if(answerKey.charAt(right) == 'F') count++;

            while(count > k){
                if(answerKey.charAt(left) == 'F'){
                    count--; 
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        // Resetting Values
        count = 0;
        right = 0;
        left = 0;

        // Checking For longest length 'F'
        while(right < n){
            if(answerKey.charAt(right) == 'T') count++;

            while(count > k){
                if(answerKey.charAt(left) == 'T'){
                    count--; 
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}