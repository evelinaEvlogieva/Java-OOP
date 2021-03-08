package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test
    public void defaultAlarmValueOnCreationIsOff(){
        Alarm alarm = new Alarm(new Sensor());

        assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWihtLowerBound(){
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.5);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOnAfterCheckingSensorWihtUpperBound(){
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.5);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmValueShouldBeOffAfterCheckingSensorWihtinBounds(){
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.5);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }
}