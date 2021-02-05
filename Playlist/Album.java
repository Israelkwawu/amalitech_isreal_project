/*
 ** Name : Israel Kwawu
 ** Programming Lab: 4
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){

        if (this.findSong(title) == null){
            return   songs.add(new Song(title,duration));
        }
        return false;

    }

    private Song findSong(String title){
        if (!songs.isEmpty()){
            Song song = null;
            for (int i = 0 ; i < songs.size();i++){
                if (title.equals(songs.get(i).getTitle())){
                    song = songs.get(i);
                    break;
                }
            }
            return song;
        }else {
            return null;
        }
    }

    public boolean addToPlayList(int numberOfTracksInAlbum, LinkedList playlist){
        if (numberOfTracksInAlbum != 0 && !this.songs.isEmpty()){
            boolean isAdded = false;
            Song song = null;
            for (int k = 0; k<numberOfTracksInAlbum; k++){
                song = findSong(this.songs.get(k).getTitle());
                if ( song != null){
                   isAdded = playlist.add(song);
                }
            }
            return isAdded;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList playlist){
        Song song = this.findSong(title);
        if ( song != null){
            return playlist.add(song);
        }

        return false;
    }


}
