package subway.domain.fare;

public interface FarePolicy {

    int calculate(final FareInformation fareInformation);
}
