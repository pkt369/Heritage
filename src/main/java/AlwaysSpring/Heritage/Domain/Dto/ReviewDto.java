package AlwaysSpring.Heritage.Domain.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDto {
    private Long heritageId;
    private String content;
}
