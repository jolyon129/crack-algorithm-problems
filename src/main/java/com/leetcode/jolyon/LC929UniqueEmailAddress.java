package com.leetcode.jolyon;

import java.util.HashSet;
import java.util.Set;

public class LC929UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();
        for(int i=0; i<emails.length;i++){
            String[] split = emails[i].split("@");
            String name = split[0];
            StringBuilder sb = new StringBuilder();
            for(int j =0; j<name.length();j++){
                if(name.charAt(j)=='.'){
                    continue;
                }else if(name.charAt(j)=='+'){
                    j = name.length();
                }else{
                    sb.append(name.charAt(j));
                }
            }
            emailsSet.add(sb.toString()+"@"+split[1]);
        }
        return emailsSet.size();
    }
}
