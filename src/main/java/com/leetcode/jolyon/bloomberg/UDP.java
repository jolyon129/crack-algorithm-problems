package com.leetcode.jolyon.bloomberg;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一轮：
 *
 * 两位烙印哥。 一位完全美式口音，听起来非常舒服，来接我之后带我参观了办公楼，闲聊许多，人很nice。另一位稍有印度口音。先聊简历，问了why BB，然后他们自我介绍。
 *
 * 第一题， 情景是UDP传输，假设收到许多out of order的sequence（带序号的内容），排序组装后按顺序打印完整的内容， 例如，
 * input:
 * [1,"a"]    // 立刻输出a
 * [2,"b"]    // 立刻输出b
 * [4,"d"]    // 无输出，缺sequence 3
 * [3,"c"]    // 立刻输出cd
 *
 * input:
 * {1,"aaa"}, {3,"ccc"}, {2,"bbb"}, {4,"ddd"}
 * output:
 * "aaa", "", "bbb ccc", "ddd"
 *
 * 问时间空间复杂度，答了之后followup，说如果数据段的数量非常大，O(n)
 * 的space太贵了，该怎么办。这里聊了好一会，我才理解面试官想要的是streaming的做法。 Follow
 * up情景就是，你收到一个消息立刻就要发送给客户（而非打印），并且不需要每次都从头开始（a,b,c,d rather than a, ab,
 * abcd)， 给了提示不用排序，目标是降低空间复杂度。
 */
public class UDP {
    Map<Integer, String> timeToText = new HashMap<>();
    int nextIdx = 1;
    String receive(int time, String text){
        timeToText.put(time, text);
        if(time==nextIdx){
            StringBuilder res = new StringBuilder();
            while (timeToText.containsKey(time)){
                res.append(timeToText.get(time));
                // remove the current one
                timeToText.remove(time);
                time++;
            }
            return res.toString();
        }else{
            return null;
        }
    }
}
