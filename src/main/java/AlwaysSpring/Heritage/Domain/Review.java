package AlwaysSpring.Heritage.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heritage_id")
    public CulturalHeritage heritage;

    public String writer;

    @Column(length = 2000)
    public String content;

    private String created_at;

    //====================생성 메서드===================//
    public static Review createReview(CulturalHeritage culturalHeritage, String writer, String content) {
        Review review = new Review();
        review.heritage = culturalHeritage;
        review.writer = writer;
        review.content = content;
        review.created_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm"));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm")));
        return review;
    }

}
