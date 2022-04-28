package com.technews.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

// makes this as a persistable object
// so the User class can map to a table
@Entity
// say which properties should be ignored when serializing this object
// to json
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// name of the table this class maps to
// by default would be class name
@Table(name="user")



public class User implements Serializable {

    // @Id says id will be unique
    // will be generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Transient // Not saved to DB
    boolean loggedIn;

    // Eager this list will gather all information immediately after being created
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;
    // Need to use FetchType.Lazy to resolve multiple bags exception
    // Lazy will fetch data only as it needs it
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public User(Integer id, String username, String email, String password)  {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username)  {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email)  {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public List<Post> getPosts() {
        return posts;
    }

    public List<Vote> getVotes() {
        return votes;
    }
    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    public List<Comment>getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if(!(o instanceof User)) return false;
        User user = (User) o;
        return isLoggedIn() == user.isLoggedIn() &&
                Objects.equals(getId(), user.getId())  &&
                Objects.equals(getUsername(), user.getEmail()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPosts(), user.getPosts()) &&
                Objects.equals(getVotes(), user.getVotes()) &&
                Objects.equals(getComments(), user.getComments());

    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getPassword(), isLoggedIn(), getPosts(), getVotes(), getComments());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", posts=" + posts +
                ", votes=" + votes +
                ", comments=" + comments +
                '}';
    }




}
