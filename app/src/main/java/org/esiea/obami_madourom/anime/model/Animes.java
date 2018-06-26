package org.esiea.obami_madourom.anime.model;

/**
 * Created by Splendeurs 23/06/2018
 */
public class Animes {

    private String name;
    private String description;
    private String rating;
    private int nbre_episode;
    private String categorie;
    private String studio;
    private String image_url;

    public Animes() {
    }

    public Animes(String name, String description, String rating, int nbre_episode, String categorie, String studio, String image_url) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nbre_episode = nbre_episode;
        this.categorie = categorie;
        this.studio = studio;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public int getNbre_episode() {
        return nbre_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getStudio() {
        return studio;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNbre_episode(int nbre_episode) {
        this.nbre_episode = nbre_episode;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
