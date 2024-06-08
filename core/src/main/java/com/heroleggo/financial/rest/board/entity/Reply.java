package com.heroleggo.financial.rest.board.entity;

import com.heroleggo.financial.rest.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "replies")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reply {
    @Id
    @Column(name = "reply_id")
    private Long id;

    @Comment("댓글 본문")
    @Column(name = "content", nullable = false)
    private String content;

    @Comment("생성일자")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Comment("수정일자")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
