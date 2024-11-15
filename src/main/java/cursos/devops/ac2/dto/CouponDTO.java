package cursos.devops.ac2.dto;

import cursos.devops.ac2.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {
    private Double discount;
    private Boolean isSpent = false;

    public static CouponDTO fromEntity(Coupon coupon) {
        return new CouponDTO(
                coupon.getDiscount(),
                coupon.getIsSpent()
        );
    }
}
