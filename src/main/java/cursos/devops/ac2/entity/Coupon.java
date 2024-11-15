package cursos.devops.ac2.entity;

import cursos.devops.ac2.dto.CouponDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private Double discount;

    private Boolean isSpent = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    public Coupon(CouponDTO couponDTO) {
        this.discount = couponDTO.getDiscount();
        this.isSpent = couponDTO.getIsSpent();
    }

    public static Coupon fromDTO(CouponDTO couponDTO) {
        return new Coupon(couponDTO);
    }

}
