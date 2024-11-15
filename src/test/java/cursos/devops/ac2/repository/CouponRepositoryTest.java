package cursos.devops.ac2.repository;

import cursos.devops.ac2.entity.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CouponRepositoryTest {

    @Autowired CouponRepository couponRepository;

    @Test
    public void ShouldCreateCouponProperly() {
        // Arrange
        Coupon coupon = new Coupon(25d);

        // Action
        couponRepository.save(coupon);

        // Assertion
        assertEquals(couponRepository.findAll().size(), 1);

        assertEquals(couponRepository.getById(1L).hashCode(), coupon.hashCode());
    }

}
