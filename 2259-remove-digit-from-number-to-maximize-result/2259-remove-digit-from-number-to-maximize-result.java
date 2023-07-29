class Solution {
    public String removeDigit(String number, char digit) {
        List<String> deletedList = new ArrayList<>();
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(c == digit){
                String newNum = number.substring(0, i) + number.substring(i+1, number.length());
                System.out.println(newNum);
                deletedList.add(newNum);
            }
        }
        Collections.sort(deletedList);
        return deletedList.get(deletedList.size() - 1);
    }
}