package com.sette.clipping.main.charts;

public class ChartsModelClipsByDate {
    private String date_of_clip;
    private Integer clips_per_date;

    public ChartsModelClipsByDate() {
    }

    public ChartsModelClipsByDate(String date_of_clip, Integer clips_per_date) {
        this.date_of_clip = date_of_clip;
        this.clips_per_date = clips_per_date;
    }

    public String getDate_of_clip() {
        return date_of_clip;
    }

    public void setDate_of_clip(String date_of_clip) {
        this.date_of_clip = date_of_clip;
    }

    public Integer getClips_per_date() {
        return clips_per_date;
    }

    public void setClips_per_date(Integer clips_per_date) {
        this.clips_per_date = clips_per_date;
    }

    @Override
    public String toString() {
        return "ChartsModelClipsByDate{" +
                "date_of_clip='" + date_of_clip + '\'' +
                ", clips_per_date=" + clips_per_date +
                '}';
    }
}


