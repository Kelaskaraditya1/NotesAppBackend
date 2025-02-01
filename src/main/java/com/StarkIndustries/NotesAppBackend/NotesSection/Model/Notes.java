package com.StarkIndustries.NotesAppBackend.NotesSection.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column(name = "title")
    private String title;

    @Column(name = "content",length = 10000)
    private String content;

    @Column(name = "time_stamp")
    private String timeStamp;

    @Column(name = "username",nullable = false)
    private String username;

    public Notes(int noteId, String title, String content, String timeStamp, String username) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
        this.username = username;
    }

    public Notes(String title, String content, String timeStamp, String username) {
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
        this.username = username;
    }

    public Notes(String title, String content, String timeStamp) {
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public Notes() {
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
