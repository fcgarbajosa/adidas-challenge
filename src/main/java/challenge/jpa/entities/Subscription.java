package challenge.jpa.entities;

import javax.persistence.*;

/**
 * The persistent class for the subscription database table.
 */
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String firstName;
    private String gender;
    private String dateOfBirth;
    private String flagOfConsent;
    private Long idCampaign;

    public Subscription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFlagOfConsent() {
        return flagOfConsent;
    }

    public void setFlagOfConsent(String flagOfConsent) {
        this.flagOfConsent = flagOfConsent;
    }

    public Long getIdCampaign() {
        return idCampaign;
    }

    public void setIdCampaign(Long idCampaign) {
        this.idCampaign = idCampaign;
    }
}
