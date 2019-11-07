package com.leetcode.jolyon.amazon;

import java.util.*;

public class FavoriteGenres {
    public Map<String, List<String>> favGenres(Map<String, List<String>> userSongs, Map<String, List<String>> genres) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songsToGenre = new HashMap<>();
        for (String genre : genres.keySet()) {
            List<String> songs = genres.get(genre);
            for (String song : songs) {
                songsToGenre.put(song, genre);
            }
        }
        for (String user : userSongs.keySet()) {
            List<String> songList = userSongs.get(user);
            Map<String, Integer> count = new HashMap<>();
            int maxFreq = 0;
            for (String song : songList) {
                String genre = songsToGenre.get(song);
                count.put(genre, count.getOrDefault(genre, 0) + 1);
                maxFreq = Math.max(maxFreq, count.get(genre));
            }
            List<String> list = new ArrayList<>();
            for (String genre : count.keySet()) {
                if (count.get(genre) == maxFreq) {
                    list.add(genre);
                }
            }
            res.put(user, list);


        }
        return res;
    }
}
