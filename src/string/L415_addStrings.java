package string;

public class L415_addStrings {

    public static void main(String[] args) {
        System.out.println(new L415_addStrings().addStrings("11", "123"));
        System.out.println(new L415_addStrings().addStrings_abc("bb", "bcd"));
    }

    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        
        int lenMin;
        int lenMax;
        char[] charsMax;
        if(len2>= len1){
            lenMin = len1;
            lenMax = len2;
            charsMax = chars2;
        }else {
            lenMin = len2;
            lenMax = len1;
            charsMax = chars1;
        }
        
        char temp = '0';
        
        for(int i=1; i<=lenMax; i++){
            char sum ='0';
            if(i<=lenMin){
                char c1 = chars1[len1-i];
                char c2 = chars2[len2-i];
                sum = (char)(c1-'0'+c2-'0'+temp-'0'+'0');
            }else {
                char c = charsMax[lenMax-i];
                sum = (char)(c-'0'+temp-'0'+'0');
            }

            if(sum > '9' ){
                charsMax[lenMax-i] =  (char)( (sum-'9') + ('0'-1) );
                temp = '1';
            }else {
                charsMax[lenMax-i] =  sum;
                temp = '0';
            }
        }

        if(temp == '0'){
            return String.valueOf(charsMax);
        }else {
            return "1" + String.valueOf(charsMax);
        }
    }

    public String addStrings_abc(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();

        int lenMin;
        int lenMax;
        char[] charsMax;
        if(len2>= len1){
            lenMin = len1;
            lenMax = len2;
            charsMax = chars2;
        }else {
            lenMin = len2;
            lenMax = len1;
            charsMax = chars1;
        }

        char temp = 'a';

        for(int i=1; i<=lenMax; i++){
            char sum ='a';
            if(i<=lenMin){
                char c1 = chars1[len1-i];
                char c2 = chars2[len2-i];
                sum = (char)(c1-'a'+c2-'a'+temp-'a'+'a');
            }else {
                char c = charsMax[lenMax-i];
                sum = (char)(c-'a'+temp-'a'+'a');
            }

            if(sum > 'g' ){
                charsMax[lenMax-i] =  (char)( (sum-'g') + ('a'-1) );
                temp = 'b';
            }else {
                charsMax[lenMax-i] =  sum;
                temp = 'a';
            }
        }

        if(temp == 'a'){
            return String.valueOf(charsMax);
        }else {
            return "1" + String.valueOf(charsMax);
        }
    }

}
