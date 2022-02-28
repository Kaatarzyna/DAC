package dac.task.bidding;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BidValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BidConstraint {

    String message() default "You have been outbid! Need to offer more :)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
