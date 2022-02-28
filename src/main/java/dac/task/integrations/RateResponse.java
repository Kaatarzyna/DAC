package dac.task.integrations;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RateResponse {

    String table;
    String currency;
    String code;

    List<Rate> rates;

    public Integer findRate() {
        Rate firstRate = rates.stream().findFirst().orElse(null);
        if (firstRate == null) {
            return null;
        }

        return firstRate.mid.intValue();
    }
}
