import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredUnderLimitAndAmountTooSmall() {
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredUnderLimitAndAmountIsZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredUnderLimitAndAmountIsTooBig() {
        BonusService service = new BonusService();

        long amount = 2_000_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredUnderLimitAndAmountIsEqual() {
        BonusService service = new BonusService();

        long amount = 16670;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    //@org.junit.jupiter.api.Test
    //void shouldCalculateForRegisteredUnderLimitAndAmountIsNegative() {
    //    BonusService service = new BonusService();
    //
    //    long amount = -100;
    //    boolean registered = true;
    //    long expected = 0;
    //
    //    long actual = service.calculate(amount, registered);
    //
    //    assertEquals(expected, actual);
    //}

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredUnderLimitAndAmountTooSmall() {
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredUnderLimitAndAmountIsZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredUnderLimitAndAmountIsTooBig() {
        BonusService service = new BonusService();

        long amount = 2_000_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredUnderLimitAndAmountIsEqual() {
        BonusService service = new BonusService();

        long amount = 50000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}