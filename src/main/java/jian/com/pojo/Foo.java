package jian.com.pojo;

import javax.validation.constraints.NotNull;

import org.apache.solr.client.solrj.beans.Field;

public class Foo {
    @NotNull(message="id不为空")
    @Field("id")
    private String id;

    @Field("title")
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Foo [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append("]");
        return builder.toString();
    }

}