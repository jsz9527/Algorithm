package traceBack;

import java.util.ArrayList;
import java.util.List;

public class L93_restoreIpAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        new L93_restoreIpAddresses().restoreIpAddresses(s);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        traceBack(result, "", s, 0, 1);
        return result;
    }

    public void traceBack(List<String> result, String ele, String s, int index, int deep){
        for(int len=1; len<=3; len++){
            if(deep==3){
                int restLen = s.length() - (index + len);
                if( 1 <= restLen &&  restLen <= 3){
                    String part3 = s.substring(index, index+len);
                    String part4 = s.substring(index+len);
                    if(isValid(part3) && isValid(part4)){
                        String tempEle = ele + "." + part3 + "." + part4;
                        result.add(tempEle.substring(1));
                    }
                }
            }else {
                int restLen = s.length() - (index + len);
                if( 1 <= restLen &&  restLen <= (4-deep)*3 ){
                    String part = s.substring(index, index+len);
                    if(isValid(part)){
                        String tempEle = ele + "." + part;
                        traceBack(result, tempEle, s, index+len, deep+1);
                    }
                }
            }
        }
    }

    public boolean isValid(String part){
        if(part.length() >1 && part.startsWith("0")){
            return false;
        }
        if(Integer.parseInt(part) > 255){
            return false;
        }
        return true;
    }
}
