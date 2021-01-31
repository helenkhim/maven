import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegistredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateRegistredAndOverLimit() {
        BonusService service = new BonusService();


        long amount = 26000_60;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateUnregistredAndOverLimit() {
        BonusService service = new BonusService();


        long amount = 26000_60;
        boolean registered = false;
        long expected = 260;


        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnregistredAndUnderLimit() {
        BonusService service = new BonusService();


        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;


        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateUnregistredAndLimit() {
        BonusService service = new BonusService();


        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegistredAndLimit() {
        BonusService service = new BonusService();


        long amount = 1_666_667;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}