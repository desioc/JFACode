package com.claudiodesio.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "song")
// optionally we can specify the order in which the fields will be written
// with the XmlType annotation that specifies the propOrder element:
@XmlType(propOrder = {"name", "artist", "album", "year"})
public class Song {

    private String name;
    private String artist;
    private String album;
    private String year;

    // we can change the name in the XML output by adding the annotation
    // XmlElement specifying a different name
    @XmlElement(name = "title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song: " + "title=" + name + ", artist=" + artist + ", album=" + album + ", year=" + year;
    }

}