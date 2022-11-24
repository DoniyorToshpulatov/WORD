package org.example.dto;

public class Word {
    private Integer id;
    private String name;
    private  String translate;

    private  String description;
    public Word() {
    }

    public Word(String name, String translate, String description) {
        this.name = name;
        this.translate = translate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", translate='" + translate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
