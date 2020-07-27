package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class GiftItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 5, message = "Minimal length is 5 symbols")
    private String title;
    private LocalDateTime createdAt;

    GiftItem(Long id, @NotEmpty @Size(min = 5, message = "Minimal length is 5 symbols") String title, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public static GiftItemBuilder builder() {
        return new GiftItemBuilder();
    }

    @PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public @NotEmpty @Size(min = 5, message = "Minimal length is 5 symbols") String getTitle() {
        return this.title;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotEmpty @Size(min = 5, message = "Minimal length is 5 symbols") String title) {
        this.title = title;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GiftItem)) return false;
        final GiftItem other = (GiftItem) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GiftItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    public String toString() {
        return "GiftItem(id=" + this.getId() + ", title=" + this.getTitle() + ", createdAt=" + this.getCreatedAt() + ")";
    }

    public static class GiftItemBuilder {
        private Long id;
        private @NotEmpty @Size(min = 5, message = "Minimal length is 5 symbols") String title;
        private LocalDateTime createdAt;

        GiftItemBuilder() {
        }

        public GiftItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GiftItemBuilder title(@NotEmpty @Size(min = 5, message = "Minimal length is 5 symbols") String title) {
            this.title = title;
            return this;
        }

        public GiftItemBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public GiftItem build() {
            return new GiftItem(id, title, createdAt);
        }

        public String toString() {
            return "GiftItem.GiftItemBuilder(id=" + this.id + ", title=" + this.title + ", createdAt=" + this.createdAt + ")";
        }
    }
}
