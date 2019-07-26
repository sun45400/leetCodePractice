package com.colon.leetcode.practice;

public class NO10_RegularExpressionMatch {

    public static void main(String[] args){
        isMatch("aa","a");
    }
    public boolean isMatchSimple(String s, String p) {
        if(p.equals("")) return s.equals("");
        boolean firstMatch = (!s.isEmpty() && match(s.charAt(0),p.charAt(0)));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (firstMatch && isMatchSimple(s.substring(1),p)) || isMatchSimple(s,p.substring(2));
        }else{
            return firstMatch && isMatchSimple(s.substring(1),p.substring(1));
        }
    }

    static Boolean[][] match;//存中间结果

    public static boolean isMatch(String s, String p){
        match = new Boolean[s.length() + 1][p.length() + 1];
        return matchByIndex(0,0,s,p);
    }

    public static boolean match(char c,char pc){
        return c == pc || pc ==  '.';
    }

    public static boolean matchByIndex(int sLoc,int pLoc, String s, String p){
        if(match[sLoc][pLoc] != null) return match[sLoc][pLoc];
        String newS = s.substring(sLoc);
        String newP = p.substring(pLoc);
        if(newP.equals("")) {
            match[sLoc][pLoc] = newS.equals("");
            return match[sLoc][pLoc];
        }
        boolean ans;
        boolean firstMatch = (!newS.equals("") && match(newS.charAt(0),newP.charAt(0)));
        if(newP.length() >= 2 && newP.charAt(1) == '*'){
            ans = (firstMatch && matchByIndex(sLoc+1,pLoc,s,p)) || matchByIndex(sLoc,pLoc + 2,s,p);
        }else{
            ans = firstMatch && matchByIndex(sLoc + 1,pLoc + 1,s,p);
        }
        match[sLoc][pLoc] = ans;
        return ans;
    }
}
