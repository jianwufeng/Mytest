package jian.com.pojo;

import javax.validation.constraints.NotNull;

import org.apache.solr.client.solrj.beans.Field;

public class Foo {
    @NotNull(message = "id不为空")
    @Field("id")
    private Long id;

    @Field("title")
    private String title;

    @Field("name")
    private String name;

    // private String keyword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Foo [id=" + id + ", title=" + title + ", name=" + name + "]";
    }

    public void setName(String name) {
        this.name = name;
    }

}
