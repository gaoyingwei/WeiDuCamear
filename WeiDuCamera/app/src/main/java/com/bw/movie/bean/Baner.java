package com.bw.movie.bean;

public class Baner {
   public String imageUrl;
   public int followMovie;
   public int id;
   public String name;
   public int rank;
   public String summary;

    public Baner(String imageUrl, int followMovie, int id, String name, int rank, String summary) {
        this.imageUrl = imageUrl;
        this.followMovie = followMovie;
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(int followMovie) {
        this.followMovie = followMovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Baner{" +
                "imageUrl='" + imageUrl + '\'' +
                ", followMovie=" + followMovie +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", summary='" + summary + '\'' +
                '}';
    }
}
