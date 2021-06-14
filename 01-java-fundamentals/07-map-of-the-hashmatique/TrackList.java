import java.util.HashMap;
import java.util.Map;

public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<>();
        trackList.put("Black or White", "I am tired of this devil I am tired of this stuff I am tired of this business So when the going gets rough I ain't scared of your brother I ain't scared of no sheets I ain't scared of nobody");
        trackList.put("Numb", "I'm tired of being what you want me to be Feeling so faithless, lost under the surface Don't know what you're expecting of me Put under the pressure of walking in your shoes");
        trackList.put("Treasure", "Track 3 On ATEEZ - TREASURE EP.1 : All to Zero (English Translation) View Tracklist ATEEZ - Treasure (English Translation) Genius English Translations Release Date October 24, 2018 View All Credits 1 8.3K 2 The shining treasure over there It’s beckoning to you, that treasure Everyone’s chasing after pleasure Going more and more blind, crazy Taking a step up I’m desperate, give me some more Higher and higher I want you more, tell me some more I want you to ready Don’t waste it no more");
        trackList.put("Answer", "Let’s make a toast like a thunder Fill in everything As much as it overflows Raise your glasses over your heads As high as they can be seen anywhere I got the answer");
    
        System.out.println(trackList.get("Answer"));

        for (Map.Entry<String, String> track : trackList.entrySet()) {
            System.out.println(track.getKey() + ": " + track.getValue());
        }

    
    }

} 