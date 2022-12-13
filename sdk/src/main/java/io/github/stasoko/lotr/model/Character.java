package io.github.stasoko.lotr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Plain Old Java Object (POJO) representing a character in the LOTR.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    @JsonProperty("_id")
    private String id = "";
    private String height = "";
    private String race = "";
    private String gender = "";
    private String birth = "";
    private String spouse = "";
    private String death = "";
    private String realm = "";
    private String hair = "";
    private String name = "";
    private String wikiUrl = "";

    /**
     * The default constructor
     *
     */
    public Character() {}

    /**
     * A constructor that sets fields, used for unit testing
     *
     * @param  id  the unique identifier of the character
     * @param  height  the height of the character, format varies
     * @param  race  the race of the character, Human, Elf, etc.
     * @param  gender the character's gender, Male, etc.
     * @param  birth  the character's date of birth, format varies
     * @param  spouse the name of the character's spouse, often blank
     * @param  death  the character's date of death, format varies
     * @param  realm  the realm to which the character belongs
     * @param  hair  the character's color, if known, often blank
     * @param  name the character's name
     * @param wikiUrl a link to the character's description on the LOTR wiki
     */
    public Character(String id, String height, String race, String gender,
                     String birth, String spouse, String death, String realm,
                     String hair, String name, String wikiUrl) {
        this.id = id;
        this.height = height;
        this.race = race;
        this.gender = gender;
        this.birth = birth;
        this.spouse = spouse;
        this.death = death;
        this.realm = realm;
        this.hair = hair;
        this.name = name;
        this.wikiUrl = wikiUrl;
    }

    /**
     * A getter method for the unique identifier
     *
     * @return  the unique identifier of the character
     */
    public String getId() {
        return id;
    }

    /**
     * A setter method for the unique identifier
     *
     * @param  id  the unique identifier of the character
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * A getter method for the character's height
     *
     * @return  the height of the character, format varies
     */
    @SuppressWarnings("unused")
    public String getHeight() {
        return height;
    }

    /**
     * A setter method for the character's height
     *
     * @param height the height of the character, format varies
     */
    @SuppressWarnings("unused")
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * A getter method for the character's race
     *
     * @return  the race of the character, Human, Elf, etc.
     */
    public String getRace() {
        return race;
    }

    /**
     * A setter method for the character's race
     *
     * @param race  the race of the character, Human, Elf, etc.
     */
    @SuppressWarnings("unused")
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * A getter method for the character's gender
     *
     * @return  the character's gender, Male, etc
     */
    @SuppressWarnings("unused")
    public String getGender() {
        return gender;
    }

    /**
     * A setter method for the character's gender
     *
     * @param gender  the character's gender, Male, etc
     */
    @SuppressWarnings("unused")
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * A getter method for the character's date of birth
     *
     * @return  the character's date of birth, format varies
     */
    @SuppressWarnings("unused")
    public String getBirth() {
        return birth;
    }

    /**
     * A setter method for the character's date of birth
     *
     * @param birth  the character's date of birth, format varies
     */
    @SuppressWarnings("unused")
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * A getter method for the character's spouse
     *
     * @return  the name of the character's spouse, often blank
     */
    @SuppressWarnings("unused")
    public String getSpouse() {
        return spouse;
    }

    /**
     * A setter method for the character's spouse
     *
     * @param spouse  the name of the character's spouse, often blank
     */
    @SuppressWarnings("unused")
    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    /**
     * A getter method for the character's date of death
     *
     * @return  the character's date of death, format varies
     */
    @SuppressWarnings("unused")
    public String getDeath() {
        return death;
    }

    /**
     * A setter method for the character's date of death
     *
     * @param death  the character's date of death, format varies
     */
    @SuppressWarnings("unused")
    public void setDeath(String death) {
        this.death = death;
    }

    /**
     * A getter method for the character's realm
     *
     * @return  the realm to which the character belongs
     */
    @SuppressWarnings("unused")
    public String getRealm() {
        return realm;
    }

    /**
     * A setter method for the character's realm
     *
     * @param realm  the realm to which the character belongs
     */
    @SuppressWarnings("unused")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    /**
     * A getter method for a description of the character's hair
     *
     * @return  the character's color, if known, often blank
     */
    @SuppressWarnings("unused")
    public String getHair() {
        return hair;
    }

    /**
     * A setter method for a description of the character's hair
     *
     * @param hair  the character's color, if known, often blank
     */
    @SuppressWarnings("unused")
    public void setHair(String hair) {
        this.hair = hair;
    }

    /**
     * A getter method for the character's name
     *
     * @return  the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * A setter method for the character's name
     *
     * @param name  the name of the character
     */
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter method for a link to the character's wiki description
     *
     * @return  a link to the character's description on the LOTR wiki
     */
    @SuppressWarnings("unused")
    public String getWikiUrl() {
        return wikiUrl;
    }

    /**
     * A setter method for a link to the character's wiki description
     *
     * @param wikiUrl  a link to the character's description on the LOTR wiki
     */
    @SuppressWarnings("unused")
    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", height='" + height + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", spouse='" + spouse + '\'' +
                ", death='" + death + '\'' +
                ", realm='" + realm + '\'' +
                ", hair='" + hair + '\'' +
                ", name='" + name + '\'' +
                ", wikiUrl='" + wikiUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id.equals(character.id) && Objects.equals(height, character.height) && Objects.equals(race, character.race) && Objects.equals(gender, character.gender) && Objects.equals(birth, character.birth) && Objects.equals(spouse, character.spouse) && Objects.equals(death, character.death) && Objects.equals(realm, character.realm) && Objects.equals(hair, character.hair) && Objects.equals(name, character.name) && Objects.equals(wikiUrl, character.wikiUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, race, gender, birth, spouse, death, realm, hair, name, wikiUrl);
    }
}
