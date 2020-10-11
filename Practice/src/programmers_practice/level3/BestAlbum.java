package programmers_practice.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Song[] songs = new Song[plays.length];

        HashMap<String, Integer> genrePlayTimes = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            if (genrePlayTimes.containsKey(g)) {
                genrePlayTimes.replace(g, genrePlayTimes.get(g) + plays[i]);
            } else {
                genrePlayTimes.put(g, plays[i]);
            }
            songs[i] = new Song(i, genres[i], plays[i]);
        }

        Arrays.sort(songs, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                int gpt1 = genrePlayTimes.get(o1.genre);
                int gpt2 = genrePlayTimes.get(o2.genre);
                if(gpt1<gpt2){
                    return 1;
                }else if(gpt1==gpt2){
                    if(o1.times<o2.times){
                        return 1;
                    }else if(o1.times==o2.times){
                        if(o1.id<o2.id){
                            return -1;
                        }else if(o1.id==o2.id){
                            return 0;
                        }else{
                            return 1;
                        }
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        });

        ArrayList<Integer> ans = new ArrayList<>();
        int same = 0;
        String prev = "";
        for(int i=0;i<songs.length;i++){
//            System.out.println(same+","+songs[i].genre+","+prev);

            if(prev.equals(songs[i].genre)){
//                System.out.println("same");
                if(same>=2) continue;
                same++;
            }else{
                same = 1;
            }
            ans.add(songs[i].id);
            prev = songs[i].genre;
        }

        int[] answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    class Song {
        int id;
        String genre;
        int times;

        Song(int id, String g, int t) {
            this.id = id;
            genre = g;
            times = t;
        }
    }
}
