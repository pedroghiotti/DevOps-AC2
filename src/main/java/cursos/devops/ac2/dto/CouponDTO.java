package cursos.devops.ac2.dto;

import cursos.devops.ac2.entity.Coupon;
import cursos.devops.ac2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {
    private Long id;
    private Double discount;
    private Course course;

    public static CouponDTO fromEntity(Coupon coupon) {
        CouponDTO couponDTO = new CouponDTO(
                coupon.getId(),
                coupon.getDiscount(),
                coupon.getCourse()
        );

        return couponDTO;
    }
}
